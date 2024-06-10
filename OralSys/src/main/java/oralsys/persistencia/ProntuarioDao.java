package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.Login;
import oralsys.entidades.Prontuario;
import oralsys.entidades.Prontuarios;

public class ProntuarioDao extends Dao {
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
    
    public List listarProntuario (String condicao) {   
        String queryString = "SELECT * FROM Prontuario";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Prontuario.class)
                 .getResultList();
    }
    
    public List buscarProntuario() {
        String queryString = "SELECT * FROM Prontuarios";
        return em.createNativeQuery(queryString, Login.class)
                 .getResultList();
    }
    
    public Prontuario buscarPorId(Long id) {
        List<Prontuario> prontuarios = listarProntuario("id = " + id);
        return prontuarios.isEmpty() ? null : prontuarios.get(0);
    }
}
