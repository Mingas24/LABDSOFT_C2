package com.pt.isep.labdsoft.dto.ui;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UITransplantDonorFormDataDTO {

    private List<String> bloodTypes;
    private List<String> organTypes;
    private List<String> hlaTypes;
}
