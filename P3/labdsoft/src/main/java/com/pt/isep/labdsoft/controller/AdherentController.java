package com.pt.isep.labdsoft.controller;


import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AdherentDTO;
import com.pt.isep.labdsoft.dto.domain.AdherentListDTO;
import com.pt.isep.labdsoft.service.domain.AdherentService;
import com.pt.isep.labdsoft.util.converter.AdherentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adherent")
public class AdherentController {

    @Autowired
    private AdherentService adherentService;

    @Autowired
    private AdherentConverter adherentConverter;

    @PostMapping("/createAdherent")
    public ResponseEntity<ResponseDTO> postAdherent(@RequestBody AdherentDTO adherentDTO) {
        ResponseDTO responseDTO = this.adherentService.createAdherent(adherentDTO);
        return ResponseEntity.status(responseDTO.getStatusCode()).build();
    }

    @GetMapping("/list")
    public PageDTO<AdherentListDTO> list(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderby, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return adherentConverter.toPageDTO(adherentService.findAll(orderby, sortOrder, pageNumber, pageSize));
    }

    @GetMapping("/listByCelebrity")
    public PageDTO<AdherentListDTO> listByCelebrity(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "orderBy", required = false) String orderby, @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize){
        return adherentConverter.toPageDTO(adherentService.findByCelebrity(orderby, sortOrder, 0, 10));
    }
}
