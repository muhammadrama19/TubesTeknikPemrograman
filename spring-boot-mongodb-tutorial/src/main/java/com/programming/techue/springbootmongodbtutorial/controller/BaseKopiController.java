package com.programming.techue.springbootmongodbtutorial.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class BaseKopiController {
    @GetMapping
    public String getAllData(Model model ){
        populateModel(model);
        return getTemplateName();
    }
    protected abstract String getTemplateName();
    protected abstract void populateModel(Model model);
    
}
