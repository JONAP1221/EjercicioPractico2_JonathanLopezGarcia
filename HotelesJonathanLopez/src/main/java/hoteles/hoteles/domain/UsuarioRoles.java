package hoteles.hoteles.domain;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario_roles")
public class UsuarioRoles implements Serializable { 
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
    
    // Getters y setters
    
    public UsuarioRoles() {}
    
    public UsuarioRoles(Usuario usuario, Rol rol) {
        this.usuario = usuario;
        this.rol = rol;
    }
}
