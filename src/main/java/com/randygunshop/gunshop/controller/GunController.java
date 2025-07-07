package com.randygunshop.gunshop.controller;

import com.randygunshop.gunshop.model.Gun;
import com.randygunshop.gunshop.service.GunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guns")
public class GunController
{
    @Autowired
    private GunService gunService;

    public GunController(GunService gunService)
    {
        this.gunService = gunService;
    }

    @GetMapping
    public String listGuns(Model model) {
        model.addAttribute("guns", gunService.findall());
        return "gun-list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("gun", new Gun());
        return "gun-form";
    }

    @PostMapping
    public String saveGun(@ModelAttribute Gun gun, BindingResult result) {
        if (result.hasErrors()) {
            return "gun-form";
        }
        gunService.save(gun);
        return "redirect:/guns";
    }

    @GetMapping("/edit/{id}")
    public String editGun(@PathVariable Long id, Model model) {
        Gun gun = gunService.findById(id);
        if (gun == null) return "redirect:/guns";
        model.addAttribute("gun", gun);
        return "gun-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteGun(@PathVariable Long id) {
        gunService.deleteById(id);
        return "redirect:/guns";
    }
}
