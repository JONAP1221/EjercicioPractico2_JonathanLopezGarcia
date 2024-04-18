package hoteles.hoteles.service;

import hoteles.hoteles.domain.UsuarioRoles;
import java.util.List;

public interface UsuarioService {
    
    // Se obtiene un listado de usuarios en un List
    public List<UsuarioRoles> getUsuarios();
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public UsuarioRoles getUsuarioPorUsername(String username);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public UsuarioRoles getUsuarioPorUsernameYPassword(String username, String password);
    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(UsuarioRoles usuario,boolean crearRolUser);
    
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(UsuarioRoles usuario);
    
}