package pe.edu.tecsup.db.v1;

import java.sql.*;

public class _3_ActualizarRegistrosJDBC {

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
                UPDATE categorias SET nombre=? WHERE id=?
            """;
            PreparedStatement stmt= con.prepareStatement(sql);

            int id= 04; // PK del registro que se va a cambiar
            stmt.setString(1, "Nombre Cambiado");
            stmt.setInt(2, id);

            // Ejecutar la actualizacion
            int estado = stmt.executeUpdate();
            if (estado != 1)
                throw new SQLException("No se pudo actualizar");

            System.out.printf("Se actualiza la categoria con id = %d \n", id);

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
