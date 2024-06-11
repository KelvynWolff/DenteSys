package oralsys.entidades;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
public class Material implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qtdMinina")
    private Integer qtdMinina;

    @ManyToOne
    @JoinColumn(name = "usuarioCadastro_id")
    private Login usuarioCadastro;

    @Column(name = "nome", length = 20)
    private String nome;
}
