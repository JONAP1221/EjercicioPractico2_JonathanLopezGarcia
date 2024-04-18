package hoteles.hoteles.service.impl;

import hoteles.hoteles.dao.ReservaDao;
import hoteles.hoteles.domain.Reserva;
import hoteles.hoteles.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jonathan
 */

@Service
public class ReservaServiceImpl implements ReservaService {
    
    @Autowired//se conecta durectamente con este de abajo
    private ReservaDao reservaDao;

    @Override
    @Transactional(readOnly=true)//dimplemente se lee lo que hay en la base de datos
    public List<Reserva> getReservas(boolean activos) {
        var lista=reservaDao.findAll();//obtenemos todos los objetos de la reserva de la base de datos
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Reserva getReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    @Transactional
    public void delete(Reserva reserva) {
        reservaDao.delete(reserva);
    }
}
