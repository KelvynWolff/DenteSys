package oralsys.persistencia;

import oralsys.entidades.Consulta;

public class AgendamentoDao extends Dao {
    public String marcarConsulta(Consulta consulta) {
        String status = "";
        if (consulta.getFormaPagamentos().isEmpty()) {
            status = "Forma de pagamento invalida!";
        } else if (consulta.getPaciente().equals("") || consulta.getPaciente() == null) {
            status = "Paciente invalido!";
        } else if (consulta.getDentista().equals("") || consulta.getDentista() == null) {
            status = "Dentista invalido!";
        }
        if (status.equals("")) {
            this.salvar(consulta);
            status = "Sucesso!";
        }
        return status;
    }
    public String cancelarConsulta(Consulta consulta) {
        String status = "";
        if (consulta.getFormaPagamentos().isEmpty()) {
            status = "Forma de pagamento invalida!";
        } else if (consulta.getPaciente().equals("") || consulta.getPaciente() == null) {
            status = "Paciente invalido!";
        } else if (consulta.getDentista().equals("") || consulta.getDentista() == null) {
            status = "Dentista invalido!";
        }
        if (status.equals("")) {
            consulta.setStatus("CANCELADO");
            this.atualiza(consulta);
            status = "Sucesso!";
        }
        return status;
    }
    
    public String confirmarConsulta(Consulta consulta) {
        String status = "";
        if (consulta.getFormaPagamentos().isEmpty()) {
            status = "Forma de pagamento invalida!";
        } else if (consulta.getPaciente().equals("") || consulta.getPaciente() == null) {
            status = "Paciente invalido!";
        } else if (consulta.getDentista().equals("") || consulta.getDentista() == null) {
            status = "Dentista invalido!";
        }
        if (status.equals("")) {
            consulta.setStatus("CONFIRMADO");
            this.atualiza(consulta);
            status = "Sucesso!";
        }
        return status;
    }
}
