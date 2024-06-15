package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Consulta;

public class ConsultaDao extends Dao {
    public List listarConsulta (String condicao, boolean join) {   
        String queryString = "SELECT * FROM Consulta";
        if (condicao != null && !condicao.isEmpty() && !join) {
            queryString += " WHERE " + condicao;
        } else if (condicao != null && !condicao.isEmpty()) {
            queryString += condicao;
        }
        return em.createNativeQuery(queryString, Consulta.class)
                 .getResultList();
    }
    
    public Consulta buscarPorId(int id) {
        List<Consulta> consultas = listarConsulta("id = " + id, false);
        return consultas.isEmpty() ? null : consultas.get(0);
    }
}
