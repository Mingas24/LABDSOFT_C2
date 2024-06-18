package com.pt.isep.labdsoft.util;

import com.pt.isep.labdsoft.dto.AnalysisResultDTO;
import org.springframework.data.util.Pair;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Component
public class AnalysisResultConverter {

    public AnalysisResultDTO toDTO(Map<String, List<Object>> analysisResults){
        return AnalysisResultDTO.builder().analysisResults(analysisResults).build();
    }
}
