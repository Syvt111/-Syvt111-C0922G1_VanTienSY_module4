package furama_resort.furama_resort_manager.controller;

import furama_resort.furama_resort_manager.DTO.ContractDTO;
import furama_resort.furama_resort_manager.DTO.ContractDetailDTO;
import furama_resort.furama_resort_manager.model.Contract;
import furama_resort.furama_resort_manager.model.ContractDetail;
import furama_resort.furama_resort_manager.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IContractDetailService contractDetailService;


    @RequestMapping("")
    public String showAllAndSearchSort(@RequestParam(defaultValue = "0") int id, Model model,RedirectAttributes redirectAttributes,
                                       @PageableDefault(size = 7, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ContractDTO> contracts;
        contracts = contractService.getAllContractDTO(pageable);
        model.addAttribute("contractPage", contracts);
        model.addAttribute("id", id);
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractDetails", contractDetailService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("facilities", facilityService.findAll());
        model.addAttribute("attachFacilities", attachFacilityService.findAll());
        redirectAttributes.addFlashAttribute("hasTrues", "true");
        return "contract";
    }

    @RequestMapping("/create")
    public String saveContract(@ModelAttribute Contract contract, ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        contractDetailService.save(contractDetail);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new facility ! ");
        return "redirect:/contract";
    }

    @RequestMapping("/contractDetail/create")
    public String saveContractDetail(@ModelAttribute ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }

    @GetMapping("/detail")
    public String getContractDetail(@RequestParam int id,Model model, RedirectAttributes redirectAttributes){
        List<ContractDetail> contractDetails = contractDetailService.findContractDetailByContract_Id(id);
        List<ContractDetailDTO> contractDetailDTOList = new ArrayList<>();
        double sumTotal = 0;
        for (ContractDetail cd : contractDetails
        ) {
            ContractDetailDTO contractDetailDTO = new ContractDetailDTO();
            BeanUtils.copyProperties(cd, contractDetailDTO);
            contractDetailDTO.setTotal(cd.getAttachFacility().getCost() * cd.getQuantity());
            sumTotal += contractDetailDTO.getTotal() ;
            contractDetailDTOList.add(contractDetailDTO);
        }
        redirectAttributes.addFlashAttribute("contractDetailList", contractDetailDTOList);
        redirectAttributes.addFlashAttribute("hasTrue", "true");
        redirectAttributes.addFlashAttribute("sumTotal", sumTotal);

        return "redirect:/contract";
    }
}
