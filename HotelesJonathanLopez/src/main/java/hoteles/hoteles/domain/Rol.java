package hoteles.hoteles.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Jonathan
 */
@Entity
@Data
@Table (name = "roles")
public class Rol implements Serializable{ 
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    
    @NotEmpty 
    private String nombre;
}//Final de la clase

