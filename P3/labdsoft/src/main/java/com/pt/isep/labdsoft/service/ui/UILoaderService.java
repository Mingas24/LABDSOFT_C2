package com.pt.isep.labdsoft.service.ui;

import com.pt.isep.labdsoft.dto.ResponseDTO;

public interface UILoaderService {

    ResponseDTO getTransplantRecipientFormData();

    ResponseDTO getTransplantDonorFormData();

    ResponseDTO getAdherentFormData();

    ResponseDTO getOrganWastageFormData();

    ResponseDTO getPatientsFormData();

    ResponseDTO getAnalysisRequestFormData();

    ResponseDTO getChangeStateOfUrgencyFormData();

    ResponseDTO getAppointmentFormData();

    ResponseDTO getHealthActivityTrackerAssociationFormData();

    ResponseDTO getAnalysisResultsFormData();

    ResponseDTO getTranplantedOrganFormData();
}
