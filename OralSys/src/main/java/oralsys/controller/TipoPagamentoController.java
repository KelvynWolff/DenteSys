package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import oralsys.entidades.TipoPagamento;
import oralsys.persistencia.ConverterEntidades;
import oralsys.persistencia.TipoPagamentoDao;

public class TipoPagamentoController implements Controller {
    private TipoPagamentoDao tipoPagamentoDao;
    private ConverterEntidades converterEntidades;

    public TipoPagamentoController() {
        this.tipoPagamentoDao = new TipoPagamentoDao();
        this.converterEntidades = new ConverterEntidades();
    }

    @Override
    public TipoPagamento converte(JSONObject json) {
        if (json == null) {
            throw new IllegalArgumentException("O objeto JSON não pode ser nulo");
        }

        TipoPagamento tipoPagamento = new TipoPagamento();

        if (json.has("id")) {
            Long id = json.getLong("id");
            TipoPagamento tipoPagamentoExistente = converterEntidades.converterTipoPagamentoPorId(id);
            if (tipoPagamentoExistente != null) {
                tipoPagamento = tipoPagamentoExistente;
            }
        }

        tipoPagamento.setTipoPagamento(json.optString("tipoPagamento"));

        return tipoPagamento;
    }

    public String inserirTipoPagamento(JSONObject tipoPagamentoJSON) {
        List<String> status = new LinkedList<>();

        if (!tipoPagamentoJSON.has("tipoPagamento") || tipoPagamentoJSON.optString("tipoPagamento").isEmpty()) {
            status.add("Tipo de Pagamento inválido!");
        }

        if (status.isEmpty()) {
            try {
                TipoPagamento tipoPagamento = converte(tipoPagamentoJSON);
                tipoPagamentoDao.salvar(tipoPagamento);
                status.add("Sucesso!");
            } catch (IllegalArgumentException e) {
                status.add(e.getMessage());
            }
        }

        return String.join(", ", status);
    }

    public String alterarTipoPagamento(JSONObject tipoPagamentoJSON) {
        List<String> status = new LinkedList<>();

        if (!tipoPagamentoJSON.has("id") || tipoPagamentoJSON.optString("id").isEmpty()) {
            status.add("ID Inválido!");
        }

        if (status.isEmpty()) {
            try {
                TipoPagamento tipoPagamento = converte(tipoPagamentoJSON);
                tipoPagamentoDao.atualiza(tipoPagamento);
                status.add("Sucesso!");
            } catch (IllegalArgumentException e) {
                status.add(e.getMessage());
            }
        }

        return String.join(", ", status);
    }

    public String removerTipoPagamento(String id) {
        List<String> status = new LinkedList<>();

        if (id == null || id.isEmpty()) {
            status.add("ID Inválido!");
        }

        if (status.isEmpty()) {
            try {
                Long tipoPagamentoId = Long.parseLong(id);
                TipoPagamento tipoPagamento = converterEntidades.converterTipoPagamentoPorId(tipoPagamentoId);
                if (tipoPagamento != null) {
                    tipoPagamentoDao.remove(tipoPagamento);
                    status.add("Sucesso!");
                } else {
                    status.add("Tipo de Pagamento não encontrado!");
                }
            } catch (NumberFormatException e) {
                status.add("ID inválido!");
            }
        }

        return String.join(", ", status);
    }
}
