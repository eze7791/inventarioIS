package com.example.iventariois.controllers;

import com.example.iventariois.services.ServicioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ControllerApi {

    @Autowired
    ServicioPedido servicioPedido;


    @GetMapping("/pedido")
    public String apiPedidos(Model model) throws Exception {
        try {
            model.addAttribute("prueba",this.servicioPedido.findAll());
            return "/views/template-vacio.html";
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
