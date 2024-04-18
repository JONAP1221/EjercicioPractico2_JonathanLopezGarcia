
package hoteles.hoteles.service.impl;


import hoteles.hoteles.service.UsuarioDetailsService;
import hoteles.hoteles.dao.UsuarioDao;
import hoteles.hoteles.domain.Rol;
import hoteles.hoteles.domain.UsuarioRoles;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jonathan
 */
@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //busca al usuario por el username en la tabla 
        UsuarioRoles usuario = usuarioDao.findByUsername(username);
        //si no está lanza una excepción
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }//final if
        //Si está aqui es porq existe el usuario... sacamos los roles de este
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol: usuario.getRoles()) { //se sacan los roles
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }//Final for
        //se devuelve User (clase de userDetails)
        return new User(usuario.getUsuario().getUsername(), usuario.getUsuario().getPassword(), roles);
    }//final del metodo loadUserByUsername
    
}//Final de la clase
