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
public class Arquivos implements Serializable {
    
    @Column(name = "consultas")
    private List<Consulta> consultas;
    @Column(name = "caminhoArquivo", length = 100)
    private String caminhoArquivo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
