import java.time.LocalDate;

public class Ticket {
    //Atributos ====================================================================================
    private LocalDate Fecha;
    private Localidad Tipo;
    private String NumeroTicket;
    
    //Métodos ==========================================================================================
    public Ticket(Localidad TipoTicket, int cantidadTickets){
        LocalDate fecha = LocalDate.now();
        this.Fecha = fecha;
        this.Tipo = TipoTicket;
        this.NumeroTicket = ""+fecha.toString()+"-" +cantidadTickets;
    }
    public LocalDate getFecha() {
        return Fecha;
    }
    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }
    public Localidad getTipo() {
        return Tipo;
    }
    public void setTipo(Localidad tipo) {
        Tipo = tipo;
    }
    public String getNumeroTicket() {
        return NumeroTicket;
    }
    public void setNumeroTicket(String numeroTicket) {
        NumeroTicket = numeroTicket;
    }
    public String NumeroTicket(){
        return "El Número del ticket comprado es " + NumeroTicket;
    }

    
}
