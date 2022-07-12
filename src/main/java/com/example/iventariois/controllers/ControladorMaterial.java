package com.example.iventariois.controllers;

import com.example.iventariois.services.ServicioMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorMaterial {
    @Autowired
    ServicioMaterial servicioMaterial;

    @GetMapping(value = "/agregar_material")
    public String agregarMaterial(Model model) {
        try {
            return "/views/crear_material.html";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
