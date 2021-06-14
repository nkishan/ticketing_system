public class Berth {
    private boolean isBooked = false;
    private Passenger details = null;
    public final int number;
    private String type;

    public Berth(int berthNum) {
        number = berthNum;
        int remainder = number % 8;
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
        details = info;
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
        details = null;

    }
    public void modifyPassenger(Passenger newPass){
        details.modifyDetails(newPass);
    }

}
