package hoteles.hoteles.dao;

import hoteles.hoteles.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Long> {

}