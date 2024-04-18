
package hoteles.hoteles.service;

import org.springframework.security.core.userdetails.*;
/**
 *
 * @author Jonathan
 */
public interface UsuarioDetailsService {
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException;
}//Final de la clase
