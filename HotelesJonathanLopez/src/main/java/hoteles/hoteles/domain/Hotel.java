package hoteles.hoteles.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Jonathan
 */
@Data
@Entity
@Table(name = "hoteles")
public class Hotel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idHotel;
    private String nombre;
    private String ubicacion;
    private String descripcion;

    public Hotel() {
    }

    public Hotel(Long idHotel, String nombre, String ubicacion, String descripcion) {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion =  descripcion;
    }
}//final de la clase
