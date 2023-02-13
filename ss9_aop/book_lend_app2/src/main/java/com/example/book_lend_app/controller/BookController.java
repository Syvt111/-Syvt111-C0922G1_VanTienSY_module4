package com.example.book_lend_app.controller;

import com.example.book_lend_app.model.Book;
import com.example.book_lend_app.service.BookService;
import com.example.book_lend_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showAllAndSearchSort(@RequestParam(required = false, defaultValue = "") String name, Model model,
                                       @PageableDefault(size = 4, page = 0, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Book> bookPage = bookService.findBookByNameContaining(name, pageable);
        model.addAttribute("bookPage", bookPage);
        model.addAttribute("name", name);
        return "/home";
    }

    @GetMapping("/create")
    public String ShowFormCreate(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Book book, RedirectAttributes attributes) {
        bookService.save(book);
        attributes.addFlashAttribute("msg", "Successfully !");
        return "redirect:/";
    }

}
