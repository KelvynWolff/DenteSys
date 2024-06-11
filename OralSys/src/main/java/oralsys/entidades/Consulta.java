package oralsys.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Consulta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Column(length = 255)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "dentista_id")
    private Funcionario dentista;

    @ManyToOne
    @JoinColumn(name = "arquivo_id")
    private Arquivos arquivo;

    @Column(length = 15)
    private String status;

    @OneToMany(mappedBy = "consulta")
    private List<FormaPagamento> formaPagamentos;

    @OneToMany(mappedBy = "consulta")
    private List<Prontuario> prontuarios;
}
