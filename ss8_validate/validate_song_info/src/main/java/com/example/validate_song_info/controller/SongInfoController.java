package com.example.validate_song_info.controller;

import com.example.validate_song_info.model.SongInfo;
import com.example.validate_song_info.service.ISongInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongInfoController {

    @Autowired
   private ISongInfoService iSongInfoService;

    @GetMapping("")
    public String showAllAndSearchSort(@RequestParam(required = false, defaultValue = "") String songName, Model model,
                                       @PageableDefault(size = 3, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("songPage", iSongInfoService.findSongInfoBySongNameContaining(songName,pageable));
        model.addAttribute("songName", songName);
        model.addAttribute("songList", iSongInfoService.findAll());

        return "/home";
    }

    @GetMapping("/create")
    public String showForm(@ModelAttribute SongInfo songInfo, Model model) {
        model.addAttribute("songInfo", new SongInfo());
        return "/create";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("songInfo", iSongInfoService.findById(id));
        model.addAttribute("id", id);
        return "/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        iSongInfoService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete Successfully !");
        return "redirect:/";

    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute SongInfo songInfo,
                       BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("songInfo", songInfo);
            return "create";
        }
        redirectAttributes.addFlashAttribute("msg", "Save Successfully !");
        iSongInfoService.save(songInfo);

        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute SongInfo songInfo,
                       BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("songInfo", songInfo);
            return "edit";
        }
        redirectAttributes.addFlashAttribute("msg", "Edit Successfully !");
        iSongInfoService.save(songInfo);

        return "redirect:/";
    }


}
