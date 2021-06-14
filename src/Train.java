import kotlin.random.URandomKt;

import java.util.ArrayList;
import java.util.HashMap;

public class Train {
    private String trainName;
    private String source;
    private String destination;
    private int numCoach = 12;
    HashMap<Pnr, Berth> booked = new HashMap<Pnr, Berth>();
    private int numBerths = 72;
//    private int Pnr = 1;
    ArrayList<Coach> coachList = new ArrayList<Coach>();

    public Train(String name, String src, String dest) {
        trainName = name;
        source = src;
        destination = dest;
        for (int i = 0; i < numCoach; i++) {
            coachList.add(new Coach(i + 1));
        }
    }

    public Train(String name, String src, String dest, int numCoaches) {
        trainName = name;
        source = src;
        destination = dest;
        numCoach = numCoaches;
        for (int i = 0; i < numCoach; i++) {
            coachList.add(new Coach(i + 1));
        }
    }

    public Train(String name, String src, String dest, int numCoaches, int numBerths) {
        trainName = name;
        source = src;
        destination = dest;
        numCoach = numCoaches;
        for (int i = 0; i < numCoach; i++) {
            coachList.add(new Coach(i + 1, numBerths));
        }
    }

    public boolean bookTicket(Passenger info) {
        for (Coach i : coachList) {
            Berth a = i.bookBerth(info);
            if (a == null) {
                continue;
            }
            Pnr newPnr=new Pnr();
            while(booked.containsKey(newPnr.getPnrNumber())){
                newPnr.generatePnr();
            }
            booked.put(newPnr, a);
//            Pnr++;
            return true;
        }
        return false;
    }

    public boolean cancelTicket(Pnr passPnr) {
        if (booked.containsKey(passPnr)) {
            Berth cancelBerth = booked.get(passPnr);
            cancelBerth.cancel();
            booked.remove(passPnr);
            return true;
        }
        return false;
    }

    public boolean modifyTicket(Pnr passPnr, Passenger newPassenger) {
        if (booked.containsKey(passPnr)) {
            Berth modifyBerth = booked.get(passPnr);
            modifyBerth.modifyPassenger(newPassenger);
            return true;
        }
        return false;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public String getTrainName() {
        return trainName;
    }

    public int ticketAvailability(){
        return numCoach*numBerths-booked.size();
    }

}
