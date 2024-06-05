package oralsys.controller;

import java.util.List;
import java.util.LinkedList;
import oralsys.entidades.Funcao;
import oralsys.persistencia.FuncaoDao;
import org.json.JSONObject;


public class FuncaoController extends FuncaoDao {

    public String criarFuncao(JSONObject funcaoJSON) {
        List<String> status = new LinkedList<>();
        
        if (funcaoJSON.get("nome") == null || funcaoJSON.getString("nome").isEmpty()) {
            status.add("Nome inválido!");
        }
        if (funcaoJSON.get("descricao") == null || funcaoJSON.getString("descricao").isEmpty()) {
            status.add("Descrição inválida!");
        }
        
        if (status.isEmpty()) {
            Funcao funcao = new Funcao();
            funcao.setNome(funcaoJSON.getString("nome"));
            funcao.setDescricao(funcaoJSON.getString("descricao"));
            this.salvar(funcao);
            status.add("Sucesso!");
        }
        
        return status.toString();
    }

    public String atualizarFuncao(JSONObject funcaoJSON) {
        List<String> status = new LinkedList<>();
        
        if (funcaoJSON.get("id") == null || funcaoJSON.getLong("id") == 0) {
            status.add("ID inválido!");
        }
        if (funcaoJSON.get("nome") == null || funcaoJSON.getString("nome").isEmpty()) {
            status.add("Nome inválido!");
        }
        if (funcaoJSON.get("descricao") == null || funcaoJSON.getString("descricao").isEmpty()) {
            status.add("Descrição inválida!");
        }
        
        if (status.isEmpty()) {
            String condicao = "id = " + funcaoJSON.getLong("id");
            List<Funcao> funcoes = this.listarFuncao(condicao);
            if (!funcoes.isEmpty()) {
                Funcao funcao = funcoes.get(0);
                funcao.setNome(funcaoJSON.getString("nome"));
                funcao.setDescricao(funcaoJSON.getString("descricao"));
                this.atualiza(funcao);
                status.add("Sucesso!");
            } else {
                status.add("Função não encontrada!");
            }
        }
        
        return status.toString();
    }

    public String removerFuncao(Long id) {
        String status = "Sucesso!";
        if (id == null || id == 0) {
            status = "ID inválido!";
        }
        
        if (status.equals("Sucesso!")) {
            String condicao = "id = " + id;
            List<Funcao> funcoes = this.listarFuncao(condicao);
            if (!funcoes.isEmpty()) {
                Funcao funcao = funcoes.get(0);
                this.remove(funcao);
            } else {
                status = "Função não encontrada!";
            }
        }
        
        return status;
    }


}
