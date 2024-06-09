package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Cidade;
import oralsys.entidades.Cidade;
import oralsys.entidades.Contato;

public class CidadeDao extends Dao {
    public List listarCidade (String condicao) {   
        String queryString = "SELECT * FROM Cidade";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Cidade.class)
                 .getResultList();
    }
    
    public Cidade buscarPorId(Long id) {
        List<Cidade> cidades = listarCidade("id = " + id);
        return cidades.isEmpty() ? null : cidades.get(0);
    }
}

