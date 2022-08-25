package com.example.iventariois.controllers;

import com.example.iventariois.models.Nota;
import com.example.iventariois.models.Pedido;
import com.example.iventariois.models.Usuario;
import com.example.iventariois.services.ServicioNota;
import com.example.iventariois.services.ServicioPedido;
import com.example.iventariois.services.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Calendar;
import java.util.Date;



@Controller
public class ControladorNota {

    @Autowired
    ServicioNota servicioNota;
    @Autowired
    ServicioPedido servicioPedido;

    @Autowired
    ServicioUsuario servicioUsuario;

    @PostMapping(value = "/agregar_nota/{id}")
    public Object guardarNota(@RequestParam(value = "nota", required = true) String nota_r,
                              @PathVariable("id") long id, Model model){
        try {
            Nota nota = new Nota();

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Long usuario_id = servicioUsuario.findByName(auth.getName()).getId();
            Usuario usuario = servicioUsuario.findById(usuario_id);
            nota.setUsuario(usuario);


            Pedido pedido= servicioPedido.findById(id);
            nota.setPedido(pedido);

            nota.setNota(nota_r);

            Date currentTime = Calendar.getInstance().getTime();
            nota.setFecha(currentTime);

            servicioNota.saveNota(nota);
            model.addAttribute("pedido", pedido);
            return "/views/ver_pedido";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }




}
