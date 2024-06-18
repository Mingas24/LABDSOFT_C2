package com.pt.isep.labdsoft.controller;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.service.auth.UserService;
import com.pt.isep.labdsoft.service.ui.UILoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ui-loader")
public class UILoaderController {

    @Autowired
    private UILoaderService uiLoaderService;

    @GetMapping(value = "/transplant-recipient-form-data")
    public ResponseEntity<ResponseDTO> getTransplantRecipientFormData() {
        return ResponseEntity.ok(this.uiLoaderService.getTransplantRecipientFormData());
    }

    @GetMapping(value= "/transplant-donor-form-data")
    public ResponseEntity<ResponseDTO> getTransplantDonorFormDat(){
        return ResponseEntity.ok(this.uiLoaderService.getTransplantDonorFormData());
    }

    @GetMapping(value= "/organ-wastage-form-data")
    public ResponseEntity<ResponseDTO> getOrganWastageFormData(){
        return ResponseEntity.ok(this.uiLoaderService.getOrganWastageFormData());
    }

    @GetMapping(value= "/patients-form-data")
    public ResponseEntity<ResponseDTO> getPatientsFormData(){
        return ResponseEntity.ok(this.uiLoaderService.getPatientsFormData());
    }

    @GetMapping(value= "/analysis-request-form-data")
    public ResponseEntity<ResponseDTO> getAnalysisRequestFormData(){
        return ResponseEntity.ok(this.uiLoaderService.getAnalysisRequestFormData());
    }

    @GetMapping(value= "/transplant-recipient-edit-form-data")
    public ResponseEntity<ResponseDTO> getTransplantRecipientEditFormData() {
        return ResponseEntity.ok(this.uiLoaderService.getChangeStateOfUrgencyFormData());
    }

    @GetMapping(value= "/appointment-form-data")
    public ResponseEntity<ResponseDTO> getAppointmentFormData() {
        return ResponseEntity.ok(this.uiLoaderService.getAppointmentFormData());
    }

    @GetMapping(value= "/health-activity-tracker-association-form-data")
    public ResponseEntity<ResponseDTO> getHealthActivityTrackerAssociationFormData(){
        return ResponseEntity.ok(this.uiLoaderService.getHealthActivityTrackerAssociationFormData());
    }

    @GetMapping(value= "/analysis-results-form-data")
    public ResponseEntity<ResponseDTO> getAnalysisResultsFormData(){
        return ResponseEntity.ok(this.uiLoaderService.getAnalysisResultsFormData());
    }

}
