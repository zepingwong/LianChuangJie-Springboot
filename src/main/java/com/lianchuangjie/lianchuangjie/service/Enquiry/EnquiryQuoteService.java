package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.lianchuangjie.lianchuangjie.dto.EnquiryExportSaveDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportDataVO;

public interface EnquiryQuoteService {
    EnquiryExportDataVO list(Long docEntry);
    Boolean save(EnquiryExportSaveDTO enquiryExportSaveDTO);
}
