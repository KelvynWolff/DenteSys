package oralsys.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.FetchType;
import lombok.Data;

@Entity
@Data
public class Arquivos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "caminhoArquivo", length = 100)
    private String caminhoArquivo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arquivo")
    private List<Consulta> consultas;
}
