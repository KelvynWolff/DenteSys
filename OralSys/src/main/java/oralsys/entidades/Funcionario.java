package oralsys.entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String registro;

    @OneToOne
    private Login login;

    @Column(length = 200)
    private String nome;
    
    @Column(name = "agendamentos", length = 20)
    private List<Agendamento> agendamentos;

    @Column(name = "consultas", length = 20)
    private List<Consulta> consultas;
}
