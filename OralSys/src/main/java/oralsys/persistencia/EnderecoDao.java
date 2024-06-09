package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Endereco;

public class EnderecoDao extends Dao {
    public List listarEndereco (String condicao) {   
        String queryString = "SELECT * FROM Endereco";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Endereco.class)
                 .getResultList();
    }
    
    public Endereco buscarPorId(Long id) {
        List<Endereco> enderecos = listarEndereco("id = " + id);
        return enderecos.isEmpty() ? null : enderecos.get(0);
    }
}
