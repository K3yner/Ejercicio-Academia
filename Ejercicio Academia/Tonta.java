import  java.util.Scanner;
public class Tonta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Configuración de parametros de la clase Lugar ===============================================
        System.out.println("Bienvenido, este programa le fácilita las ventas de ticktes");
        System.out.println("¿Cómo se llama el lugar donde se celebrará el acto?");
        String nombre = sc.nextLine();
        
        System.out.println("¿Qué cantidad de asientos de Balcón 1 tiene el lugar?");
        int balcon1 = sc.nextInt();
        
        System.out.println("¿Qué cantidad de asientos de Platea tiene el lugar?");
        int platea = sc.nextInt();

        System.out.println("¿Qué cantidad de asientos de Balcón 2 tiene el lugar?");
        int balcon2 = sc.nextInt();

        // Creación del Objeto de clase Lugar (controlador) ===============================================
        Lugar Academia = new Lugar(nombre, balcon1, platea, balcon2);
        Comprador Cliente = new Comprador("", "", 0);

        // Menú del programa ==============================================================================================
        boolean n = true;
        while(n == true){
            System.out.println("¿Qué quiere hacer? \n"+
            "1. Ingresar nuevo comprador \n"+
            "2. Comprar Tickets \n"+
            "3. Consultar disponibilidad de tickets \n" + 
            "4. Consultar la disponibilidad de una localidad \n"+
            "5. Reporte de caja \n"+
            "6. Cerrar el programa \n"+
            "Ingrese el número de la opción que desea:  "
            );
            int menuOpcion = sc.nextInt();
            sc.nextLine();
            switch (menuOpcion) {
                case 1:
                    //Nuevo comprador==============================================================================================
                    System.out.println("Ingrese el nombre del comprador");
                    String nombreComprador = sc.nextLine();
                    Cliente.setNombreComprador(nombreComprador);
                    
                    System.out.println("Ingrese el mail del comprador");
                    String mailComprador = sc.nextLine();
                    Cliente.setMail(mailComprador);

                    System.out.println("Ingrese su presupuesto: ");
                    float presupuesto = sc.nextFloat(); // Presupuesto del comprador usado para verificar que pueda permitirse comprar la cantidad de ticktes que desea
                    sc.nextLine();
                    Cliente.setPresupuestoMax(presupuesto);
                    break;
                // Fin del ingreso de un nuevo comprador ==============================================================================================
                case 2:// Compra de ticktes==============================================================================================
                    // Si se intenta comprar un ticket sin agregar los datos del comprador
                    if(Cliente.getNombreComprador().equals("")){ 
                        System.out.println("No ha ingresado todos los datos del comprador, asegurese de agregarlos correctamente.");
                        System.out.println("Ingrese el nombre del comprador");
                        String nombreComprador2 = sc.nextLine();
                        Cliente.setNombreComprador(nombreComprador2);
                        
                        System.out.println("Ingrese el mail del comprador");
                        String mailComprador2 = sc.nextLine();
                        Cliente.setMail(mailComprador2);

                        System.out.println("Ingrese su presupuesto: ");
                        float presupuesto2 = sc.nextFloat(); // Presupuesto del comprador usado para verificar que pueda permitirse comprar la cantidad de ticktes que desea
                        sc.nextLine();
                        Cliente.setPresupuestoMax(presupuesto2);
                    }else{
                        // Se pregunta que tipo de ticket se quiere comprar
                        System.out.println("¿Qué tipo de Ticket quiere comprar?\n1. Balcón 1 (Q 1800.00)" +
                        "\n2. Platea (Q 600.00) \n3. Balcón 2 (Q 300.00)");
                        int tipoEntrada = sc.nextInt(); // Tipo de entrada que desea el comprador
                        sc.nextLine();
                        
                        System.out.println("¿Cuántos tickets quiere comprar?: ");
                        int cantTicket = sc.nextInt(); //Cantidad de tickets del comprador
                        sc.nextLine();
                        
                        // Generando tickets 
                        switch (tipoEntrada) {
                            case 1:
                                if((1800*cantTicket)<=Cliente.getPresupuestoMax()){ // comprobando si el presupuesto es suficiente
                                    //Comprobando si hay asientos disponibles
                                    if(Academia.getBalcon1().getCantidadAsientos()== Academia.getBalcon1().getAsientosOcupados()){
                                        System.out.println("Ya no hay asientos disponibles en el Balcón 1");
                                    }else{
                                        if(Academia.getBalcon1().getAsientosOcupados()<Academia.getBalcon1().getCantidadAsientos()){
                                        //generando el número del ticket. 
                                        String a =Academia.CompraTicket(Academia.getBalcon1(), cantTicket, Academia.getCantidadTicketsVendidos(), Cliente.getCantTickets());
                                        Academia.setCantidadTicketsVendidos(Academia.VentasdeTickets(cantTicket));
                                        System.out.print(a);
                                        Cliente.AsignacionTickets(cantTicket); //Se asigna la cantidad de ticktes que tiene el comprador
                                        Academia.getBalcon1().AgregarAsientosOcupados(cantTicket); // se contabiliza la cantidad de asientos ocupados
                                        Cliente.setPresupuestoMax(Cliente.getPresupuestoMax()-(cantTicket*1800)); // Se resta el dinero gastado al presupuesto.
                                        }else{
                                            System.out.println("Ya no hay espacios disponibles."); // en caso de que no haya asientos.
                                        }
                                    }
                                }else{
                                    // en caso de que el presupuesto no sea suficiente.
                                    System.out.println( "Tu presupuesto no es suficiente para comprar esa cantidad de ticktes."); 
                                }
                                break;
                            case 2:
                                if((600*cantTicket)<=Cliente.getPresupuestoMax()){ //Caso de ticktes de platea
                                    // Comprobación de tickets disponibles.
                                    if(Academia.getPlatea().getCantidadAsientos()== Academia.getPlatea().getAsientosOcupados()){
                                        //En caso de que no haya asientos disponibles.
                                        System.out.println("Ya no hay asientos disponibles en Platea");
                                    }else{
                                        if(Academia.getPlatea().getAsientosOcupados()<Academia.getPlatea().getCantidadAsientos()){
                                            //Asignación de numero de ticket
                                            String a =Academia.CompraTicket(Academia.getPlatea(), cantTicket, Academia.getCantidadTicketsVendidos(), Cliente.getCantTickets());
                                            Academia.setCantidadTicketsVendidos(Academia.VentasdeTickets(cantTicket));
                                            System.out.print(a);
                                            Cliente.AsignacionTickets(cantTicket); //Asignación de cantidad de tickets que tiene el comprados
                                            Academia.getPlatea().AgregarAsientosOcupados(cantTicket); /*  Se contabiliza los asientos de platea que
                                             están ocupados*/ 
                                             Cliente.setPresupuestoMax(Cliente.getPresupuestoMax()-(cantTicket*600)); // se resta el dinero gastado al presupuesto
                                        }else{
                                            System.out.println("Ya no hay asientos disponibles."); // en caso de no haber asientos.
                                        }
                                        }
                                }else{
                                    // Si el presupuesto no permite comprar los tickets.
                                    System.out.println( "Tu presupuesto no es suficiente para comprar esa cantidad de ticktes.");
                                }
                                break;
                            case 3:
                                if((300.00*cantTicket)<=Cliente.getPresupuestoMax()){ // caso ticket balcón 2
                                    //comprobación de disponibilidad de asientos.
                                    if(Academia.getBalcon2().getCantidadAsientos()== Academia.getBalcon1().getAsientosOcupados()){
                                        //de no haber asientos.
                                        System.out.println("Ya no hay asientos disponibles en el Balcón 2");
                                    }else{
                                        if(Academia.getBalcon2().getAsientosOcupados()<Academia.getBalcon1().getCantidadAsientos()){
                                            // de haber asientos disponibles. Asignación del número de ticket
                                            String a =Academia.CompraTicket(Academia.getBalcon2(), cantTicket, Academia.getCantidadTicketsVendidos(), Cliente.getCantTickets());
                                            Academia.setCantidadTicketsVendidos(Academia.VentasdeTickets(cantTicket));
                                            System.out.print(a);
                                            Cliente.AsignacionTickets(cantTicket); //asignación de cantidad de tickets del comprador
                                            Academia.getBalcon2().AgregarAsientosOcupados(cantTicket); // se contabilizan los asientos ocupados del balcón 2.
                                            Cliente.setPresupuestoMax(Cliente.getPresupuestoMax()-(cantTicket*300)); // se resta el dinero gastado al presupuesto.
                                        }else{
                                            System.out.println("Ya no hay asientos disponibles."); // en caso de no haber asientos.
                                        }
                                        }
                                }else{
                                    //en caso del que el presupuesto no permita la compra de los tickets.
                                    System.out.println( "Tu presupuesto no es suficiente para comprar esa cantidad de ticktes.");
                                }
                                break;
                        
                            default:
                                System.out.println("");
                                break;
                        }
                        }
                    break;
                    // Fin del compra de ticktes ================================================================================================================================
                case 3:// Consultar disponibilidad general de tickets==============================================================================================
                    int AsientosDelLugar = Academia.getBalcon1().getCantidadAsientos()+Academia.getPlatea().getCantidadAsientos()+Academia.getBalcon2().getCantidadAsientos();
                    int AsientosYaOcupados = Academia.getBalcon1().getAsientosOcupados()+Academia.getPlatea().getAsientosOcupados()+Academia.getBalcon2().getAsientosOcupados();
                    int comprobante = AsientosDelLugar- AsientosYaOcupados;
                    if(0<comprobante){
                        System.out.println("Quedan "+comprobante+" asientos disponibles.");
                    }else{
                        if(comprobante==0){
                            System.out.println("Ya no hay asientos disponibles en ningún sitio.");
                        }else{
                            if(comprobante<0){
                                System.out.println("");
                            }
                        }
                    }
                    break;
                    // Fin de consulta de disponibilidad de asientos en general ====================================================================================
                case 4:// Disponibilidad de una localidad específica==============================================================================================
                    //Se pregunta de que lugar se quiere comprobar
                    System.out.println("¿De qué lugar desea comprobar la disponibilidad? \n1. Balcón 1 \n2. Platea \n3. Balcón 2"+
                    "\nIngrese el número de la opción que desee:  ");
                    int opcionDisponibilidad = sc.nextInt();
                    switch (opcionDisponibilidad) {//división de comprobación por localidad
                        case 1://En caso de balcón 1
                            //Se determina la cantidad de asientos disponibles y se guarda en una variable
                            int comprobanteBalcon1 = Academia.getBalcon1().getCantidadAsientos()-Academia.getBalcon1().getAsientosOcupados();
                            if(0<comprobanteBalcon1){//en caso de haber asientos disponibles
                                System.out.println("Hay "+ comprobanteBalcon1+ " asientos disponibles en el Balcón 1");
                            }else{
                                //En caso de no haber asientos disponibles
                                if(comprobanteBalcon1==0){
                                    System.out.println("No hay asientos disponibles en el balcón 1");
                                }else{//Caso que no puede pasar xd
                                    System.out.println("");
                                }
                            }
                            break;
                        case 2://En caso de platea
                            //Se determina la cantidad de asientos disponibles y se guarda en una variable
                            int comprobantePlatea = Academia.getPlatea().getCantidadAsientos()-Academia.getPlatea().getAsientosOcupados();
                            if(0<comprobantePlatea){//en caso de haber asientos disponibles
                                System.out.println("Hay "+ comprobantePlatea+ " asientos disponibles en el Balcón 1");
                            }else{
                                //en caso de no haber
                                if(comprobantePlatea==0){
                                    System.out.println("No hay asientos disponibles en platea");
                                }else{//caso que no puede pasar
                                    System.out.println("");
                                }
                            }
                            break;
                        case 3:// caso balcón 2
                            //Se determina la cantidad de asientos disponibles y se guarda en una variable
                            int comprobanteBalcon2 = Academia.getBalcon2().getCantidadAsientos()-Academia.getBalcon2().getAsientosOcupados();
                            if(0<comprobanteBalcon2){//en caso de haber asientos disponibles
                                System.out.println("Hay "+ comprobanteBalcon2+ " asientos disponibles en el balcón 2");
                            }else{
                                //en caso de no haber
                                if(comprobanteBalcon2==0){
                                    System.out.println("No hay asientos disponibles en el balcón 1");
                                }else{//caso que no puede pasar
                                    System.out.println("");
                                }
                            }
                            break;
                    
                        default:
                            break;
                    }
                    break;
                    //Fin de disponibilidad específica ===================================================================================================================
                case 5:
                    // Reporte de caja===================================================================================================================================================
                    float caja = (Academia.getBalcon1().getAsientosOcupados()*1800)
                    +(Academia.getPlatea().getAsientosOcupados()*600)
                    +(Academia.getBalcon2().getAsientosOcupados()*300);
                    System.out.println("Se ha generado Q "+ caja);
                    break;
                case 6:
                    // Salir del programa==============================================================================================
                    System.out.print("El programa se cerrará, adios.");
                    n = false;
                    break;
                default:
                    // Lo que pasa si ingresan a un número distinto al de las opciones dadas.==============================================================================================
                    System.out.println("La opción escogida no corresponde a ninguna de las opciones mostrardas");
                    break;
            }
        }
        
        
        sc.close();
        }
}

