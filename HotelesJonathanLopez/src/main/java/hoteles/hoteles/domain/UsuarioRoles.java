package hoteles.hoteles.domain;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario_roles")
public class UsuarioRoles implements Serializable { 
    
    private static final long serialVersionUID = 1L;
    
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Id
    private String usuario;
    
    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;
    
}
