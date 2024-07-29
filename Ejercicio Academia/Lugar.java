public class Lugar {
    // Atributos =====================================================================================================
    private String NombreLugar;
    private Localidad Balcon1;
    private Localidad Platea;
    private Localidad Balcon2;
    private int VentasFacturadas;
    private int CantidadTicketsVendidos;
    
    // Métodos ========================================================================================================
    
    public Lugar(String Nombre,int AsientosBalcon1, int AsientosPlatea, int AsientosBalcon2){
        this.NombreLugar = Nombre;
        this.Balcon1 = new Localidad("Balcon 1", 1800, AsientosBalcon1, 0);
        this.Platea = new Localidad("Platea", 600, AsientosPlatea, 0);
        this.Balcon2 = new Localidad("Balcon 2", 300, AsientosBalcon2, 0);
        this.CantidadTicketsVendidos = 0;   
    }
    public String getNombreLugar() {
        return NombreLugar;
    }
    public void setNombreLugar(String nombreLugar) {
        NombreLugar = nombreLugar;
    }
    public Localidad getBalcon1() {
        return Balcon1;
    }
    public void setBalcon1(Localidad balcon1) {
        Balcon1 = balcon1;
    }
    public Localidad getPlatea() {
        return Platea;
    }
    public void setPlatea(Localidad platea) {
        Platea = platea;
    }
    public Localidad getBalcon2() {
        return Balcon2;
    }
    public void setBalcon2(Localidad balcon2) {
        Balcon2 = balcon2;
    }
    public int getVentasFacturadas() {
        return VentasFacturadas;
    }
    public void setVentas(int ventasFacturadas) {
        VentasFacturadas = ventasFacturadas;
    }
    public int getCantidadTicketsVendidos() {
        return CantidadTicketsVendidos;
    }
    public void setCantidadTicketsVendidos(int ventas) {
        CantidadTicketsVendidos = ventas;
    }
    //Fin getters and setters =================================================================================================================
    
    
    public String CompraTicket(Localidad TipoTicket, int cantidadTickets, int TicketsVendidos, int ticketsCliente){
        Ticket[] TicketsComprados = new Ticket[7];
        String variable_inutil = "";
        if(cantidadTickets<=6&& 0<cantidadTickets&& ticketsCliente<7){
            for (int i = 0; i <6&&i<cantidadTickets; i++) {
                TicketsComprados[i] = new Ticket(TipoTicket, TicketsVendidos+i+1);
                variable_inutil= variable_inutil+ TicketsComprados[i].NumeroTicket()+"\n";
            }
            return variable_inutil;
        }
        else{
            if(7<cantidadTickets){
                return "No puede comprar más de 6 tickets.";
            }
            else{
                return "Dude, el número de tickets debe ser mayor a 0";
            }
            }
        }

    public int VentasdeTickets(int cantidadTickets){
        int ventasTicket = 0;
        if(cantidadTickets<=6&&0<cantidadTickets){
            for(int ii=0; ii<cantidadTickets;ii++){
                ventasTicket = ventasTicket+1;
            }
            return this.CantidadTicketsVendidos + ventasTicket;
        }
        else{
            return 0;
        }
    }

}
    
