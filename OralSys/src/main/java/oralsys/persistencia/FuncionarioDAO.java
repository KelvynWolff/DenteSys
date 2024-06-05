package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Funcionario;

public class FuncionarioDao extends Dao {
<<<<<<< HEAD
    public List listarFuncionario (String condicao) {   
        String queryString = "SELECT * FROM Funcionario";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
=======

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("oralsysPU");

    public String cadastrarPaciente(Paciente paciente) {
        String status = "";
        if (paciente.getNome().isEmpty()) {
            status = "Nome inválido!";
        } else if (paciente.getCpf().isEmpty() || paciente.getCpf().length() != 14) {
            status = "CPF inválido!";
        } else if (paciente.getDataNascimento() == null) {
            status = "Data de nascimento inválida!";
>>>>>>> kelvyn
        }
        return em.createNativeQuery(queryString, Funcionario.class)
                 .getResultList();
    }
}
