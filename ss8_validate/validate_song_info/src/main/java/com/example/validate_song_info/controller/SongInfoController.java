package com.example.validate_song_info.controller;

import com.example.validate_song_info.model.SongInfo;
import com.example.validate_song_info.service.ISongInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongInfoController {

    @Autowired
    ISongInfoService iSongInfoService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songList", iSongInfoService.findAll());
        return "/home";
    }

    @GetMapping("/create")
    public String showForm(@ModelAttribute SongInfo songInfo, Model model) {
        model.addAttribute("songInfo", new SongInfo());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute SongInfo songInfo,
                       BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("songInfo",songInfo);
            return "create";
        }
        redirectAttributes.addFlashAttribute("msg", "Successfully !");
        iSongInfoService.save(songInfo);

        return "redirect:/";
    }
}
