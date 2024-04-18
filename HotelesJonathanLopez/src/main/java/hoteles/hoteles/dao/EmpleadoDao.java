package hoteles.hoteles.dao;

import hoteles.hoteles.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoDao extends JpaRepository<Empleado, Long> {

}