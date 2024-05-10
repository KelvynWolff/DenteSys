package oralsys.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Prontuario implements Serializable {
    
    @Id
    private Long id;
    
    @OneToMany
    private List<Paciente> pacientes = new ArrayList<>();
    
    private List<String> prontuarios = new ArrayList<>();
}
