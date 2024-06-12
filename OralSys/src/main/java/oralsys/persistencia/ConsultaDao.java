package oralsys.persistencia;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.Consulta;

public class ConsultaDao extends Dao {
    public List listarConsulta (String condicao) {   
        String queryString = "SELECT * FROM Consulta";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Consulta.class)
                 .getResultList();
    }
    
    public Consulta buscarPorId(int id) {
        List<Consulta> consultas = listarConsulta("id = " + id);
        return consultas.isEmpty() ? null : consultas.get(0);
    }
}
