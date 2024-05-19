package oralsys.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Prontuarios implements Serializable {
    @Column(name = "prontuario", length = 15)
    private Prontuario prontuario;
    @Column(name = "consulta", length = 15)
    private Consulta consulta;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao", length = 150)
    private String descricao;
}
