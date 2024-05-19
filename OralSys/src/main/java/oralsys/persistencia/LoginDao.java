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
     
    public boolean validaAcesso(String login_pesquisa, char[] senha) {
        String condicao = "login = " + login_pesquisa;
        List<Login> logins = this.listarLogin(condicao);
        Boolean valido = false;
        if (!logins.isEmpty()) {
            for (Login login : logins) {
                if (Arrays.equals(login.getSenha(), senha)) {
                    valido = true;
                }
            }
        }
        return valido;
    }
}
