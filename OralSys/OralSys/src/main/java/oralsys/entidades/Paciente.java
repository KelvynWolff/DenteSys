package oralsys.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Paciente implements Serializable {
    @Column(name = "responsavel", length = 15)
    private Paciente responsavel;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pacientes")
    private List<Paciente> pacientes;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "consultas")
    private List<Consulta> consultas;
    @Column(name = "enderecoId", length = 15)
    private Endereco enderecoId;
    @Column(name = "prontuarios")
    private List<Prontuario> prontuarios;
    @Column(name = "numeroCasa", length = 20)
    private String numeroCasa;
    @Column(name = "cpf", length = 14)
    private String cpf;
    @Column(name = "dataNascimento")
    private Date dataNascimento;
    @Column(name = "contatos")
    private List<Contato> contatos;
    @Column(name = "agendamentos")
    private List<Agendamento> agendamentos;
}
