package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.TipoContato;

public class TipoContatoDao extends Dao {

    public List<TipoContato> listarTipoContato(String condicao) {
        String queryString = "SELECT * FROM TipoContato";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, TipoContato.class)
                 .getResultList();
    }
}
