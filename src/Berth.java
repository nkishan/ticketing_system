public class Berth {
    private boolean isBooked = false;
    private Passenger passengerDetails = null;
    public final int berthNumber;
    public final int coachNumber;
    public String trainName;
    private String type;

    public Berth(int berthNum,int coachNum,String train) {
        berthNumber = berthNum;
        coachNumber=coachNum;
        trainName=train;
        int remainder = berthNumber % 8;
        if (remainder == 1 || remainder == 4 || remainder == 7) {
            type = "Lower";
        } else if (remainder == 2 || remainder == 5) {
            type = "Middle";
        } else if (remainder == 3 || remainder == 6 || remainder == 0) {
            type = "Upper";
        }
    }

    public boolean bookBerth(Passenger info) {
        if (isBooked) {
            return false;
        }
        passengerDetails = info;
        isBooked = true;
        return true;
    }

    public boolean isAvailable(Passenger input) {
        String preference = input.getPreference();
        if (preference == null) {
            return !isBooked;
        } else {
            return preference.equals(type) && !isBooked;
        }

    }

    public void cancel() {
        isBooked = false;
        passengerDetails = null;

    }
    public void berthDetails(){
        System.out.println("Coach: "+coachNumber);
        System.out.println("Berth: "+ berthNumber);
        passengerDetails.printDetails();
    }

    public Passenger getPassengerDetails() {
        return passengerDetails;
    }

    public void modifyPassenger(Passenger newPass){
        passengerDetails=newPass;
    }

}
