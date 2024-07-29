public class Comprador {
    // Atributos ===================================================================================================
    private String NombreComprador;
    private String Mail;
    private float PresupuestoMax;
    private int CantTickets;
    
    // Métodos ==============================================================================================================
    public Comprador(String nombre, String mail, float presupuesto){
        this.NombreComprador = nombre;
        this.Mail = mail;
        this.PresupuestoMax = presupuesto;
        this.CantTickets = 0;
    }
    public String getNombreComprador() {
        return NombreComprador;
    }
    public void setNombreComprador(String nombreComprador) {
        NombreComprador = nombreComprador;
    }
    public String getMail() {
        return Mail;
    }
    public void setMail(String mail) {
        Mail = mail;
    }
    public float getPresupuestoMax() {
        return PresupuestoMax;
    }
    public void setPresupuestoMax(float presupuestoMax) {
        PresupuestoMax = presupuestoMax;
    }
    public int getCantTickets() {
        return CantTickets;
    }
    public void setCantTickets(int cantTickets) {
        this.CantTickets = cantTickets;
    }

    public void AsignacionTickets(int cantidadTicket){
        this.CantTickets = CantTickets + cantidadTicket;
    }
    
    
    
    
}
