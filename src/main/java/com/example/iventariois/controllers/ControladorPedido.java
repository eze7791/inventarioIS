package com.example.iventariois.controllers;

import com.example.iventariois.models.Nota;
import com.example.iventariois.models.Pedido;
import com.example.iventariois.services.ServicioNota;
import com.example.iventariois.services.ServicioPedido;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class ControladorPedido {
    @Autowired
    ServicioPedido servicioPedido;

   /* @Autowired
    ServicioNota servicioNota;*/

    @GetMapping(value = "/pedidos_nuevos")
    public String pedidosNuevos(Model model) {
        try {
            model.addAttribute("pedidos", servicioPedido.findByNoVisto());
            return "/views/pedidos_nuevos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/pedidos_vistos")
    public String pedidosVistos(Model model) {
        try {
            model.addAttribute("pedidos", servicioPedido.findByVisto());
            return "/views/pedidos_vistos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/pedidos/ver/{id}")
    public String verPedido(Model model, @PathVariable("id") long id) {
        try {
            Pedido pedido = servicioPedido.findById(id);
            pedido.setVisto(true);
            servicioPedido.savePedido(pedido);

            model.addAttribute("pedido", pedido);

            return "/views/ver_pedido";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/pedidos/eliminar/{id}")
    public String eleminarPedido(Model model, @PathVariable("id") long id) {
        try {
            servicioPedido.deletePedido(id);
            return "redirect:/pedidos_vistos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }


}
