import java.util.HashMap;

public class Pnr {
    private int pnrNumber;
    HashMap<Pnr, Berth> booked = new HashMap<Pnr, Berth>();
    public Pnr(){
        pnrNumber=(int)(Math.random()*1000000000);
//        System.out.println(this.hashCode());
    }

    public int getPnrNumber() {
        return pnrNumber;
    }
    public void generatePnr(){
        pnrNumber=(int)(Math.random()*1000000000);
    }
    public boolean equals(Pnr compare){
        return this.pnrNumber== compare.getPnrNumber();
    }

    public void setPnrNumber(int pnrNumber) {
        this.pnrNumber = pnrNumber;
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

    public void getPnrDetails(Pnr PnrDetails){
        if(booked.containsKey(PnrDetails)){
            System.out.println("PNR Number: "+PnrDetails.getPnrNumber());
//            System.out.println("Train: "+trainName);
            booked.get(PnrDetails).berthDetails();
//            booked.get(PnrDetails).getPassengerDetails();
        }
        else {
            System.out.println("Incorrect PNR");
        }
//        return null;
    }
    //    public boolean equals()
}
