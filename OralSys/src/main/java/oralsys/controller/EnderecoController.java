package oralsys.controller;

import oralsys.persistencia.EnderecoDao;
import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Cidade;
import oralsys.entidades.Endereco;
import oralsys.entidades.FormaPagamento;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import org.json.JSONObject;

public class EnderecoController extends EnderecoDao {
    public String cadastrarEndereco(JSONObject enderecoJSON) {
        List status = new LinkedList();
        if (enderecoJSON.get("dentista").equals("") || enderecoJSON.get("dentista") == null) {
            status.add("Dentista invalido!");
        }
        if (enderecoJSON.get("formaPagamento").equals("")) {
            status.add("Forma de pagamento invalida!");
        }
        if (enderecoJSON.get("paciente").equals("") || enderecoJSON.get("paciente") == null) {
            status.add("Paciente invalido!");
        }
        if (enderecoJSON.get("prontuario").equals("") || enderecoJSON.get("prontuario") == null) {
            status.add("Prontuario invalido!");
        }
        if (enderecoJSON.get("status").equals("") || enderecoJSON.get("status") == null) {
            status.add("Status invalido!");
        }
        if (status.equals("")) {
            Endereco endereco = new Endereco();
            endereco.setCidade((Cidade) enderecoJSON.get("cidade"));
            endereco.setPacientes((List<Paciente>) enderecoJSON.get("pacientes"));
            endereco.setRua((String) enderecoJSON.get("rua"));
            status.add("Sucesso!");
            this.salvar(endereco);
        }
            
        return status.toString();
    }
    public String alterarEndereco(String id, JSONObject enderecoJSON) {
        String status = "Sucesso!";
        if (id.isEmpty()) {
            status = "ID Invalido!";
        }
        String condicao = "id=' " + id + "'";
        if (status.equals("Sucesso!")) {
            List<Endereco> endereco = this.listarEndereco(condicao);
            if (!enderecoJSON.get("cidade").equals("")) {
                endereco.get(0).setCidade((Cidade) enderecoJSON.get("cidade"));
            }
            if (!enderecoJSON.get("pacientes").equals("")) {
                endereco.get(0).setPacientes((List<Paciente>) enderecoJSON.get("paciente"));
            }
            if (!enderecoJSON.get("rua").equals("")) {
                endereco.get(0).setRua((String) enderecoJSON.get("rua"));
            }
            this.atualiza(endereco);
        }
        return status;
    }
    
    public String excluirEndereco(String id) {
        String status = "Sucesso!";
        if (id.isEmpty()) {
            status = "ID Invalido!";
        }
        String condicao = "id=' " + id + "'";
        if (status.equals("Sucesso!")) {
            List<Endereco> endereco = this.listarEndereco(condicao);
            this.remove(endereco.get(0));
        }
        return status;
    }
}
