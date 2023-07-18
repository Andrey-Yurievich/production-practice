public class Result implements Comparable <Result>{
    private final static String SCHEDULE_FORMAT_STRING = "%5d | %10s | %10s | %5d";
    private int number, square;
    private String address, firm;
    public Result(){
        number=0;
        firm ="";
        address = "";
        square =0;}
    public Result(int number, String firm, String address, int square){
        this.number = number;
        this.firm = firm;
        this.address = address;
        this.square = square;}
    public Result(Result ob){
        number = ob.number;
        firm = ob.firm;
        address = ob.address;
        square = ob.square;}
    public int getNumber() {return number;}
    public String getFirm() {return firm;}
    public String getAddress() {return address;}
    public int getSquare() {return square;}
    public void setNumber(int number){this.number=number;}
    public void setFirm(String firm){this.firm = firm;}
    public void setAddress(String address){this.address = address;}
    public void setSquare(int square){this.square = square;}
    public String toString(){return String.format(SCHEDULE_FORMAT_STRING, number, firm, address, square);}
    public int compareTo(Result s){
        if (number < s.number) return -1;
        if (number > s.number) return 1;
        return 0;}
    @Override
    public boolean equals (Object ob){
        if (ob==this) return true;
        if (ob==null) return false;
        if (getClass()!=ob.getClass())return false;
        Result s=(Result)ob;
        return (number == s.number);}
    public int hashCode(){
        return 7*(new Integer(number)).hashCode()+
                13* firm.hashCode()+
                17* address.hashCode()+
                19*(new Integer(square)).hashCode();}}