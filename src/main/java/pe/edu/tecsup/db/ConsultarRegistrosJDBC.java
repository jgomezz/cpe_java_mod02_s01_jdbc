package pe.edu.tecsup.db;

import java.sql.*;

public class ConsultarRegistrosJDBC {

    public static void main(String[] args) {

        final String URL = "jdbc:mariadb://localhost/almacen";
        final String USER = "root";
        final String PASSWORD = "root";


        try {
            // Cargar el driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Conectarme a la Base de datos
            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);

            // Preparar la sentencia
            String sql= "SELECT * FROM categorias";
            PreparedStatement stmt= con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int id= rs.getInt("id");
                String nombre = rs.getString("nombre");
                System.out.printf("id = %d , nombre=%s \n", id,nombre);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
