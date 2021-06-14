public class testCoach {
    public static void main(String[] args) {
        Coach test=new Coach(1,2);
        Passenger info=new Passenger("Kishan","Male",21,"Lower");

        if(test.bookBerth(info)!=null){
            System.out.println("Booked");
        }
        if(test.bookBerth(info)==null){
            System.out.println("Already booked");
        }

    }
}
