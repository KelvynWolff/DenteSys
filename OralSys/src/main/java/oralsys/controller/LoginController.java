package oralsys.controller;

import java.util.Arrays;
import oralsys.entidades.Login;
import oralsys.persistencia.LoginDao;

public class LoginController {
    private LoginDao loginDao;

    public LoginController(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public boolean validaAcesso(String loginPesquisa, char[] senha) {
        Login login = loginDao.buscarPorLogin(loginPesquisa);
        if (login != null && Arrays.equals(login.getSenha(), senha)) {
            return true;
        }
        return false;
    }
}
