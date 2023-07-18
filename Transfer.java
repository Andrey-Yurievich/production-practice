import java.util.*;
public class Transfer{
    public static List <Result> StringsToResults(List <String> lines){
        if (lines == null || lines.isEmpty ()) return null;
        List <Result> results = new ArrayList <Result> ();
        for (int i = 0; i < lines.size(); i++){
            String [ ] words = lines.get(i).split(",");
            if (words.length != 4) return null;
            Result s = new Result();
            s.setFirm(words[1].trim());
            s.setAddress(words[2].trim());
            try{
                s.setNumber(Integer.parseInt(words[0].trim()));
                s.setSquare(Integer.parseInt(words[3].trim()));
            }catch (NumberFormatException e){ return null;}
            results.add(s);}
        return results;}
    public static List <String> ResultsToString (List <Result> results){
        if (results == null || results.isEmpty ()) return null;
        List <String> lines = new ArrayList <String> ();
        for (int i = 0; i< results.size(); i++)
            lines.add(String.format("%5d, %10s, %10s, %5d", results.get(i).getNumber(), results.get(i).getFirm(), results.get(i).getAddress(), results.get(i).getSquare()));
        return lines;}}