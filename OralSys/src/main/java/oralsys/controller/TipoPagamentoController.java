/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.TipoPagamento;
import oralsys.entidades.Paciente;
import oralsys.persistencia.TipoPagamentoDao;
import org.json.JSONObject;

public class TipoPagamentoController extends TipoPagamentoDao {
   public String inserirTipoPagamento(JSONObject tipoPagamento) {
        String status = "";
        if (tipoPagamento.get("tipo") == null) {
            status = "Tipo de Pagamento inválido!";
        }
        if (status.equals("")) {
            TipoPagamento tipoPagamentoClass = new TipoPagamento();
            tipoPagamentoClass.setTipoPagamento((String) tipoPagamento.get("tipoPagamento"));
            this.salvar(tipoPagamentoClass);
            status = "Sucesso!";
        }
        return status;
    }
    
    public String alterarTipoPagamento(JSONObject tipoPagamentoJSON) {
        List status = new LinkedList();
        if (tipoPagamentoJSON.get("id").equals("")) {
            status.add("ID Invalido!");
        }
       
        String condicao = "id=' " + tipoPagamentoJSON.get("id") + "'";
        if (status.equals("")) {
            List<TipoPagamento> tipoPagamento = this.listarTipoPagamento(condicao);
            if (!tipoPagamentoJSON.get("tipoPagamento").equals("")) {
                tipoPagamento.get(0).setTipoPagamento((String) tipoPagamentoJSON.get("tipoPagamento"));
            }
            this.atualiza(tipoPagamento);
            status.add("Sucesso!");
        }
        return status.toString();
    }
    
    public String removerTipoPagamento(String id) {
        List status = new LinkedList();
        if (id.equals("")) {
            status.add("ID Invalido!");
        }
        if (status.equals("")) {
            String condicao = "id=' " + id + "'";
            List<TipoPagamento> tipoPagamentos = this.listarTipoPagamento(condicao);
            this.remove(tipoPagamentos.get(0));
            status.add("Sucesso!");
        }
        return status.toString();
    } 
}
