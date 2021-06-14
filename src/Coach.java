import java.util.ArrayList;

public class Coach {

    private int number;
    private int berths = 72;
    ArrayList<Berth> BerthList = new ArrayList<Berth>();

    public Coach(String train,int coachNumber) {
        number = coachNumber;
        for (int i = 0; i < berths; i++) {
            BerthList.add(new Berth(i + 1,coachNumber,train));
        }
    }
    public Coach(String train,int coachNumber,int berthNumber) {
        number = coachNumber;
        berths=berthNumber;
        for (int i = 0; i < berths; i++) {
            BerthList.add(new Berth(i + 1,coachNumber,train));
        }
    }
    public Berth bookBerth(Passenger info){
        String passPreference=info.getPreference();
        for(Berth i : BerthList){
            if(i.isAvailable(info)){
                // Add lock for concurrency
                if(i.bookBerth(info)){
                    return i;
                }
            }
        }
        if(passPreference!=null){
            info.setPreference(null);
            for(Berth i : BerthList){
                if(i.isAvailable(info)){
                    // Add lock for concurrency
                    if(i.bookBerth(info)){
                        return i;
                    }
                }
            }
        }
        return null;
    }





}
