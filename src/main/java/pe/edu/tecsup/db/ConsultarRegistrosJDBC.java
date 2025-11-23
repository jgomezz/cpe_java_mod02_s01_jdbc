package pe.edu.tecsup.db;

public class ConsultarRegistrosJDBC {

    public static void main(String[] args) {


        try {
            // Cargar el driver
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
