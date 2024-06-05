package oralsys.persistencia;

import oralsys.entidades.Paciente;
import java.util.List;

<<<<<<< HEAD
public class PacienteDao extends Dao {
   public List listarPaciente (String condicao) {   
        String queryString = "SELECT * FROM Paciente";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
=======
public class PacienteDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oralsysPU");

    public void inserirPaciente(Paciente paciente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } finally {
            em.close();
>>>>>>> kelvyn
        }
        return em.createNativeQuery(queryString, Paciente.class)
                 .getResultList();
    }
}
