package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.FormaPagamento;
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
}
