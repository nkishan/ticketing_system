public class testTicketingSystem {
    public static void main(String[] args) {
        TicketingSystem sys=new TicketingSystem();
        sys.addTrain("Shatabadi","Pune","Mumbai",1,2);
        Passenger info= new Passenger("Kishan", "Male", 21, "Upper");
        Pnr a=sys.bookTicket("Shatabadi",info);
        if(a==null){
            System.out.println("Error in book Ticket");
        }
        Passenger info1= new Passenger("Sneha", "Female", 25, "Upper");
        sys.modifyTicket(a,info1);
        sys.getPnrDetails(a);
        sys.cancelTicket(a);
        sys.getPnrDetails(a);
    }
}
