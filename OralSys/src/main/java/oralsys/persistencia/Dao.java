package oralsys.persistencia;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import oralsys.entidades.Login;
import static oralsys.entidades.Login_.senha;

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
     public void remove(Object o){
        etx.begin();
        em.remove(o);
        etx.commit();
    }
}