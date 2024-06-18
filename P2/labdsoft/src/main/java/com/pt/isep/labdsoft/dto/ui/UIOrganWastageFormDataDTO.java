package com.pt.isep.labdsoft.dto.ui;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UIOrganWastageFormDataDTO {
    private List<String> organTypes;
}
