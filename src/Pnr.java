public class Pnr {
    private int pnrNumber;
    public Pnr(){
        pnrNumber=(int)Math.random()*100000000;
    }

    public int getPnrNumber() {
        return pnrNumber;
    }
    public void generatePnr(){
        pnrNumber=(int)Math.random()*100000000;
    }
}
