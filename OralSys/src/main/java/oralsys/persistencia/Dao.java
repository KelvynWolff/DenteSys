package oralsys.persistencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Dao {
    EntityManagerFactory emf=
            Persistence.
                    createEntityManagerFactory("oralsys_OralSys_jar_1.0-SNAPSHOTPU");
    EntityManager em =emf.createEntityManager();
    EntityTransaction etx = em.getTransaction();

    public void salvar(Object o){
        etx.begin();
        em.persist(o);
        etx.commit();
    }
    public void atualiza(Object o){
        etx.begin();
        em.merge(o);
        etx.commit();
    }
    public void remove(Object o) {
        etx.begin();
        if (!em.contains(o)) {
            o = em.merge(o);
        }
        em.remove(o);
        etx.commit();
    }
}