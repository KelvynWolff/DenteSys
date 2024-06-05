package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.FormaPagamento;
import oralsys.persistencia.FormaPagamentoDao;
import org.json.JSONObject;

public class FormaPagamentoController extends FormaPagamentoDao {
    public String registrarPagamento(JSONObject formaPagamentoJSON) {
        List status = new LinkedList();
        if (formaPagamentoJSON.get("consulta").equals("") || formaPagamentoJSON.get("consulta") == null) {
            status.add("Consulta invalida!");
        } 
        if (formaPagamentoJSON.get("tipoPagamento").equals("") || formaPagamentoJSON.get("tipoPagamento") == null) {
            status.add("Tipo de pagamento invalido!");
        }
        if (formaPagamentoJSON.get("valor").equals(0)) {
            status.add("Forma de pagamento invalido!");
        }
        if (status.equals("")) {
            this.salvar(formaPagamentoJSON);
            status.add("Sucesso!");
        }
        return status.toString();
    }
}
