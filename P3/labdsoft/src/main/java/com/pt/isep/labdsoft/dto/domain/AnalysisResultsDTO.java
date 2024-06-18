package com.pt.isep.labdsoft.dto.domain;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnalysisResultsDTO {

    private Map<String, List<Object>> analysisResults;
}
