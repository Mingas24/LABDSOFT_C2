package com.pt.isep.healthtracker.service;

import com.pt.isep.healthtracker.dto.HealthTrackerResultDTO;
import com.pt.isep.healthtracker.dto.VitalSignsDTO;
import org.springframework.stereotype.Service;


@Service
public class HealthTrackerService {

    public HealthTrackerResultDTO checkHealthActivityTracker(VitalSignsDTO vitalSignsDTO) {
        StringBuilder result = new StringBuilder();
        if(Double.valueOf(vitalSignsDTO.getBloodPressure()) > Double.valueOf(vitalSignsDTO.getBloodPressureProtocol())){
            result.append("High blood pressure: actual value " + vitalSignsDTO.getBloodPressure() + " but should be under " + vitalSignsDTO.getBloodPressureProtocol() + "! ");
        }
        if (Double.valueOf(vitalSignsDTO.getBodyTemperature()) > Double.valueOf(vitalSignsDTO.getBodyTemperatureProtocol())){
            result.append("High Body Temperature: actual value " + vitalSignsDTO.getBodyTemperature() + " but should be under " + vitalSignsDTO.getBodyTemperatureProtocol() + "! ");
        }
        if (Double.valueOf(vitalSignsDTO.getHeartRate()) > Double.valueOf(vitalSignsDTO.getHeartRateProtocol())){
            result.append("High Heart Rate: actual value " + vitalSignsDTO.getHeartRate() + " but should be under " + vitalSignsDTO.getHeartRateProtocol() + "! ");
        }
        return HealthTrackerResultDTO.builder().healthStatus(result.toString()).build();
    }

}
