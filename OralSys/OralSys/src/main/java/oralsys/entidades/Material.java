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
public class Material implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "qtdMinina", length = 20)
    private Integer qtdMinina;
    @Column(name = "usuarioCadastro", length = 20)
    private Login usuarioCadastro;
    @Column(name = "nome", length = 20)
    private String nome;
}
