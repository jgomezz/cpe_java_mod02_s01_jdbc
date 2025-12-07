package pe.edu.tecsup.db.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _4_EliminarRegistrosJDBC {

    public static void main(String[] args) {

        final String URL = "jdbc:mariadb://localhost/almacen";
        final String USER = "root";
        final String PASSWORD = "root";

        try {
            // Cargar el driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Conectarme a la Base de datos
            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);

            // Preparar la sentencia SQL
            String sql= """
                DELETE FROM categorias WHERE id = ?
            """;
            PreparedStatement stmt= con.prepareStatement(sql);

            // Configura el PK del registro a eliminar
            int id = 4; // ID a borrar
            stmt.setInt(1, id);

            // Ejecutar el borrado
            int estado = stmt.executeUpdate();
            if (estado != 1)
                throw new SQLException("No se pudo eliminar");

            System.out.printf("Se borro la categoria con id = %d \n", id);

            // Cerrar conexiones
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

}
