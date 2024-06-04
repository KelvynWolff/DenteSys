package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.Contato;
import oralsys.entidades.Paciente;
import oralsys.entidades.TipoContato;
import oralsys.persistencia.ContatoDao;
import org.json.JSONObject;

public class ContatoController extends ContatoDao {
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
    
    public String alterarContato(JSONObject contatoJSON) {
        List status = new LinkedList();
        if (contatoJSON.get("id").equals("")) {
            status.add("ID Invalido!");
        }
       
        String condicao = "id=' " + contatoJSON.get("id") + "'";
        if (status.equals("")) {
            List<Contato> contato = this.listarContato(condicao);
            if (!contatoJSON.get("tipo").equals("")) {
                contato.get(0).setTipo((TipoContato) contatoJSON.get("tipo"));
            }
            if (!contatoJSON.get("informacao").equals("")) {
                contato.get(0).setInformacao((String) contatoJSON.get("informacao"));
            }
            if (!contatoJSON.get("paciente").equals("")) {
                contato.get(0).setPaciente((Paciente) contatoJSON.get("paciente"));
            }
            this.atualiza(contato);
            status.add("Sucesso!");
        }
        return status.toString();
    }
    
    public String removerContato(String id) {
        List status = new LinkedList();
        if (id.equals("")) {
            status.add("ID Invalido!");
        }
        if (status.equals("")) {
            String condicao = "id=' " + id + "'";
            List<Contato> contatos = this.listarContato(condicao);
            this.remove(contatos.get(0));
            status.add("Sucesso!");
        }
        return status.toString();
    }
}
