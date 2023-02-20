package furama_resort.furama_resort_manager.controller;

import furama_resort.furama_resort_manager.model.Customer;
import furama_resort.furama_resort_manager.service.ICustomerService;
import furama_resort.furama_resort_manager.service.ICustomerTypeService;
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
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("customer")
    public String showAllAndSearchSort(@RequestParam(required = false, defaultValue = "") String name,
                                       @RequestParam(defaultValue = "") String email,
                                       @RequestParam(defaultValue = "") String customerTypeSearch, Model model,
                                       @PageableDefault(size = 7, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Customer> customers = customerService.findCustomerByNameAndEmailAndCustomerTypeContaining(name,email,customerTypeSearch, pageable);

        model.addAttribute("customers", customers);
        model.addAttribute("customerType",customerTypeService.findAll());
        return "customer";
    }

    @GetMapping("search")
    public String search(@RequestParam(required = false, defaultValue = "") String name,
                                       @RequestParam(defaultValue = "") String email,
                                       @RequestParam(defaultValue = "") String customerTypeSearch, Model model,
                                       @PageableDefault(size = 7, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Customer> customers = customerService.findCustomerByNameAndEmailAndCustomerTypeContaining(name,email,customerTypeSearch, pageable);

        model.addAttribute("customers", customers);
        model.addAttribute("customerType",customerTypeService.findAll());
        return "customer";
    }

    @GetMapping("customer/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", customerTypeService.findAll());

        return "/customerCreate";
    }

    @PostMapping("/customer/create")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new");
        return "redirect:/customer";
    }

    @PostMapping("/customer/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Successfully deleted");
        return "redirect:/customer";
    }

    @GetMapping("customer/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customerEdit";
    }
    @PostMapping("customer/edit/{id}")
    public String edit(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Successfully edited");
        return "redirect:/customer";
    }

}
