package furama_resort.furama_resort_manager.controller;

import furama_resort.furama_resort_manager.model.Customer;
import furama_resort.furama_resort_manager.model.CustomerType;
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

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/customer")
    public String showAllAndSearchSort(@RequestParam(required = false, defaultValue = "") String nameSearch,
                                       @RequestParam(defaultValue = "") String emailSearch,
                                       @RequestParam(defaultValue = "0") int customerTypeSearch, Model model,
                                       @PageableDefault(size = 7, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customers;

        if (customerTypeSearch == 0) {
            customers = customerService.findByNameContainingAndEmailContaining(nameSearch, emailSearch, pageable);
        } else {
            customers = customerService.findByNameContainingAndEmailContainingAndCustomerType_Id(nameSearch, emailSearch, customerTypeSearch, pageable);

        }
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("customerTypeSearch", customerTypeSearch);
        model.addAttribute("customers", customers);
        model.addAttribute("customerType", customerTypeService.findAll());
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
        List<Customer> customerList = customerService.findAll();
        for (Customer cus : customerList) {
            if (cus.getIdCard().equals(customer.getIdCard()) || cus.getEmail().equals(customer.getEmail()) || cus.getPhoneNumber().equals(customer.getPhoneNumber())) {
                redirectAttributes.addFlashAttribute("msg","Add failed ! ");
                return "redirect:/customer/create";
            }

        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new customer");
        return "redirect:/customer";

    }

    @PostMapping("/customer/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Successfully deleted customer");
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
