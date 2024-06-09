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
    
    public Login buscarPorId(Long id) {
        List<Login> logins = listarLogin("id = " + id);
        return logins.isEmpty() ? null : logins.get(0);
    }
    
    public Login buscarPorLogin(String login) {
        String queryString = "SELECT * FROM Login WHERE login = " + login;
       List<Login> logins = em.createNativeQuery(queryString, Login.class)
                 .getResultList();
       return logins.isEmpty() ? null : logins.get(0);
    }
}
