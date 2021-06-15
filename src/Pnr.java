import java.util.HashMap;

public class Pnr {
    private Integer pnrNumber;
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
        return pnrNumber==compare.getPnrNumber();
    }

    public boolean equals(Object comparison){
        Pnr compare=(Pnr) comparison;
        return this.pnrNumber== compare.getPnrNumber();
    }

    public int hashCode(){
        return pnrNumber.hashCode();
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
