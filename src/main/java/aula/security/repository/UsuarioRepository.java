package aula.security.repository;

import aula.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   Usuario findByUsername(String username);




}
