package hoteles.hoteles.service.impl;

import hoteles.hoteles.dao.RolDao;
import hoteles.hoteles.dao.UsuarioRolesDao;
import hoteles.hoteles.domain.Rol;
import hoteles.hoteles.domain.UsuarioRoles;
import hoteles.hoteles.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRolesDao usuarioDao;
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioRoles> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioRoles getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioRoles getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional
    public void save(UsuarioRoles usuario, boolean crearRolUser) {
        usuario=usuarioDao.save(usuario);
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setIdRol(usuario.getUsuario());
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(UsuarioRoles usuario) {
        usuarioDao.delete(usuario);
    }
}