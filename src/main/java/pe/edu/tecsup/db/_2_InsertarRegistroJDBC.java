package pe.edu.tecsup.db;

import java.sql.*;

public class _2_InsertarRegistroJDBC {

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
                insert into categorias (nombre,descripcion,orden) values (?,?,?)
            """;
            PreparedStatement stmt= con.prepareStatement(sql);

            // Preparar los datos a Ingresar
            stmt.setString(1, "Portatiles");
            stmt.setString(2, "Portatiles de Gama Alta");
            stmt.setInt(3, 5);

            // Ejecutar la insercion
            int estado = stmt.executeUpdate();
            if (estado != 1)
                throw new SQLException("No se pudo insertar");

            // Obtener el ultimo id
            int id= 0;
            sql="select last_insert_id()";
            stmt= con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                id= rs.getInt(1);

            System.out.println("Se inserto el registro de categoria con ID " + id);

            // Cerrar conexiones
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
