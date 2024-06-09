package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Estado;
import oralsys.entidades.Paciente;

public class EstadoDao extends Dao {
    public List listarEstado (String condicao) {   
        String queryString = "SELECT * FROM Estado";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Estado.class)
                 .getResultList();
    }
    
    public Estado buscarPorUf(String uf) {
        List<Estado> estados = listarEstado("uf = " + uf);
        return estados.isEmpty() ? null : estados.get(0);
    }
}
