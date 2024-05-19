package oralsys.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Agendamento implements Serializable {
    @Column(name = "recepcionista", length = 15)
    private Funcionario recepcionista;
    @Column(name = "paciente", length = 15)
    private Paciente paciente;
    @Column(name = "dentista", length = 15)
    private Funcionario dentista;
    @Column(name = "data")
    private Date data;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hora")
    private Date hora;
}
