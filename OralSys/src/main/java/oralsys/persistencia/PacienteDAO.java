package oralsys.persistencia;

import oralsys.entidades.Paciente;
import java.util.List;

public class PacienteDao extends Dao {
   public List listarPaciente (String condicao) {   
        String queryString = "SELECT * FROM Paciente";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Paciente.class)
                 .getResultList();
    }
}
