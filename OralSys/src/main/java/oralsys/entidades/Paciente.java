package oralsys.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Paciente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    @Column(length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "responsavel")
    private List<Paciente> pacientes;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Paciente responsavel;

    @OneToMany(mappedBy = "paciente")
    private List<Contato> contatos;

    @OneToMany(mappedBy = "paciente")
    private List<Agendamento> agendamentos;

    @OneToMany(mappedBy = "paciente")
    private List<Prontuario> prontuarios;

    @Column(length = 20)
    private String numeroCasa;

    @Column(length = 14)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
}
