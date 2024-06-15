package oralsys.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Login implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "senha", length = 50)
    private String senha;

    @Column(name = "login", length = 50, nullable = false, unique = true)
    private String login;
    
    public void setSenha(char[] senha) {
        this.senha = new String(senha);
    }

    public char[] getSenha() {
        return senha.toCharArray();
    }
}
