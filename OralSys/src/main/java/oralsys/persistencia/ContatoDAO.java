package oralsys.persistencia;

import oralsys.entidades.Contato;

public class ContatoDAO extends Dao {
    
    public String inserirContato(Contato contato) {
        String status = "";
        if (contato.getInformacao().isEmpty()) {
            status = "Informação inválida!";
        } else if (contato.getPaciente() == null) {
            status = "Paciente inválido!";
        } else if (contato.getTipo() == null) {
            status = "Tipo de contato inválido!";
        }
        if (status.equals("")) {
            this.salvar(contato);
            status = "Sucesso!";
        }
        return status;
    }
    
    public String alterarContato(Contato contato) {
        String status = "";
        if (contato.getInformacao().isEmpty()) {
            status = "Informação inválida!";
        } else if (contato.getPaciente() == null) {
            status = "Paciente inválido!";
        } else if (contato.getTipo() == null) {
            status = "Tipo de contato inválido!";
        }
        if (status.equals("")) {
            this.atualiza(contato);
            status = "Sucesso!";
        }
        return status;
    }
    
    public void removerContato(Contato contato) {
        this.remove(contato);
    }
}
