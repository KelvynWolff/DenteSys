package oralsys.persistencia;

import oralsys.entidades.FormaPagamento;

public class FormaPagamentoDao extends Dao {
    public String registrarPagamento(FormaPagamento formaPagamento) {
        String status = "";
        if (formaPagamento.getConsulta().equals("") || formaPagamento.getConsulta() == null) {
            status = "Consulta invalida!";
        } else if (formaPagamento.getTipoPagamento().equals("") || formaPagamento.getTipoPagamento() == null) {
            status = "Tipo de pagamento invalido!";
        } else if (formaPagamento.getValor() <= 0) {
            status = "Forma de pagamento invalido!";
        }
        if (status.equals("")) {
            this.salvar(formaPagamento);
            status = "Sucesso!";
        }
        return status;
    }
}
