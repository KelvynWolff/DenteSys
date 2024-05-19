package oralsys.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Consulta implements Serializable {
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "formaPagamentos")
    private List<FormaPagamento> formaPagamentos;
    @Column(name = "prontuarios")
    private List<Prontuario> prontuarios;
    @Column(name = "paciente", length = 15)
    private Paciente paciente;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dentista", length = 15)
    private Funcionario dentista;
    @Column(name = "anexos", length = 15)
    private Arquivos anexos;
}
