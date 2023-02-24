package furama_resort.furama_resort_manager.controller;

import furama_resort.furama_resort_manager.DTO.ContractDetailDTO;
import furama_resort.furama_resort_manager.model.AttachFacility;
import furama_resort.furama_resort_manager.model.ContractDetail;
import furama_resort.furama_resort_manager.service.IAttachFacilityService;
import furama_resort.furama_resort_manager.service.IContractDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class RestContractController {
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/contract/api/view/{id}")
    public ResponseEntity<List<ContractDetailDTO>> getAllAttachFacility(@PathVariable("id") int id) {
        List<ContractDetail> contractDetails = contractDetailService.findContractDetailByContract_Id(id);
        List<ContractDetailDTO> contractDetailDTOList = new ArrayList<>();
        for (ContractDetail cd : contractDetails
        ) {
            ContractDetailDTO contractDetailDTO = new ContractDetailDTO();
            BeanUtils.copyProperties(cd, contractDetailDTO);
            contractDetailDTO.setTotal(cd.getAttachFacility().getCost() * cd.getQuantity());
            contractDetailDTOList.add(contractDetailDTO);
        }
        if (contractDetailDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractDetailDTOList, HttpStatus.OK);
        }
    }
}
