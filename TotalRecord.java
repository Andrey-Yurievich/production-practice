public class TotalRecord{
    String totalDay;
    int totalTime;
    TotalRecord(String totalDay,int totalTime){
        this.totalDay = totalDay;
        this.totalTime = totalTime;}
    public String returnString(){
        return String.format("%15s, %5d", totalDay, totalTime);}}