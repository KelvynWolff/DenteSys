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

    @OneToOne(mappedBy = "login")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "funcao_id")
    private Funcao funcao;

    @ManyToMany
    @JoinTable(
        name = "login_material", 
        joinColumns = @JoinColumn(name = "login_id"), 
        inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materials;

    @Column(name = "senha", length = 50, nullable = false)
    private String senha;

    @Column(name = "login", length = 50, nullable = false, unique = true)
    private String login;
}
