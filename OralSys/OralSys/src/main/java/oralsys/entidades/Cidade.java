package oralsys.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cidade implements Serializable {
    @Column(name = "enderecos")
    private List<Endereco> enderecos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estado", length = 2)
    private Estado estado;
    @Column(name = "nome", length = 100)
    private String nome;
}
