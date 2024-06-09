package oralsys.persistencia;

import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;
import oralsys.entidades.Agendamento;
import oralsys.entidades.Cidade;
import oralsys.entidades.Consulta;
import oralsys.entidades.Contato;
import oralsys.entidades.Endereco;
import oralsys.entidades.FormaPagamento;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Login;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import oralsys.entidades.TipoContato;
import oralsys.entidades.TipoPagamento;

public class ConverterEntidades {

    private final ConsultaDao consultaDao;
    private final PacienteDao pacienteDao;
    private final ProntuarioDao prontuarioDao;
    private final AgendamentoDao agendamentoDao;
    private final ContatoDao contatoDao;
    private final EnderecoDao enderecoDao;
    private final FuncionarioDao funcionarioDao;
    private final FormaPagamentoDao formaPagamentoDao;
    private final TipoContatoDao tipoContatoDao;
    private final CidadeDao cidadeDao;
    private final TipoPagamentoDao tipoPagamentoDao;
    private final LoginDao loginDao;

    public ConverterEntidades(ConsultaDao consultaDao, PacienteDao pacienteDao, ProntuarioDao prontuarioDao, AgendamentoDao agendamentoDao, ContatoDao contatoDao, EnderecoDao enderecoDao, FuncionarioDao funcionarioDao, FormaPagamentoDao formaPagamentoDao, TipoContatoDao tipoContatoDao, CidadeDao cidadeDao, TipoPagamentoDao tipoPagamentoDao, LoginDao loginDao) {
        this.consultaDao = consultaDao;
        this.pacienteDao = pacienteDao;
        this.prontuarioDao = prontuarioDao;
        this.agendamentoDao = agendamentoDao;
        this.contatoDao = contatoDao;
        this.enderecoDao = enderecoDao;
        this.funcionarioDao = funcionarioDao;
        this.formaPagamentoDao = formaPagamentoDao;
        this.tipoContatoDao = tipoContatoDao;
        this.cidadeDao = cidadeDao;
        this.tipoPagamentoDao = tipoPagamentoDao;
        this.loginDao = loginDao;
    }

    public List<Consulta> converterConsultasPorIds(JSONArray idsArray) {
        List<Consulta> consultas = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            Consulta consulta = consultaDao.buscarPorId(id);
            if (consulta != null) {
                consultas.add(consulta);
            }
        }
        return consultas;
    }

    public List<Paciente> converterPacientesPorIds(JSONArray idsArray) {
        List<Paciente> pacientes = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            Paciente paciente = pacienteDao.buscarPorId(id);
            if (paciente != null) {
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }

    public List<Prontuario> converterProntuariosPorIds(JSONArray idsArray) {
        List<Prontuario> prontuarios = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            Prontuario prontuario = prontuarioDao.buscarPorId(id);
            if (prontuario != null) {
                prontuarios.add(prontuario);
            }
        }
        return prontuarios;
    }

    public List<Agendamento> converterAgendamentosPorIds(JSONArray idsArray) {
        List<Agendamento> agendamentos = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            Agendamento agendamento = agendamentoDao.buscarPorId(id);
            if (agendamento != null) {
                agendamentos.add(agendamento);
            }
        }
        return agendamentos;
    }
    
    public List<Contato> converterContatosPorIds(JSONArray idsArray) {
        List<Contato> contatos = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            Contato contato = contatoDao.buscarPorId(id);
            if (contato != null) {
                contatos.add(contato);
            }
        }
        return contatos;
    }
    
    public List<Endereco> converterEnderecosPorIds(JSONArray idsArray) {
        List<Endereco> enderecos = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            Endereco endereco = enderecoDao.buscarPorId(id);
            if (endereco != null) {
                enderecos.add(endereco);
            }
        }
        return enderecos;
    }
    
    public Funcionario converterFuncionarioPorId(Long id) {
        return funcionarioDao.buscarPorId(id);
    }

    public List<FormaPagamento> converterFormaPagamentosPorIds(JSONArray idsArray) {
        List<FormaPagamento> formaPagamentos = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            FormaPagamento formaPagamento = formaPagamentoDao.buscarPorId(id);
            if (formaPagamento != null) {
                formaPagamentos.add(formaPagamento);
            }
        }
        return formaPagamentos;
    }

    public Paciente converterPacientePorId(Long id) {
        return pacienteDao.buscarPorId(id);
    }
    
    public TipoContato converterTipoContatoPorId(Long id) {
        return tipoContatoDao.buscarPorId(id);
    }
    
    public Cidade converterCidadePorId(Long id) {
        return cidadeDao.buscarPorId(id);
    }
    
    public FormaPagamento converterFormaPagamentoPorId(Long id) {
        return formaPagamentoDao.buscarPorId(id);
    }
    
    public Consulta converterConsultaPorId(Long id) {
        return consultaDao.buscarPorId(id);
    }
    
    public TipoPagamento converterTipoPagamentoPorId(Long id) {
        return tipoPagamentoDao.buscarPorId(id);
    }
    
    public Login converterLoginPorId(Long id) {
        return loginDao.buscarPorId(id);
    }
}
