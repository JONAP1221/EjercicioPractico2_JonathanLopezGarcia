package hoteles.hoteles.dao;

import hoteles.hoteles.domain.UsuarioRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<UsuarioRoles, Long> {
    UsuarioRoles findByUsername(String username);
    
    UsuarioRoles findByUsernameAndPassword(String username, String Password);

    boolean existsByUsername(String username);
}
