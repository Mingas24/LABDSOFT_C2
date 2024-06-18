package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.InputSampleDTO;

public interface SampleService {

    ResponseDTO registerSample(InputSampleDTO inputSampleDTO);

    ResponseDTO getSamples();

}
