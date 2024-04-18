package hoteles.hoteles.controller;

import hoteles.hoteles.domain.Hotel;
import hoteles.hoteles.service.HotelService;
import hoteles.hoteles.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j//es una parte de loombok, es oara que la vista entienda lo que se va a procesar, es un protocolo 
@RequestMapping("/hotel")//Este es otro API
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    @GetMapping("/listado") //este es el API
    public String inicio(Model model) {
        var hoteles = hotelService.getHoteles(false);//ese getHoteles se sacan los datos de la variable que se llamaba
        model.addAttribute("hoteles", hoteles);//el primero es el nombre que se le esta dando, es segundo es la variable 
        model.addAttribute("totalHoteles", hoteles.size());//.size le dice el tamaño que trae esa lista
        return "/hotel/listado";
    }
    
     @GetMapping("/nuevo")
    public String hotelNuevo(Hotel hotel) {
        return "/hotel/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String hotelGuardar(Hotel hotel,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            hotelService.save(hotel);
        }
        hotelService.save(hotel);
        return "redirect:/hotel/listado";
    }

    @GetMapping("/eliminar/{idHotel}")
    public String hotelEliminar(Hotel hotel) {
        hotelService.delete(hotel);
        return "redirect:/hotel/listado";
    }

    @GetMapping("/modificar/{idHotel}")
    public String hotelModificar(Hotel hotel, Model model) {
        hotel = hotelService.getHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "/hotel/modifica";
    }
}