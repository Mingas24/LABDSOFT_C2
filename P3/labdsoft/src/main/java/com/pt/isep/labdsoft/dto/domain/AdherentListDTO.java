package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdherentListDTO {

    public String fullName;
    public String age;
    public String nationality;
    public String job;
    public String celebrity;
}