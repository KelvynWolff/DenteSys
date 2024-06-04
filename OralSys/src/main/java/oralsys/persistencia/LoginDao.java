package oralsys.persistencia;

import java.util.Arrays;
import java.util.List;
import oralsys.entidades.Login;

public class LoginDao extends Dao {
    public List listarLogin(String condicao) {
        String queryString = "SELECT * FROM Login";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Login.class)
                 .getResultList();
    }
}
