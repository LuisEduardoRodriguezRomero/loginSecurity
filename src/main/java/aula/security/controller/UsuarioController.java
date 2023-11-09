package aula.security.controller;

import aula.security.entity.Usuario;
import aula.security.repository.UsuarioRepository;
import aula.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/usuarios")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
        System.out.println(usuario.getUsername());
       try {
            System.out.println("entrou");
           usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            System.out.println(usuario.getUsername());
            usuarioRepository.save(usuario);
           return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste";
    }



    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> getAllUsers(){

    List<Usuario> usuarios = usuarioService.getAllUsers();

    return ResponseEntity.ok(usuarios);

    }
}