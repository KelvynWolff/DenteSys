package oralsys.controller;

import java.util.Arrays;
import oralsys.entidades.Login;
import oralsys.persistencia.LoginDao;

public class LoginController {
    private LoginDao loginDao;

    public LoginController() {
        this.loginDao = new LoginDao();
    }

    public boolean autenticar(String login, String senha) {
        Login usuario = loginDao.buscarPorLogin(login);
        if (usuario != null && Arrays.equals(usuario.getSenha().toCharArray(), senha.toCharArray())) {
            return true;
        }
        return false;
    }
}
