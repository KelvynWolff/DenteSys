package oralsys.persistencia;

import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;
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

    public List<Consulta> converterConsultasPorIds(JSONArray idsArray) {
        List<Consulta> consultas = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            int id = idsArray.getInt(i);
            ConsultaDao consultaDao = new ConsultaDao();
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
            PacienteDao pacienteDao = new PacienteDao();
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
            ProntuarioDao prontuarioDao = new ProntuarioDao();
            Prontuario prontuario = prontuarioDao.buscarPorId(id);
            if (prontuario != null) {
                prontuarios.add(prontuario);
            }
        }
        return prontuarios;
    }
    
    public List<Contato> converterContatosPorIds(JSONArray idsArray) {
        List<Contato> contatos = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            ContatoDao contatoDao = new ContatoDao();
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
            EnderecoDao enderecoDao = new EnderecoDao();
            Endereco endereco = enderecoDao.buscarPorId(id);
            if (endereco != null) {
                enderecos.add(endereco);
            }
        }
        return enderecos;
    }
    
    public Funcionario converterFuncionarioPorId(Long id) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return funcionarioDao.buscarPorId(id);
    }

    public List<FormaPagamento> converterFormaPagamentosPorIds(JSONArray idsArray) {
        List<FormaPagamento> formaPagamentos = new ArrayList<>();
        for (int i = 0; i < idsArray.length(); i++) {
            Long id = idsArray.getLong(i);
            FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao();
            FormaPagamento formaPagamento = formaPagamentoDao.buscarPorId(id);
            if (formaPagamento != null) {
                formaPagamentos.add(formaPagamento);
            }
        }
        return formaPagamentos;
    }
    
    public TipoPagamento converterTipoPagamentosPorIds(int id) {
        TipoPagamentoDao tipoPagamentoDao = new TipoPagamentoDao();
        return tipoPagamentoDao.buscarPorId(id);
    }

    public Paciente converterPacientePorId(Long id) {
        PacienteDao pacienteDao = new PacienteDao();
        return pacienteDao.buscarPorId(id);
    }
    
    public TipoContato converterTipoContatoPorId(Long id) {
        TipoContatoDao tipoContatoDao = new TipoContatoDao();
        return tipoContatoDao.buscarPorId(id);
    }
    
    public Cidade converterCidadePorId(Long id) {
        CidadeDao cidadeDao = new CidadeDao();
        return cidadeDao.buscarPorId(id);
    }
    
    public FormaPagamento converterFormaPagamentoPorId(Long id) {
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.buscarPorId(id);
    }
    
    public Consulta converterConsultaPorId(int id) {
        ConsultaDao consultaDao = new ConsultaDao();
        return consultaDao.buscarPorId(id);
    }
    
    public TipoPagamento converterTipoPagamentoPorId(int id) {
        TipoPagamentoDao tipoPagamentoDao = new TipoPagamentoDao();
        return tipoPagamentoDao.buscarPorId(id);
    }
    
    public Login converterLoginPorId(Long id) {
        LoginDao loginDao = new LoginDao();
        return loginDao.buscarPorId(id);
    }
}
