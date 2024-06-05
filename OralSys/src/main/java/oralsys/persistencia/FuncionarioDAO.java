package oralsys.persistencia;

import oralsys.entidades.Funcionario;
import oralsys.entidades.Paciente;
import oralsys.entidades.FormaPagamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FuncionarioDao extends Dao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("oralsysPU");

    public String cadastrarPaciente(Paciente paciente) {
        String status = "";
        if (paciente.getNome().isEmpty()) {
            status = "Nome inválido!";
        } else if (paciente.getCpf().isEmpty() || paciente.getCpf().length() != 14) {
            status = "CPF inválido!";
        } else if (paciente.getDataNascimento() == null) {
            status = "Data de nascimento inválida!";
        }
        if (status.equals("")) {
            this.salvar(paciente);
            status = "Sucesso!";
        }
        return status;
    }

    public String registrarFormaPagamento(FormaPagamento formaPagamento) {
        String status = "";
        if (formaPagamento.getValor() <= 0) {
            status = "Valor inválido!";
        } else if (formaPagamento.getConsulta() == null) {
            status = "Consulta inválida!";
        } else if (formaPagamento.getTipoPagamento() == null) {
            status = "Tipo de pagamento inválido!";
        }
        if (status.equals("")) {
            this.salvar(formaPagamento);
            status = "Sucesso!";
        }
        return status;
    }

    public void salvar(Funcionario funcionario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (funcionario.getId() == null) {
                em.persist(funcionario);
            } else {
                em.merge(funcionario);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Funcionario buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Funcionario funcionario = em.find(Funcionario.class, id);
            if (funcionario != null) {
                em.remove(funcionario);
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
