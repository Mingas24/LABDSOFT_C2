package com.pt.isep.labdsoft.dto.ui;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UIHealthActivityTrackerFormDataDTO {

    private List<String> transplantRecipientIdentification;

}
