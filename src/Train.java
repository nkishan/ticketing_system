import java.util.ArrayList;
import java.util.HashMap;

public class Train {
    private String trainName;
    private String source;
    private String destination;
    private int numCoach = 12;

    private int numBerths = 72;
    //    private int Pnr = 1;
    ArrayList<Coach> coachList = new ArrayList<Coach>();


    public Train(String name, String src, String dest, int numCoaches, int numBerth) {
        trainName = name;
        source = src;
        destination = dest;
        numCoach = numCoaches;
        numBerths=numBerth;
        for (int i = 0; i < numCoach; i++) {
            coachList.add(new Coach(trainName,i + 1, numBerths));
        }
    }

    public Berth bookTicket(Passenger info) {
        for (Coach i : coachList) {
            Berth a = i.bookBerth(info);
            if (a == null) {
                continue;
            }
//
            return a;
        }
        return null;
    }


//
//    public boolean modifyTicket(Pnr passPnr, Passenger newPassenger) {
//        if (booked.containsKey(passPnr)) {
//            Berth modifyBerth = booked.get(passPnr);
//            modifyBerth.modifyPassenger(newPassenger);
//            return true;
//        }
//        return false;
//    }
//
//    public void getPnrDetails(Pnr PnrDetails){
//        if(booked.containsKey(PnrDetails)){
//            System.out.println("PNR Number: "+PnrDetails.getPnrNumber());
//            System.out.println("Train: "+trainName);
//            booked.get(PnrDetails).berthDetails();
////            booked.get(PnrDetails).getPassengerDetails();
//        }
//        else {
//            System.out.println("Incorrect PNR");
//        }
////        return null;
//    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public String getTrainName() {
        return trainName;
    }

//    public int ticketAvailability(){
//        return numCoach*numBerths-booked.size();
//    }

}
