package hoteles.hoteles.service;

import hoteles.hoteles.domain.Hotel;
import java.util.List;

public interface HotelService {
    
    // Se obtiene un listado de hotels en un List
    public List<Hotel> getHoteles(boolean activos);
    
   // Se obtiene un Hotel, a partir del id de un hotel
    public Hotel getHotel(Hotel hotel);
    
    // Se inserta un nuevo hotel si el id del hotel esta vacío
    // Se actualiza un hotel si el id del hotel NO esta vacío
    public void save(Hotel hotel);
    
    // Se elimina el hotel que tiene el id pasado por parámetro
    public void delete(Hotel hotel);
}