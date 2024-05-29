import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DietasDAO {

    public void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Dietas ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "empleado VARCHAR(100) NOT NULL, "
                + "departamento VARCHAR(100) NOT NULL, "
                + "cantidad DECIMAL(10, 2) NOT NULL, "
                + "concepto VARCHAR(255) NOT NULL)";

        try (Connection connection = Conexion.DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Tabla 'Dietas' creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDietas(List<Dietas> dietasList) {
        String insertSQL = "INSERT INTO Dietas (empleado, departamento, cantidad, concepto) VALUES (?, ?, ?, ?)";

        try (Connection connection = Conexion.DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            for (Dietas dieta : dietasList) {
                preparedStatement.setString(1, dieta.getEmpleado());
                preparedStatement.setString(2, dieta.getDepartamento());
                preparedStatement.setBigDecimal(3, dieta.getCantidad());
                preparedStatement.setString(4, dieta.getConcepto());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            System.out.println("Datos insertados correctamente en la tabla 'Dietas'.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Dietas> getDietasInformaticasMayorDe30() {
        String querySQL = "SELECT * FROM Dietas WHERE departamento = 'Informática' AND cantidad > 30";
        List<Dietas> dietasList = new ArrayList<>();

        try (Connection connection = Conexion.DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String empleado = resultSet.getString("empleado");
                String departamento = resultSet.getString("departamento");
                BigDecimal cantidad = resultSet.getBigDecimal("cantidad");
                String concepto = resultSet.getString("concepto");

                dietasList.add(new Dietas(id, empleado, departamento, cantidad, concepto));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dietasList;
    }

    public void incrementarDietasVentas() {
        String updateSQL = "UPDATE Dietas SET cantidad = cantidad * 1.10 WHERE departamento = 'Ventas'";

        try (Connection connection = Conexion.DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Número de filas actualizadas: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

