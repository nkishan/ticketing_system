import java.util.HashMap;

public class TicketingSystem {
    private HashMap<Pnr, Berth> booked = new HashMap<Pnr, Berth>();
    private HashMap<String,Train> trainMap=new HashMap<>();

    public void addTrain(String name, String src, String dest) {
        Train add=new Train(name,src,dest,12,72);
        trainMap.put(name,add);
    }

    public void addTrain(String name, String src, String dest, int numCoaches) {
        Train add=new Train(name,src,dest,numCoaches,72);
        trainMap.put(name,add);
    }

    public void addTrain(String name, String src, String dest, int numCoaches, int numBerth) {
        Train add=new Train(name,src,dest,numCoaches,numBerth);
        trainMap.put(name,add);
    }

    public boolean modifyTicket(Pnr passPnr, Passenger newPassenger) {
        if (booked.containsKey(passPnr)) {
            Berth modifyBerth = booked.get(passPnr);
            modifyBerth.modifyPassenger(newPassenger);
            return true;
        }
        return false;
    }
    public boolean getPnrDetails(Integer pnrNumber){
        Pnr PnrDetails = new Pnr();
        PnrDetails.setPnrNumber(pnrNumber);
        if(booked.containsKey(PnrDetails)){
//            System.out.println("PNR Number: "+PnrDetails.getPnrNumber());
            booked.get(PnrDetails).berthDetails();
            return true;
        }
//        System.out.println("Incorrect PNR");
        return false;
    }


    public boolean getPnrDetails(Pnr PnrDetails){
        if(booked.containsKey(PnrDetails)){
            System.out.println("PNR Number: "+PnrDetails.getPnrNumber());
            booked.get(PnrDetails).berthDetails();
            return true;
        }
        else {
            System.out.println("Incorrect PNR");
        }
        return false;
    }

    public Pnr bookTicket(String trainName,Passenger info){
        if(trainMap.containsKey(trainName)){
            Train toBook=trainMap.get(trainName);
            Berth a=toBook.bookTicket(info);
            if(a==null){
                System.out.println("No Tickets available");
                return null;
            }
            Pnr newPnr=new Pnr();
            while(booked.containsKey(newPnr)){
                newPnr.generatePnr();
            }
            booked.put(newPnr, a);
//            System.out.println("Booked!");
//            getPnrDetails(newPnr);
            return newPnr;
        }
        else {
            System.out.println("No such train");
        }
        return null;
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


}