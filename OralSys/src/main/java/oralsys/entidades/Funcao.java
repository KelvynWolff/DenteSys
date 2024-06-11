package oralsys.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Funcao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "funcao")
    private List<Funcionario> funcionarios;

    @Column(nullable = false)
    private String nome;
}
