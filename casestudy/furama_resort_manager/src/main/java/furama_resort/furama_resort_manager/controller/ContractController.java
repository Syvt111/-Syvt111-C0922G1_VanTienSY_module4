package furama_resort.furama_resort_manager.controller;

import furama_resort.furama_resort_manager.DTO.ContractDTO;
import furama_resort.furama_resort_manager.model.AttachFacility;
import furama_resort.furama_resort_manager.model.Contract;
import furama_resort.furama_resort_manager.model.ContractDetail;
import furama_resort.furama_resort_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showAllAndSearchSort(@RequestParam(defaultValue = "0") int id, Model model,
                                       @PageableDefault(size = 7, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ContractDTO> contracts;
        contracts = contractService.getAllContractDTO(pageable);
        model.addAttribute("contractPage", contracts);
        model.addAttribute("id", id);
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("contractDetails",contractDetailService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("facilities", facilityService.findAll());
        model.addAttribute("attachFacilities", attachFacilityService.findAll());
        return "contract";
    }

    @RequestMapping("/create")
    public String saveContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new facility ! ");
        return "redirect:/contract";
    }

    @RequestMapping("contractDetail/craete")
    public String saveContractDetail(@ModelAttribute ContractDetail contractDetail, @RequestParam int id){
        contractService.findById(id);
        contractDetailService.save(contractDetail);

        return "redirect:/contract" ;
    }


}
