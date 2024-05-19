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
public class Login implements Serializable {
    @Column(name = "funcao", length = 15)
    private Funcao funcao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "materials")
    private List<Material> materials;
    @Column(name = "senha", length = 50)
    private char[] senha;
    @Column(name = "login", length = 50)
    private String login;
    @Column(name = "funcionario", length = 15)
    private Funcionario funcionario;
}
