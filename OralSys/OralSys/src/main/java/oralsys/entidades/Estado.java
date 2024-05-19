package oralsys.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Estado implements Serializable {
    @Id
    @Column(name = "estado", length = 2)
    private String uf;
}
