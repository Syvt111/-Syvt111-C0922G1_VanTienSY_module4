package com.example.book_lend_app.controller;

import com.example.book_lend_app.model.Book;
import com.example.book_lend_app.model.OrderBook;
import com.example.book_lend_app.service.IBookService;
import com.example.book_lend_app.service.IOderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private IOderBookService oderBookService;

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

    @GetMapping("lend/{id}")
    public String showFormLend(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        OrderBook orderBook = new OrderBook();
        orderBook.setName(book.getName());
        Random random = new Random();
        int bookCode = random.nextInt(99999 - 10000 + 1) + 10000;
        orderBook.setCode(bookCode);
        model.addAttribute("order", orderBook);
        return "/lend";
    }

    @PostMapping("lend/{id}")
    public String lend(@ModelAttribute OrderBook orderBook, @ModelAttribute Book book, RedirectAttributes attributes, @PathVariable int id) {
        oderBookService.save(orderBook);
        Book book1 = bookService.findById(id);
        book.setId(book1.getId());
        book.setAmount(book1.getAmount() - 1);
        bookService.save(book);
        attributes.addFlashAttribute("msg", "Lend Successfully !");
        return "redirect:/";

    }


    @GetMapping("pay")
    public String showFormPay() {

        return "/pay";
    }

    @PostMapping("pay")
    public String pay(@ModelAttribute Book book,RedirectAttributes redirectAttributes , @RequestParam int code) {
        OrderBook orderBook = oderBookService.findOrderBookByCode(code);
        if (orderBook==null){
            redirectAttributes.addFlashAttribute("error","Nhập sai mã sách");
            return "redirect:/pay";
        }else {
            Book book1 = bookService.findBookByNameContaining(orderBook.getName());
            book.setId(book1.getId());
            book.setAmount(book1.getAmount() + 1);
            bookService.save(book);
            oderBookService.delete(orderBook.getId());
            redirectAttributes.addFlashAttribute("msg", "Pay Successfully !");
            return "redirect:/home";
        }

    }
}
