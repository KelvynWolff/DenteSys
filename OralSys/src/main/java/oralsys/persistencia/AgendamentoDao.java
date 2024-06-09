package oralsys.persistencia;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Agendamento;
import oralsys.entidades.Consulta;

public class AgendamentoDao extends Dao {
    public List listarAgendamento (String condicao) {
        String queryString = "SELECT * FROM Agendamento";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Agendamento.class)
                 .getResultList();
    }
    public String marcarConsulta(Consulta consulta) {
        List status = new LinkedList();
        if (consulta.getFormaPagamentos().isEmpty()) {
            status.add("Forma de pagamento invalida!");
        } 
        if (consulta.getPaciente().equals("") || consulta.getPaciente() == null) {
            status.add("Paciente invalido!");
        }
        if (consulta.getDentista().equals("") || consulta.getDentista() == null) {
            status.add("Dentista invalido!");
        }
        if (status.equals("")) {
            this.salvar(consulta);
        }
        return status.toString();
    }
    public String cancelarConsulta(Consulta consulta) {
        List status = new LinkedList();
        if (consulta.getFormaPagamentos().isEmpty()) {
            status.add("Forma de pagamento invalida!");
        }
        if (consulta.getPaciente().equals("") || consulta.getPaciente() == null) {
            status.add("Paciente invalido!");
        }
        if (consulta.getDentista().equals("") || consulta.getDentista() == null) {
            status.add("Dentista invalido!");
        }
        if (status.equals("")) {
            consulta.setStatus("CANCELADO");
            this.atualiza(consulta);
        }
        return status.toString();
    }
    
    public String confirmarConsulta(Consulta consulta) {
        List status = new LinkedList();
        if (consulta.getFormaPagamentos().isEmpty()) {
            status.add("Forma de pagamento invalida!");
        }
        if (consulta.getPaciente().equals("") || consulta.getPaciente() == null) {
            status.add("Paciente invalido!");
        }
        if (consulta.getDentista().equals("") || consulta.getDentista() == null) {
            status.add("Dentista invalido!");
        }
        if (status.equals("")) {
            consulta.setStatus("CONFIRMADO");
            this.atualiza(consulta);
        }
        return status.toString();
    }
    
    public Agendamento buscarPorId(Long id) {
        List<Agendamento> agendamentos = listarAgendamento("id = " + id);
        return agendamentos.isEmpty() ? null : agendamentos.get(0);
    }
}
