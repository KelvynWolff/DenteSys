package oralsys.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Contato {

    @Id
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    private TipoContato tipo;

    @Column(length = 255)
    private String informacao;
}
