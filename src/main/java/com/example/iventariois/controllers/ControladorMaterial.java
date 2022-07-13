package com.example.iventariois.controllers;

import com.example.iventariois.models.Material;
import com.example.iventariois.services.ServicioInventario;
import com.example.iventariois.services.ServicioMaterial;
import com.example.iventariois.services.ServicioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorMaterial {
    @Autowired
    ServicioMaterial servicioMaterial;
    @Autowired
    ServicioPedido servicioPedido;
    @Autowired
    ServicioInventario servicioInventario;

    /*@GetMapping(value = "/agregar_material")
    public String agregarMaterial(Model model) {
        try {
            return "/views/crear_material.html";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }*/

    @GetMapping("/agregar_material/{id}")
    public String agregarMaterial(Model model,@PathVariable("id")long id){
        try {
            model.addAttribute("inventarios",this.servicioInventario.findAll());
            model.addAttribute("pedidos",this.servicioPedido.findAll());
            if(id==0){
                model.addAttribute("material",new Material());
            }else{
                model.addAttribute("material",this.servicioMaterial.findById(id));
            }
            return "/views/crear_material.html";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping(value = "/agregar_material/{id}")
    public String guardarMaterial(@ModelAttribute("material") Material material, Model model){
        try {
             servicioMaterial.saveMaterial(material);
             return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/{id}")
    public String eliminarMaterial(Model model,@PathVariable("id")long id){
        try {
            this.servicioMaterial.deleteMaterial(id);
            return "redirect:/";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            System.out.println(e);
            return "error";
        }
    }
}
