package oralsys.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "funcao_id")
    private Funcao funcao;

    @OneToMany(mappedBy = "funcionario")
    private List<Consulta> consultas;

    @Column(nullable = false)
    private String registro;

    @OneToOne
    private Login login;

    @Column(length = 200)
    private String nome;
    
    @Column(length = 14)
    private String cpf;
}
