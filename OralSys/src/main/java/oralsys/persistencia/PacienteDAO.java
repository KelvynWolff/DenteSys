package oralsys.persistencia;

import oralsys.entidades.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PacienteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oralsysPU");

    public void inserirPaciente(Paciente paciente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Paciente buscarPaciente(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public List<Paciente> listarPacientes() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("FROM Paciente");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void alterarPaciente(Paciente paciente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(paciente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void removerPaciente(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Paciente paciente = em.find(Paciente.class, id);
            if (paciente != null) {
                em.remove(paciente);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
