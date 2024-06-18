package com.pt.isep.labdsoft.dto;

import org.springframework.data.util.Pair;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnalysisResultDTO {

    private Map<String, List<Object>> analysisResults;

}
