package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.TipoPagamento;

public class TipoPagamentoDao extends Dao {
    public List listarTipoPagamento (String condicao) {   
        String queryString = "SELECT * FROM TipoPagamento";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, TipoPagamento.class)
                 .getResultList();
    }
    
    public TipoPagamento buscarPorId(Long id) {
        List<TipoPagamento> tipoPagamentos = listarTipoPagamento("id = " + id);
        return tipoPagamentos.isEmpty() ? null : tipoPagamentos.get(0);
    }
}
