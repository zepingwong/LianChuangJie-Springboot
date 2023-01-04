package com.lianchuangjie.lianchuangjie.controller.Enquiry;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.controller.BaseController;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMatchSaveDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryMatchService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMatchItemVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/enquiry/match")
public class EnquiryMatchController extends BaseController {
    @Resource
    EnquiryMatchService enquiryMatchService;

    /**
     * @param enquirySingleQueryDTO singleQueryDTO
     * @return Result
     * @description 单个型号询价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @PostMapping("single")
    @Authentication(sale = true)
    public Result<List<EnquiryMatchItemVO>> querySingleController(@RequestBody EnquirySingleQueryDTO enquirySingleQueryDTO) {
        List<EnquiryMatchItemVO> list = enquiryMatchService.querySingle(enquirySingleQueryDTO);
        return Result.success(list);
    }

    /**
     * @param enquirySingleQueryDTOList enquirySingleQueryDTOList
     * @return Result
     * @description 多个型号批量询价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @PostMapping("batch")
    @Authentication(sale = true)
    public Result<List<EnquiryMatchItemVO>> queryBatchController(@RequestBody List<String> enquirySingleQueryDTOList) {
        List<EnquiryMatchItemVO> list = enquiryMatchService.queryBatch(enquirySingleQueryDTOList);
        return Result.success(list);
    }
    /**
     * @param docEntry docEntry
     * @return Result
     * @description 根据 BOM 单编号批量询价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    @GetMapping("bom")
    @Authentication(sale = true)
    public Result<List<EnquiryMatchItemVO>> queryBomController(@RequestParam(defaultValue = "#{null}", value = "DocEntry") Long docEntry) {
        List<EnquiryMatchItemVO> result = enquiryMatchService.queryBom(docEntry);
        return Result.success(result, "Success");
    }
    /**
     * @param enquiryMatchSaveDTO enquiryMatchSaveDTO
     * @return Result
     * @description 保存匹配结果
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/6/2022
     */
    @PostMapping("save")
    @Authentication(sale = true)
    public Result<Boolean> saveMatchResultController(@RequestBody EnquiryMatchSaveDTO enquiryMatchSaveDTO) {
        Boolean res = enquiryMatchService.save(enquiryMatchSaveDTO);
        return Result.success(res, "Success");
    }
}
