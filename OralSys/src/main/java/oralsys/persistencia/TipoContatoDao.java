package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.TipoContato;

public class TipoContatoDao extends Dao {
    public List listarTipoContato (String condicao) {   
        String queryString = "SELECT * FROM TipoContato";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, TipoContato.class)
                 .getResultList();
    }
    
    public TipoContato buscarPorId(Long id) {
        List<TipoContato> tipoContatos = listarTipoContato("id = " + id);
        return tipoContatos.isEmpty() ? null : tipoContatos.get(0);
    }
}
