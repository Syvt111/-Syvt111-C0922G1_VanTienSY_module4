package furama_resort.furama_resort_manager.controller;

import furama_resort.furama_resort_manager.model.Facility;
import furama_resort.furama_resort_manager.service.FacilityService;
import furama_resort.furama_resort_manager.service.IFacilityService;
import furama_resort.furama_resort_manager.service.IFacilityTypeService;
import furama_resort.furama_resort_manager.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
   private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showAllAndSearchSort(@RequestParam(required = false, defaultValue = "") String name,
                                       @RequestParam(defaultValue = "0") int facilityType, Model model,
                                       @PageableDefault(size = 7, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Facility> facilities;
        if (facilityType == 0) {
            facilities = facilityService.findCustomerByNameContaining(name, pageable);
        } else {
            facilities = facilityService.findByNameContainingAndFacilityType_Id(name, facilityType, pageable);
        }
        model.addAttribute("name",name);
        model.addAttribute("facilityType",facilityType);
        model.addAttribute("facilities", facilities);
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("facility", new Facility());
        return "facility";
    }


    @RequestMapping("/create")
    public String save(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new facility !");
        return "redirect:/facility";
    }

    @RequestMapping("/edit")
    public String edit(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes, @RequestParam int id) {
//        facilityService.findById(id);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("msg", "Successfully edit facility !");
        return "redirect:/facility";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        facilityService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Successfully delete facility !");
        return "redirect:/facility";
    }

}
