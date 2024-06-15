package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Consulta;
import oralsys.entidades.Login;
import oralsys.persistencia.FuncionarioDao;
import oralsys.persistencia.ConverterEntidades;
import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionarioController implements Controller {
    private FuncionarioDao funcionarioDao;
    private ConverterEntidades converterEntidades;

    public FuncionarioController() {
        this.funcionarioDao = new FuncionarioDao();
        this.converterEntidades = new ConverterEntidades();
    }

    @Override
    public Funcionario converte(JSONObject json) {
        if (json == null) {
            throw new IllegalArgumentException("O objeto JSON não pode ser nulo");
        }

        Funcionario funcionario = new Funcionario();

        if (json.has("consultasIds")) {
            JSONArray consultasIds = json.getJSONArray("consultasIds");
            List<Consulta> consultas = converterEntidades.converterConsultasPorIds(consultasIds);
            funcionario.setConsultas(consultas);
        }

        if (json.has("loginId")) {
            Long loginId = json.getLong("loginId");
            Login login = converterEntidades.converterLoginPorId(loginId);
            funcionario.setLogin(login);
        }

        funcionario.setNome(json.optString("nome"));
        funcionario.setRegistro(json.optString("registro"));

        return funcionario;
    }

    public String cadastrarFuncionario(JSONObject funcionarioJSON) {
        List<String> status = new LinkedList<>();

        if (!funcionarioJSON.has("agendamentosIds") || funcionarioJSON.optJSONArray("agendamentosIds").length() == 0) {
            status.add("Agendamento inválido!");
        }
        if (!funcionarioJSON.has("consultasIds") || funcionarioJSON.optJSONArray("consultasIds").length() == 0) {
            status.add("Consulta inválida!");
        }
        if (!funcionarioJSON.has("loginId") || funcionarioJSON.optString("loginId").isEmpty()) {
            status.add("Login inválido!");
        }
        if (funcionarioJSON.optString("nome").isEmpty()) {
            status.add("Nome inválido!");
        }
        if (funcionarioJSON.optString("registro").isEmpty()) {
            status.add("Registro inválido!");
        }

        if (status.isEmpty()) {
            try {
                Funcionario funcionario = converte(funcionarioJSON);
                funcionarioDao.salvar(funcionario);
                status.add("Sucesso!");
            } catch (IllegalArgumentException e) {
                status.add(e.getMessage());
            }
        }

        return String.join(", ", status);
    }
    
    public JSONArray listarFuncionario(String condicao) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        List<Funcionario> retorno = funcionarioDao.listarFuncionario(condicao);

        JSONArray jsonArray = new JSONArray();

        for (Funcionario funcionario : retorno) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", funcionario.getId());
            jsonObject.put("nome", funcionario.getNome());
            jsonObject.put("registro", funcionario.getRegistro());
            jsonObject.put("funcao", funcionario.getFuncao().getNome());
            jsonArray.put(jsonObject);
        }

        return jsonArray;
    }
}