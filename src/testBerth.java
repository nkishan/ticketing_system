public class testBerth {
    public static void main(String[] args ){
        Berth test=new Berth(1,2,"dhje");
        Passenger info=new Passenger("Kishan","Male",21,"Lower");
        if(test.isAvailable(info)){
            if(test.bookBerth(info)){
                System.out.println("Booked");
            }
            if(!test.bookBerth(info)){
                System.out.println("Already booked");
            }
        }
        else{
            System.out.println("Unavailable");
        }
    }
}
