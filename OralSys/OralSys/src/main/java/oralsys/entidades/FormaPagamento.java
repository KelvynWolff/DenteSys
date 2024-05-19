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
public class FormaPagamento implements Serializable {
    @Column(name = "consulta", length = 15)
    private Consulta consulta;
    @Column(name = "tipoPagamento", length = 15)
    private TipoPagamento tipoPagamento;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor", length = 50)
    private Double valor;
}
