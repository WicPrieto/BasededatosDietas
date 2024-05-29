import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DietasDAO dietasDAO = new DietasDAO();

        // Crear la tabla
        dietasDAO.createTable();

        // Insertar datos en la tabla
        List<Dietas> dietasList = new ArrayList<>();
        dietasList.add(new Dietas("Juan Pérez", "Informática", new BigDecimal("45.50"), "Viaje a cliente"));
        dietasList.add(new Dietas("Ana García", "Ventas", new BigDecimal("60.00"), "Comida con cliente"));
        dietasList.add(new Dietas("Luis Torres", "Recursos Humanos", new BigDecimal("25.00"), "Capacitación"));
        dietasList.add(new Dietas("María López", "Informática", new BigDecimal("32.00"), "Compra de software"));
        dietasList.add(new Dietas("Pedro Martínez", "Ventas", new BigDecimal("55.00"), "Cena con cliente"));
        dietasList.add(new Dietas("Carlos Gómez", "Recursos Humanos", new BigDecimal("20.00"), "Reunión de equipo"));
        dietasList.add(new Dietas("Laura Fernández", "Informática", new BigDecimal("45.00"), "Conferencia"));
        dietasList.add(new Dietas("Sara Sánchez", "Ventas", new BigDecimal("35.00"), "Desplazamiento"));
        dietasList.add(new Dietas("Raúl Morales", "Recursos Humanos", new BigDecimal("18.00"), "Café con candidato"));
        dietasList.add(new Dietas("Elena Ruiz", "Informática", new BigDecimal("50.00"), "Hardware nuevo"));

        dietasDAO.insertDietas(dietasList);

        // Consultar y mostrar dietas de Informática mayores de 30€
        List<Dietas> dietasInformaticasMayorDe30 = dietasDAO.getDietasInformaticasMayorDe30();
        for (Dietas dieta : dietasInformaticasMayorDe30) {
            System.out.println("ID: " + dieta.getId() + ", Empleado: " + dieta.getEmpleado() +
                    ", Departamento: " + dieta.getDepartamento() +
                    ", Cantidad: " + dieta.getCantidad() + ", Concepto: " + dieta.getConcepto());
        }

        // Incrementar dietas del departamento de Ventas en un 10%
        dietasDAO.incrementarDietasVentas();
    }
}

