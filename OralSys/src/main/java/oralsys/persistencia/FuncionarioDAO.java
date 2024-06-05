package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Funcionario;

public class FuncionarioDao extends Dao {
    public List listarFuncionario (String condicao) {   
        String queryString = "SELECT * FROM Funcionario";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Funcionario.class)
                 .getResultList();
    }
}
