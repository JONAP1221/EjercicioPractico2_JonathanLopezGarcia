package hoteles.hoteles.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Clase para mapear la tabla reservas en tu dominio.
 */
@Entity
@Data
@Table(name = "reservas")
public class Reserva implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clienteNombre;
    private int numHuespedes;
    private Date fechaIngreso;
    private Date fechaSalida;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    
    @Column(name = "numero_cedula", length = 20)
    private String numeroCedula;
    
}


