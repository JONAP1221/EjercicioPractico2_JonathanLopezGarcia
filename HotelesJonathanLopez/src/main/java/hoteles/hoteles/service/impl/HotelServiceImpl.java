package hoteles.hoteles.service.impl;

import hoteles.hoteles.dao.HotelDao;
import hoteles.hoteles.domain.Hotel;
import hoteles.hoteles.service.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jonathan
 */

@Service
public class HotelServiceImpl implements HotelService {
    
    @Autowired//se conecta durectamente con este de abajo
    private HotelDao hotelDao;

    @Override
    @Transactional(readOnly=true)//dimplemente se lee lo que hay en la base de datos
    public List<Hotel> getHoteles(boolean activos) {
        var lista=hotelDao.findAll();//obtenemos todos los objetos de la hotel de la base de datos
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Hotel getHotel(Hotel hotel) {
        return hotelDao.findById(hotel.getIdHotel()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Hotel hotel) {
        hotelDao.save(hotel);
    }

    @Override
    @Transactional
    public void delete(Hotel hotel) {
        hotelDao.delete(hotel);
    }
}
