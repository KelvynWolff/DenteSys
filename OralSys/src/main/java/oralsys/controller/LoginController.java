package oralsys.controller;

import java.util.Arrays;
import java.util.List;
import oralsys.entidades.Login;
import oralsys.persistencia.LoginDao;

public class LoginController extends LoginDao {
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
