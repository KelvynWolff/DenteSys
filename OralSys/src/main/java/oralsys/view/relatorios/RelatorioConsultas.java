package oralsys.view.relatorios;



import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RelatorioConsultas extends JFrame {

    public RelatorioConsultas() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        try {
            InputStream input = getClass().getResourceAsStream("/relatorios/Consultas.jrxml");

            if (input == null) {
                throw new RuntimeException("Não foi possível carregar o arquivo de relatório.");
            }
            JasperReport report = JasperCompileManager.compileReport(input);

            Map<String, Object> parameters = new HashMap<>();

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");


            JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);

            JasperViewer.viewReport(print, false);
        } catch (JRException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
