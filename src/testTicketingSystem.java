import java.util.ArrayList;
import java.util.List;

public class testTicketingSystem {
    public static void main(String[] args) {
        TicketingSystem sys=new TicketingSystem();
        sys.addTrain("Shatabadi","Pune","Mumbai",1000,1000);
        Passenger info= new Passenger("Kishan", "Male", 21, "Upper");
        Pnr a=sys.bookTicket("Shatabadi",info);
        if(a==null){
            System.out.println("Error in book Ticket");
        }
        Passenger info1= new Passenger("Sneha", "Female", 25, "Upper");
        sys.modifyTicket(a,info1);
//        sys.getPnrDetails(a);
        sys.cancelTicket(a);
//        sys.getPnrDetails(a);
        testBooking(sys,"Shatabadi");
    }

    private static void testBooking(TicketingSystem sys, String trainName) {
        int bookings = 10000;
        List<Integer> pnrs = new ArrayList<>();
        for (int i = 0; i  < bookings; i++) {
            Passenger info = new Passenger( "kishan" + i, "Male", 21, "Upper");
            pnrs.add(sys.bookTicket(trainName, info).getPnrNumber());
        }
        for (Integer i : pnrs) {
            if (!sys.getPnrDetails(i)) {
                System.out.println("failed");
            }
        }
    }
}
