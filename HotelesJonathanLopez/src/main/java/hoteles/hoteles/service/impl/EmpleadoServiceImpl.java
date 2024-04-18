package hoteles.hoteles.service.impl;

import hoteles.hoteles.dao.EmpleadoDao;
import hoteles.hoteles.domain.Empleado;
import hoteles.hoteles.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jonathan
 */

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    
    @Autowired//se conecta durectamente con este de abajo
    private EmpleadoDao empleadoDao;

    @Override
    @Transactional(readOnly=true)//dimplemente se lee lo que hay en la base de datos
    public List<Empleado> getEmpleados(boolean activos) {
        var lista=empleadoDao.findAll();//obtenemos todos los objetos de la empleado de la base de datos
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Empleado getEmpleado(Empleado empleado) {
        return empleadoDao.findById(empleado.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void delete(Empleado empleado) {
        empleadoDao.delete(empleado);
    }
}
