package hoteles.hoteles.controller;

import hoteles.hoteles.domain.Reserva;
import hoteles.hoteles.service.ReservaService;
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
@RequestMapping ("/reserva")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;

        @GetMapping("/")
    private String listado(Model model) {
        var reservas = reservaService.getReservas(false);
        model.addAttribute("reservas", reservas);
        return "/index";
    }
    
    @GetMapping("/index") //este es el API
    public String inicio(Model model) {
        var reservas = reservaService.getReservas(false);//ese getReservaes se sacan los datos de la variable que se llamaba
        model.addAttribute("reservas", reservas);//el primero es el nombre que se le esta dando, es segundo es la variable 
        model.addAttribute("totalReservaes", reservas.size());//.size le dice el tamaño que trae esa lista
        return "/hotel/listado";
    }


    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String hotelGuardar(Reserva reserva,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            reservaService.save(reserva);
        }
        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{idReserva}")
    public String hotelEliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{idReserva}")
    public String hotelModificar(Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);
        model.addAttribute("reserva", reserva);
        return "/reserva/modifica";
    }
}