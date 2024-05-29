
import java.math.BigDecimal;

public class Dietas {
    private int id;
    private String empleado;
    private String departamento;
    private BigDecimal cantidad;
    private String concepto;

    public Dietas(int id, String empleado, String departamento, BigDecimal cantidad, String concepto) {
        this.id = id;
        this.empleado = empleado;
        this.departamento = departamento;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public Dietas(String empleado, String departamento, BigDecimal cantidad, String concepto) {
        this.empleado = empleado;
        this.departamento = departamento;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public int getId() {
        return id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public String getConcepto() {
        return concepto;
    }
}
