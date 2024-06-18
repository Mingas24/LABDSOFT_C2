package com.pt.isep.labdsoft.dto.ui;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UITransplantRecipientFormDataDTO {

    private List<String> bloodTypes;
    private List<String> statesOfUrgency;
    private List<String> organTypes;
    private List<String> hlaTypes;
}
