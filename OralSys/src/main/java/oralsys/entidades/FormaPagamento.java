package oralsys.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
public class FormaPagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipoPagamento_id")
    private TipoPagamento tipoPagamento;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    private Double valor;
}
