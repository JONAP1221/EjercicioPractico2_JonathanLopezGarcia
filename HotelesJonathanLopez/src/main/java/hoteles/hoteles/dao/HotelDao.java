package hoteles.hoteles.dao;

import hoteles.hoteles.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDao extends JpaRepository<Hotel, Long> {

}