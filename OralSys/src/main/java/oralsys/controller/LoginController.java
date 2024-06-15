package oralsys.controller;

import java.util.Arrays;
import oralsys.entidades.Login;
import oralsys.persistencia.LoginDao;

public class LoginController {
    private LoginDao loginDao;

    public LoginController() {
        this.loginDao = new LoginDao();
    }

    public boolean autenticar(String login, char[] senha) {
        Login usuario = loginDao.buscarPorLogin(login);
        if (usuario != null) {
            if (Arrays.equals(usuario.getSenha(), senha)) {
                return true;
            }
        }
        return false;
    }
}