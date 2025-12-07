package pe.edu.tecsup.db.v2.servicio;

import pe.edu.tecsup.db.v2.dao.CategoriaDAO;
import pe.edu.tecsup.db.v2.dao.CategoriaDAOImpl;

public class CategoriaServicio {

    private CategoriaDAO categoriaDAO;

    public CategoriaServicio() {
        this.categoriaDAO = new CategoriaDAOImpl();
    }

    public static void main(String[] args) {
        CategoriaServicio servicio = new CategoriaServicio();
        servicio.buscarCategorias();
    }

    public void buscarCategorias() {
        categoriaDAO.obtenerCategorias().forEach(categoria -> {
            System.out.println("ID: " + categoria.getId());
            System.out.println("Nombre: " + categoria.getNombre());
            System.out.println("Descripcion: " + categoria.getDescripcion());
            System.out.println("Orden: " + categoria.getOrden());
            System.out.println("---------------------------");
        });
    }

}
