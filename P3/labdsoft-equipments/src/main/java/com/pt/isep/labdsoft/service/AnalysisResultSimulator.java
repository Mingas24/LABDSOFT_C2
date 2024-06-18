package com.pt.isep.labdsoft.service;

import com.pt.isep.labdsoft.dto.AnalysisResultDTO;
import com.pt.isep.labdsoft.enums.BloodType;
import com.pt.isep.labdsoft.enums.DNAAnalysisData;
import com.pt.isep.labdsoft.enums.ViralAnalysisRefData;
import com.pt.isep.labdsoft.util.AnalysisResultConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.pt.isep.labdsoft.util.Constants.*;

@Service
public class AnalysisResultSimulator {

    @Autowired
    private AnalysisResultConverter analysisResultConverter;

    public AnalysisResultDTO simulateAnalysisResults(List<String> analysisTypes) {
        Map<String, List<Object>> analysesResults = new HashMap<>();
        for (String analyseType : analysisTypes) {
            if (analyseType.equals(DNA_ANALYSIS)) {
                for(DNAAnalysisData dnaAnalysis: DNAAnalysisData.values()){
                    List<Object> objects;
                    if(dnaAnalysis.name().equals("ABO")){
                        List<BloodType> bloodTypes = Arrays.stream(BloodType.values()).toList();
                        Random rand = new Random();
                        BloodType randomElement = bloodTypes.get(rand.nextInt(bloodTypes.size()));
                        objects = Arrays.asList(randomElement.getValue(), null);
                    } else {
                        objects = Arrays.asList(String.valueOf(valueGenerator()), null);
                    }
                    analysesResults.put(dnaAnalysis.name(), objects);
                }
            }
            if (analyseType.equals(VIRAL_ANALYSIS)) {
                for (ViralAnalysisRefData viralAnalysis : ViralAnalysisRefData.values()) {
                    List<Object> objects = valueGeneratorWithRefValues(viralAnalysis.getLowerRefValue(), viralAnalysis.getHigherRefValue(), viralAnalysis.name().contains("MEIA"));
                    analysesResults.put(viralAnalysis.name(), objects);
                }
            }
        }
        return this.analysisResultConverter.toDTO(analysesResults);
    }

    private List<Object> valueGeneratorWithRefValues(double lowerRefValue, double higherRefValue, boolean isMeia) {
        double generatedValue = valueGenerator();
        if (generatedValue < lowerRefValue) {
            return Arrays.asList(generatedValue, isMeia ? NEGATIVE_RESULT : NON_REACTIVE_RESULT);
        }
        if (generatedValue >= higherRefValue) {
            return Arrays.asList(generatedValue, isMeia ? POSITIVE_RESULT : REACTIVE_RESULT);
        }
        return Arrays.asList(generatedValue, INCONCLUSIVE_RESULT);
    }

    private double valueGenerator() {
        Random r = new Random();
        return  Math.floor(r.nextDouble(RESULT_LOWER_RANGE, RESULT_HIGHER_RANGE) * 100) / 100;
    }
}
