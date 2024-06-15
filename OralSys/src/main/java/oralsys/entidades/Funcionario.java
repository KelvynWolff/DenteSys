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
    private int id;

    @ManyToOne
    @JoinColumn(name = "funcao_id")
    private Funcao funcao;

    @OneToMany(mappedBy = "funcionario")
    private List<Consulta> consultas;

    @Column(nullable = false)
    private String registro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private Login login;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 14, nullable = false)
    private String cpf;

    @OneToMany(mappedBy = "funcionario")
    private List<Agendamento> agendamentos;
}
