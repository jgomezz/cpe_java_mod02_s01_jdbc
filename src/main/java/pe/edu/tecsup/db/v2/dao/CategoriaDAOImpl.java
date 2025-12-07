package pe.edu.tecsup.db.v2.dao;

import pe.edu.tecsup.db.v2.entidad.Categoria;
import pe.edu.tecsup.db.v2.utils.ConexionDB;

import java.sql.*;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> obtenerCategorias() {

        try {

            // Conectarme a la Base de datos
            Connection con = ConexionDB.obtenerConexion();

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return List.of();

    }

}
