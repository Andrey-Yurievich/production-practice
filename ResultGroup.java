import java.util.*;
public class ResultGroup{
    private final static String GROUP_FORMAT_STRING = "График записей &-s, %-5d строк";
    String name;
    private List <Result> results;
    public ResultGroup(){
        name = " ";
        results = new ArrayList <Result>();}
    public ResultGroup(String name){
        this.name = name;
        results = new ArrayList<Result>();}
    public ResultGroup(String name, List list){
        this.name = name;
        results = new ArrayList<Result>(list);}
    public List <Result> getSchedules(){
        return results;}
    public List <TotalRecord> totalSumFirm(){
        int n = results.size();
        if (n == 0) return null;
        List <Result> schedulesClone = new ArrayList <Result>();
        schedulesClone.addAll(results);
        Set <String> firmS = new TreeSet();
        for (Result s: results)
            firmS.add(s.getFirm());
        List <String> firmL = new ArrayList(firmS);
        int m = firmL.size();
        String firm;
        int sum;
        int temp = 0;
        List <TotalRecord> totRecList = new ArrayList <TotalRecord>();
        for (int i=0; i<m; i++){
            firm = firmL.get(i); sum=0;
            Iterator <Result> iter = schedulesClone.iterator();
            while (iter.hasNext()){
                temp = temp+1;
                Result s = iter.next();
                if (firm.equals(s.getFirm())) {
                    sum = sum + s.getSquare();
                    iter.remove();}}
            totRecList.add(new TotalRecord(firm, sum));}
        System.out.println("Число повторений цикла:" + temp);
        return totRecList;}
    public int generalMaxSquare(){
        int num= results.size();
        if (num==0) return 0;
        int max=0;
        for (Result s: results){
            if (s.getSquare() > max)
                max = s.getSquare();}
        return max;}
    public int sizeOfList (){
        int num = results.size();
        return num;}
    public ResultGroup sort(){
        ResultGroup sg = new ResultGroup(name, results);
        Collections.sort(sg.results);
        return sg;}
    public ResultGroup sort(Comparator comp){
        ResultGroup sg = new ResultGroup(name, results);
        Collections.sort(sg.results, comp);
        return sg;}
    public ResultGroup filterForCipher(String words){
        ResultGroup sg = new ResultGroup(name);
        Iterator <Result> iter = results.iterator();
        while (iter.hasNext()){
            Result s = iter.next();
            if (s.getFirm().startsWith(words)) sg.addSchedule(s);}
        return sg;}
    public boolean delSchedule(Result s){
        if (results.remove(s)) return true;
        else return false;}
    public Result getSchedule (Result s){
        for (Result sc : results)
            if (sc.equals(s)) return sc;
        return null;}
    public boolean addSchedule(Result s){
        if (getSchedule(s)!=null)
            return false;
        if (results.add(s)) return true;
        else return false;}
    public boolean updateSchedule(Result s){
        Result sc = getSchedule(s);
        if (sc!=null) {sc.setSquare(s.getSquare()); return true;}
        return false;}
    public boolean deleteScheduleGroup(String g1){
        return results.removeAll(findABC(g1).results);}
    public ResultGroup findABC(String g1){
        ResultGroup group = new ResultGroup(name+": результаты, в которых есть - "+g1);
        for (Result s: results) {
            if (s.getAddress().contains(g1))
                group.addSchedule(s);}
        return group;}
    public ResultGroup aboveAvgTime(){
        float avg=avgTime();
        ResultGroup group = new ResultGroup(name+
                ": результаты, в которых время выше среднего - " + avg);
        for (Result s : results)
            if (s.getSquare()>avg)
                group.addSchedule(s);
        return group;}
    public ResultGroup aboveGivenTime(int g1){
        ResultGroup group = new ResultGroup(name+
                ": результаты, в которых время выше заданного");
        for (Result s : results)
            if (s.getSquare()>g1)
                group.addSchedule(s);
        return group;}
    public float avgTime(){
        int num= results.size();
        if (num==0) return 0;
        float avg=0;
        for (Result s: results)
            avg=avg+s.getSquare();
        return avg/num;}
    public ResultGroup betweenTime(int g1, int g2){
        ResultGroup sg = new ResultGroup(
                String.format("%s: записи, у которых кол-во часов в диапазоне от %5d до %5d", name,g1,g2));
        Iterator <Result> iter= results.iterator();
        while (iter.hasNext()){
            Result s=iter.next();
            if ((s.getSquare()>=g1)&&(s.getSquare()<=g2)) sg.addSchedule(s);}
        return sg;}
    public void putListOfSchedules(){
        System.out.println(name);
        System.out.printf("%6s%13s%14s%18s%41s%27s\n", "Номер", "Номер преподавателя", "Дисциплина", "Вид занятий", "Кол-во часов");
        int i = 1;
        for (Result s : results) {
            System.out.printf(" %-7d %-15d %-15s %-15s %-7d\n", i, s.getNumber(), s.getFirm(), s.getAddress(),
                    s.getSquare());
            i = i + 1;}}
    public String toString(){
        return String.format(GROUP_FORMAT_STRING, name, sizeOfList());}}