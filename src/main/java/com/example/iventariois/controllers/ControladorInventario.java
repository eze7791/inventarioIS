package com.example.iventariois.controllers;

import com.example.iventariois.services.ServicioMaterial;
import com.example.iventariois.services.ServicioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class ControladorInventario {
    @Autowired
    ServicioMaterial servicioMaterial;
    @Autowired
    ServicioPedido servicioPedido;

    @GetMapping(value = {"/home" , "/"})
    public String inicio(Model model) {
        try {
            model.addAttribute("noVistos", servicioPedido.countNoVistos());
            model.addAttribute("vistos", servicioPedido.countVistos());
            model.addAttribute("materiales", servicioMaterial.findAll());
            return "views/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
