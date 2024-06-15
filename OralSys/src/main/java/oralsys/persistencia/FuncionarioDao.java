package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Funcionario;

public class FuncionarioDao extends Dao {
    public List<Funcionario> listarFuncionarios(String condicao) {
        String queryString = "SELECT * FROM Funcionario";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Funcionario.class)
                 .getResultList();
    }

    public Funcionario buscarPorId(int id) {
        return em.find(Funcionario.class, id);
    }
    
    public Funcionario buscarPorLoginId(int loginId) {
        List<Funcionario> funcionarios = listarFuncionarios("login_id = " + loginId);
        return funcionarios.isEmpty() ? null : funcionarios.get(0);
    }
   }