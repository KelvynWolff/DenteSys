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
public class Login implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "login", length = 50)
    private String login;
    @Column(name = "senha", length = 50)
    private char[] senha;
    @Column(name = "admnistrador")
    private Boolean admnistrador;
    @Column(name = "funcionario")
    private Funcionario funcionario;
}
