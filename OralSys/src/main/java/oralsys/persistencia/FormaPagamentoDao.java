package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.FormaPagamento;

public class FormaPagamentoDao extends Dao {
     public List listarFormaPagamento (String condicao) {   
        String queryString = "SELECT * FROM FormaPagamento";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, FormaPagamento.class)
                 .getResultList();
    }
    public FormaPagamento buscarPorId(Long id) {
        List<FormaPagamento> formaPagamentos = listarFormaPagamento("id = " + id);
        return formaPagamentos.isEmpty() ? null : formaPagamentos.get(0);
    }
}
