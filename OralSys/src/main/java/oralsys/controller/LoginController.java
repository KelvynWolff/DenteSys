package oralsys.controller;

import java.util.Arrays;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Login;
import oralsys.persistencia.LoginDao;
import oralsys.persistencia.FuncionarioDao;

public class LoginController {
    private LoginDao loginDao;
    private FuncionarioDao funcionarioDao;
    private static String nomeFuncionarioLogado;

    public LoginController() {
        this.loginDao = new LoginDao();
        this.funcionarioDao = new FuncionarioDao();
    }

    public boolean autenticar(String login, char[] senha) {
        Login usuario = loginDao.buscarPorLogin(login);
        if (usuario != null) {
            if (Arrays.equals(usuario.getSenha(), senha)) {
                Funcionario funcionario = funcionarioDao.buscarPorLoginId(usuario.getId());
                if (funcionario != null) {
                    nomeFuncionarioLogado = funcionario.getNome();
                }
                return true;
            }
        }
        return false;
    }

    public static String getNomeFuncionarioLogado() {
        return nomeFuncionarioLogado;
    }
}
