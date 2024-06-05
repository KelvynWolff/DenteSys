package oralsys.controller;

import oralsys.persistencia.CidadeDao;
import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Cidade;
import oralsys.entidades.Cidade;
import oralsys.entidades.Endereco;
import oralsys.entidades.Estado;
import oralsys.entidades.FormaPagamento;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import org.json.JSONObject;

public class CidadeController extends CidadeDao {
     public String cadastrarCidade(JSONObject cidadeJSON) {
        List status = new LinkedList();
        if (cidadeJSON.get("enderecos").equals("") || cidadeJSON.get("enderecos") == null) {
            status.add("Endereco invalido!");
        }
        if (cidadeJSON.get("estado").equals("")) {
            status.add("Estado invalido!");
        }
        if (cidadeJSON.get("nome").equals("") || cidadeJSON.get("nome") == null) {
            status.add("Nome invalido!");
        }
        if (status.equals("")) {
            Cidade cidade = new Cidade();
            cidade.setEnderecos((List<Endereco>) cidadeJSON.get("enderecos"));
            cidade.setEstado((Estado) cidadeJSON.get("estado"));
            cidade.setNome((String) cidadeJSON.get("nome"));
            status.add("Sucesso!");
            this.atualiza(cidade);
        }
            
        return status.toString();
    }
    public String excluirCidade(String id) {
        String status = "Sucesso!";
        if (id.isEmpty()) {
            status = "ID Invalido!";
        }
        String condicao = "id=' " + id + "'";
        if (status.equals("Sucesso!")) {
            List<Cidade> cidade = this.listarCidade(condicao);
            this.remove(cidade.get(0));
        }
        return status;
    }
    
}
