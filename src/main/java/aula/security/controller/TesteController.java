package aula.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TesteController {
    @GetMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public String rota(){
        return "<h1> Teste Security </h1>";
    }
    @GetMapping("/livre")
    public String rotaLivre(){
        return "<h2> Rota Livre </h2>";
    }

}
