package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Login;
import oralsys.persistencia.FuncionarioDao;
import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionarioController {

    private FuncionarioDao funcionarioDao = new FuncionarioDao();

    public String cadastrarFuncionario(JSONObject json) {
        Funcionario funcionario = converte(json);
        funcionarioDao.salvar(funcionario);
        return "Sucesso!";
    }

    public String alterarFuncionario(int id, JSONObject json) {
        Funcionario funcionario = converte(json);
        funcionario.setId(id);
        funcionarioDao.atualiza(funcionario);
        return "Sucesso!";
    }

    public String excluirFuncionario(int id) {
        List<String> status = new LinkedList<>();
        if (id <= 0) {
            status.add("ID Inválido!");
            return String.join(", ", status);
        }

        Funcionario funcionario = funcionarioDao.buscarPorId(id);
        if (funcionario == null) {
            status.add("Funcionário não encontrado!");
            return String.join(", ", status);
        }

        funcionarioDao.remove(funcionario);
        status.add("Sucesso!");
        return String.join(", ", status);
    }

   public JSONArray listarFuncionario(String condicao) {
    List<Funcionario> retorno = funcionarioDao.listarFuncionario(condicao);
    JSONArray jsonArray = new JSONArray();

    for (Funcionario funcionario : retorno) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", funcionario.getId());
        jsonObject.put("nome", funcionario.getNome());
        jsonObject.put("cpf", funcionario.getCpf());
        jsonObject.put("registro", funcionario.getRegistro());
        jsonObject.put("login", funcionario.getLogin().getLogin());

        
        if (funcionario.getFuncao() != null) {
           jsonObject.put("funcao", funcionario.getFuncao().getNome());
        } else {
            jsonObject.put("funcao", JSONObject.NULL);
        }

        jsonArray.put(jsonObject);
    }

    return jsonArray;
}

    public Funcionario converte(JSONObject json) {
    if (json == null) {
        throw new IllegalArgumentException("O objeto JSON não pode ser nulo");
    }

    Funcionario funcionario = new Funcionario();
    funcionario.setNome(json.optString("nome"));
    funcionario.setCpf(json.optString("cpf"));
    funcionario.setRegistro(json.optString("registro"));

    Login login = new Login();
    if (json.has("login")) {
        Object loginObj = json.get("login");
        if (loginObj instanceof JSONObject) {
            JSONObject loginJSON = (JSONObject) loginObj;
            login.setLogin(loginJSON.optString("login"));
            if (loginJSON.has("senha")) {
                String senha = loginJSON.getString("senha");
                login.setSenha(senha.toCharArray());
            } else {
                throw new IllegalArgumentException("Senha obrigatória não fornecida");
            }
        } else if (loginObj instanceof String) {
            login.setLogin((String) loginObj);
            throw new IllegalArgumentException("Formato de login inválido, objeto JSON esperado");
        }
    } else {
        throw new IllegalArgumentException("Campo 'login' é obrigatório");
    }
    funcionario.setLogin(login);

    return funcionario;
}

}
