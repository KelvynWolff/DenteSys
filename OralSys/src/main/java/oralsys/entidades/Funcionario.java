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

    
    @Transient 
    private List<String> agendamentos = new ArrayList<>();

    @Transient 
    private List<String> consultas = new ArrayList<>();
}
