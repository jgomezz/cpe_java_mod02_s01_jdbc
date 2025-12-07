package pe.edu.tecsup.db.v2.dao;

import pe.edu.tecsup.db.v2.entidad.Categoria;
import pe.edu.tecsup.db.v2.utils.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> obtenerCategorias() {

        List<Categoria> categorias = new ArrayList<Categoria>();

        try {

            // Conectarme a la Base de datos
            Connection con = ConexionDB.obtenerConexion();

            // Preparar la sentencia
            String sql= """
                            SELECT * FROM categorias
                        """;
            PreparedStatement stmt= con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                // Lee informacion de un registro de la tabla categorias
                int id= rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String orden = rs.getString("orden");

                // Crea un objeto Categoria
                Categoria categoria = new Categoria();
                categoria.setId(id);
                categoria.setNombre(nombre);
                categoria.setDescripcion(descripcion);
                categoria.setOrden(orden);

                // Agrega el objeto a la lista
                categorias.add(categoria);
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

        return categorias;

    }

}
