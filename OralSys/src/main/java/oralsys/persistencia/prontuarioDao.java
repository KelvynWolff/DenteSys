package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.Login;
import oralsys.entidades.Prontuarios;

public class prontuarioDao extends Dao {
    public String cadastrarProntuario(Prontuarios prontuarios) {
        String status = "";
        if (prontuarios.getConsulta() == null || prontuarios.getConsulta().equals("")) {
            status = "Paciente invalido!";
        }
        if (prontuarios.getProntuario().equals("") || prontuarios.getConsulta() == null) {
            status = "Prontuario invalido!";
        }
        if (status.equals("")) {
            this.salvar(prontuarios);
            status = "Sucesso!";
        }
        return status;
    }
    
    public List buscarProntuario(Consulta consulta) {
        String queryString = "SELECT * FROM Prontuarios WHERE consulta='" + consulta.getId() + "'";
        return em.createNativeQuery(queryString, Login.class)
                 .getResultList();
    }
    
    public List listarProntuario() {
        String queryString = "SELECT * FROM Prontuarios";
        return em.createNativeQuery(queryString, Login.class)
                 .getResultList();
    }
}
