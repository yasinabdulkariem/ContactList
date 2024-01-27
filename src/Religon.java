public class Religon extends Person{
    private String religon;

    public Religon(String firstName, String lastName, String phoneNumber, String religon){
        super(firstName, lastName, phoneNumber);
        this.religon = religon;
    }

    public String getReligon() {
        return religon;
    }

    public void setReligon(String religon) {
        this.religon = religon;
    }

    @Override
    public String toString(){
        return super.toString() + " Religon: " + religon;
    }
}
