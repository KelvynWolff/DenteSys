    package oralsys.controller;

    import java.util.LinkedList;
    import java.util.List;
    import oralsys.entidades.FormaPagamento;
    import oralsys.entidades.Consulta;
    import oralsys.entidades.TipoPagamento;
    import oralsys.persistencia.FormaPagamentoDao;
    import oralsys.persistencia.ConverterEntidades;
import org.json.JSONArray;
    import org.json.JSONObject;

    public class FormaPagamentoController implements Controller {
        private FormaPagamentoDao formaPagamentoDao;
        private ConverterEntidades converterEntidades;

        public FormaPagamentoController() {
            this.formaPagamentoDao = new FormaPagamentoDao();
            this.converterEntidades = new ConverterEntidades();
        }

        @Override
        public FormaPagamento converte(JSONObject json) {
            if (json == null) {
                throw new IllegalArgumentException("O objeto JSON não pode ser nulo");
            }

            FormaPagamento formaPagamento = new FormaPagamento();

            if (json.has("consultaId")) {
                int consultaId = json.getInt("consultaId");
                Consulta consulta = converterEntidades.converterConsultaPorId(consultaId);
                formaPagamento.setConsulta(consulta);
            }

            if (json.has("tipoPagamentoId")) {
                int tipoPagamentoId = json.getInt("tipoPagamentoId");
                TipoPagamento tipoPagamento = converterEntidades.converterTipoPagamentoPorId(tipoPagamentoId);
                formaPagamento.setTipoPagamento(tipoPagamento);
            }

            formaPagamento.setValor(json.optDouble("valor"));

            return formaPagamento;
        }

        public String registrarPagamento(JSONObject formaPagamentoJSON) {
            List<String> status = new LinkedList<>();

            if (!formaPagamentoJSON.has("consultaId") || formaPagamentoJSON.optString("consultaId").isEmpty()) {
                status.add("Consulta inválida!");
            }
            if (!formaPagamentoJSON.has("tipoPagamentoId") || formaPagamentoJSON.optString("tipoPagamentoId").isEmpty()) {
                status.add("Tipo de pagamento inválido!");
            }
            if (!formaPagamentoJSON.has("valor") || formaPagamentoJSON.optDouble("valor") == 0) {
                status.add("Valor de pagamento inválido!");
            }

            if (status.isEmpty()) {
                try {
                    FormaPagamento formaPagamento = converte(formaPagamentoJSON);
                    if (formaPagamento.getConsulta() == null) {
                        status.add("Consulta não encontrada!");
                    } else if (formaPagamento.getTipoPagamento() == null) {
                        status.add("Tipo de pagamento não encontrado!");
                    } else {
                        formaPagamentoDao.salvar(formaPagamento);
                        status.add("Sucesso!");
                    }
                } catch (IllegalArgumentException e) {
                    status.add(e.getMessage());
                }
            }

            return String.join(", ", status);
        }
        
        public JSONArray listarFormaPagamento(String condicao) {
            FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao();
            List<FormaPagamento> retorno = formaPagamentoDao.listarFormaPagamento(condicao);

            JSONArray jsonArray = new JSONArray();

            for (FormaPagamento formaPagamento : retorno) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", formaPagamento.getId());
                jsonArray.put(jsonObject);
            }

            return jsonArray;
        }
    }