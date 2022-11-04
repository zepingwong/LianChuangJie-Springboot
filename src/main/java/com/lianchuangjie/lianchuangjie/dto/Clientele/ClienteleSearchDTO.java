package com.lianchuangjie.lianchuangjie.dto.Clientele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteleSearchDTO {
    private Long userSign;
    private String cardName;
    private String cardCode;
}
