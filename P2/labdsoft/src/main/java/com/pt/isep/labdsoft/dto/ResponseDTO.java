package com.pt.isep.labdsoft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {

    private boolean isSuccess;

    private Object responseObject;

    private int statusCode;


}
