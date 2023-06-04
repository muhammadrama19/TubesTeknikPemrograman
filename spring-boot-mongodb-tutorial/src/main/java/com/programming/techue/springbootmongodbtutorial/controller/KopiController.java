package com.programming.techue.springbootmongodbtutorial.controller;

import com.programming.techue.springbootmongodbtutorial.service.KopiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.programming.techue.springbootmongodbtutorial.model.Kopi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class KopiController extends BaseKopiController{
    
    private final KopiService kopiService;
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addKopi(@ModelAttribute Kopi coffee) {
        kopiService.addKopi(coffee);
        return "redirect:/";
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String updateKopi(@ModelAttribute Kopi coffee) {
        kopiService.updateKopi(coffee);
        return "redirect:/";
    }



    @GetMapping(value="delete/{id}")
    public String deleteKopi(@PathVariable String id) {
        kopiService.deleteKopi(id);
        return "redirect:/";

    }

    @GetMapping(value="search/{nama}")
    public String searchKopi(@PathVariable String nama, Model model) {
        List<Kopi> Datacoffee = kopiService.getKopiByName(nama);
        model.addAttribute("Data", Datacoffee);
        model.addAttribute("edit", false);
        model.addAttribute("search", nama);
        return "test";
    }

    @Override
    protected String getTemplateName() { //acuan template html untuk penampilan data
        return "test";
    }

    @Override
    protected void populateModel(Model model) { //mengambil data, apa yang diambil apa yang di tampilkan
        List<Kopi> Datacoffee = kopiService.getAllKopi();
        model.addAttribute("Data", Datacoffee); //memasukan collection kopi ke html
        model.addAttribute("edit", false);
        
    }


}
