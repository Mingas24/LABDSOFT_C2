package com.pt.isep.healthtracker.dto;

import lombok.*;

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
