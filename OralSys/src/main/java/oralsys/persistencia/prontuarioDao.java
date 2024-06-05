package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.Prontuario;

public class ProntuarioDao extends Dao {
    
    public List<Prontuario> buscarProntuario(Consulta consulta) {
        String queryString = "SELECT * FROM Prontuario WHERE consulta='" + consulta.getId() + "'";
        return em.createNativeQuery(queryString, Prontuario.class)
                 .getResultList();
    }
    
    public List<Prontuario> listarProntuario(String condicao) {
        String queryString = "SELECT * FROM Prontuario";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Prontuario.class)
                 .getResultList();
    }


}
