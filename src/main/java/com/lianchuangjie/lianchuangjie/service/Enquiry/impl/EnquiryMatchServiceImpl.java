package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMatchHeadDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMatchItemDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMatchSaveDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.Enquiry.EnquiryError;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryBatchMatchMapper;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryBomMatchMapper;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquirySingleMatchMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryMatchService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquirySubService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.YunHanService;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import com.lianchuangjie.lianchuangjie.utils.RedisUtil;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMatchItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncExecutionAspectSupport;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@EnableAsync
public class EnquiryMatchServiceImpl implements EnquiryMatchService {
    @Resource
    EnquirySingleMatchMapper enquirySingleMatchMapper;
    @Resource
    EnquiryBatchMatchMapper enquiryBatchMatchMapper;
    @Resource
    EnquiryBomMatchMapper enquiryBomMatchMapper;
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Resource
    EnquiryMainService enquiryMainService;
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    RedisUtil redisUtil;
    @Resource(name = AsyncExecutionAspectSupport.DEFAULT_TASK_EXECUTOR_BEAN_NAME)
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Resource
    YunHanService yunHanService;

    private void setUserInfo(EnquirySingleQueryDTO enquirySingleQueryDTO) {
        UserEntity user = ContextUtil.getUser();
        enquirySingleQueryDTO.setSlpCode(user.getUserSign());
        enquirySingleQueryDTO.setDeptCode(user.getDftDept());
    }

    @Override
    public List<EnquiryMatchItemVO> querySingle(EnquirySingleQueryDTO enquirySingleQueryDTO) {
        // ??????????????????
        setUserInfo(enquirySingleQueryDTO);
        System.out.println(enquirySingleQueryDTO);
        return enquirySingleMatchMapper.query(enquirySingleQueryDTO);
    }

    @Override
    public List<EnquiryMatchItemVO> queryBatch(List<String> enquirySingleQueryDTOList) {
        UserEntity user = ContextUtil.getUser();
        return enquiryBatchMatchMapper.query(enquirySingleQueryDTOList, user.getDftDept(), user.getUserSign());
    }

    @Override
    public List<EnquiryMatchItemVO> queryBom(Long docEntry) {
        UserEntity user = ContextUtil.getUser();
        return enquiryBomMatchMapper.query(docEntry, user.getDftDept(), user.getUserSign());
    }

    @Override
    public Boolean save(EnquiryMatchSaveDTO enquiryMatchSaveDTO) {
        // ?????????
        UserEntity user = ContextUtil.getUser();
        EnquiryMatchHeadDTO enquiryMatchHead = enquiryMatchSaveDTO.getEnquiryMatchHead();
        EnquiryMainEntity enquiryMainEntity = new EnquiryMainEntity();
        BeanUtils.copyProperties(enquiryMatchHead, enquiryMainEntity);
        // ???????????????
        Long docEntry = enquiryMainMapper.selectMaxDocEntry() + 1;
        enquiryMainEntity.setDocEntry(docEntry);
        // ???????????????????????????
        List<EnquirySubEntity> yunHanList = new ArrayList<>();
        // ???????????????????????????
        boolean res = enquiryMainService.save(enquiryMainEntity);
        // ??????????????????????????????
        EnquiryError.SAVE_ERROR.assertIsFalse(res);
        List<EnquiryMatchItemDTO> list = enquiryMatchSaveDTO.getEnquiryMatchItemList();
        List<EnquirySubEntity> saveList = new ArrayList<>();
        long lineNum = 1;
        for (EnquiryMatchItemDTO item : list) {
            EnquirySubEntity enquirySubEntity = new EnquirySubEntity();
            BeanUtils.copyProperties(item, enquirySubEntity);
            // ????????????????????????????????????
            enquirySubEntity.setDocEntry(docEntry);
            // LineNum ????????????
            enquirySubEntity.setLineNum(lineNum);
            if (Objects.equals(item.getMatch(), "????????????")) {
                // ???????????? ItemId ??????, ????????????????????????LineNum???ItemId ????????? LineNum???
                enquirySubEntity.setItemId(lineNum - 1);
            } else {
                // ??????????????? ItemId ??? LineNum ??????
                enquirySubEntity.setItemId(lineNum);
            }
            // ??????????????????,???????????????????????????,????????????????????? ????????????????????????,??????????????????????????????????????????
            if (enquiryMatchHead.getOldCustomer().equals("Y")) {
                enquirySubEntity.setKeyUser(user.getUserSign());
            }
            // ??????????????????????????????????????????
            if (Objects.equals(item.getStatus(), "E")) {
                // ?????????????????????
                yunHanList.add(enquirySubEntity);
                // ?????????????????????????????????????????????????????????
                enquirySubEntity.setBuyer(null);
                saveList.add(enquirySubEntity);
            } else {
                saveList.add(enquirySubEntity);
            }
            lineNum++;
        }
        redisUtil.setCacheObject("Enquiry:" + docEntry, yunHanList.toString());
        enquirySubService.saveBatch(saveList);
        // ??????????????????
        yunHanService.yunHanQuery(docEntry);
        /*
         * ????????????????????????????????????
         */
        threadPoolTaskExecutor.execute(() -> {
            log.info("????????????");
            try {
                Thread.sleep(5000);
                yunHanService.runSendToBuyer(docEntry);
                log.info("??????????????????");
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
            log.info("????????????");
        });
        return true;
    }
}

