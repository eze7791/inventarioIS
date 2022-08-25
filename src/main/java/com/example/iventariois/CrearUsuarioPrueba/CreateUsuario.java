/*package com.example.iventariois.CrearUsuarioPrueba;

import com.example.iventariois.models.Usuario;
import com.example.iventariois.services.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUsuario implements CommandLineRunner
{

    @Autowired
    ServicioUsuario servicioUsuario;


    @Override
    public void run(String... args) throws Exception {

        Usuario usuario = new Usuario();
        BCryptPasswordEncoder passGenerator = new BCryptPasswordEncoder();
        String password = passGenerator.encode("user");
        usuario.setNombre("user");
        usuario.setPassword(password);
        usuario.setRol("user");
        servicioUsuario.saveUsuario(usuario);
    }
}*/
