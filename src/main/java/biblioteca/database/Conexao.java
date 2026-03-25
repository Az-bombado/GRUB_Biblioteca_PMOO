package biblioteca.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {

        try {

            String url = "jdbc:postgresql://localhost:5432/biblioteca";
            String usuario = "postgres";
            String senha = "sua_senha";

            Connection conn = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conectado ao banco!");

            return conn;

        } catch (Exception e) {

            System.out.println("Erro ao conectar");
            e.printStackTrace();
            return null;

        }

    }

}