package com.example.iventariois.controllers;

import com.example.iventariois.services.ServicioMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControladorInventario {
    @Autowired
    ServicioMaterial servicioMaterial;

    @GetMapping(value = "/")
    public String inicio(Model model) {
        try {
            model.addAttribute("materiales", servicioMaterial.findAll());
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
