public class Localidad {
    // Atributos =============================================================================================
    private String Nombre;
    private float Precio;
    private int CantidadAsientos;
    private int AsientosOcupados;
    
    // Métodos ======================================================================================================
    public Localidad(String nombre, float precio, int cantidadasientos, int asientosocupados){
        this.Nombre = nombre;
        this.Precio = precio;
        this.CantidadAsientos = cantidadasientos;
        this.AsientosOcupados = asientosocupados;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public float getPrecio() {
        return Precio;
    }
    public void setPrecio(float precio) {
        Precio = precio;
    }
    public int getCantidadAsientos() {
        return CantidadAsientos;
    }
    public void setCantidadAsientos(int cantidadAsientos) {
        CantidadAsientos = cantidadAsientos;
    }
    public int getAsientosOcupados() {
        return AsientosOcupados;
    }
    public void setAsientosOcupados(int asientosOcupados) {
        AsientosOcupados = asientosOcupados;
    }

    public String toString() {
        return "Nombre=" + Nombre + ", Precio=" + Precio + ", CantidadAsientos=" + CantidadAsientos
                + ", AsientosOcupados=" + AsientosOcupados + "";
    }

    public void AgregarAsientosOcupados(int ocupados){
        this.AsientosOcupados = this.AsientosOcupados+ocupados;
    }
    
}
