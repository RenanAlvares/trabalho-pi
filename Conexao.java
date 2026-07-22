import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    private static Connection conn;

    // Carrega as credenciais de um arquivo db.properties (fora do controle de versao).
    // Se o arquivo nao existir, usa os valores padrao abaixo.
    private static Properties carregarConfig() {
        Properties props = new Properties();
        props.setProperty("db.url", "jdbc:mysql://localhost:3306/projeto_interdisciplinar");
        props.setProperty("db.user", "root");
        props.setProperty("db.password", "");
        try (FileInputStream in = new FileInputStream("db.properties")) {
            props.load(in);
        } catch (IOException e) {
            System.out.println("Aviso: db.properties nao encontrado. Usando configuracao padrao "
                + "(copie db.properties.example para db.properties e ajuste as credenciais).");
        }
        return props;
    }

    public static Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                Properties cfg = carregarConfig();
                conn = DriverManager.getConnection(
                    cfg.getProperty("db.url"),
                    cfg.getProperty("db.user"),
                    cfg.getProperty("db.password")
                );
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
