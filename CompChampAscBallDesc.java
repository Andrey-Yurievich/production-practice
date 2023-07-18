import java.util.*;
public class CompChampAscBallDesc implements Comparator{
    public int compare (Object ob1, Object ob2){
        Result s1 = (Result) ob1;
        Result s2 = (Result) ob2;
        if (s1.getFirm().compareTo(s2.getFirm()) < 0) return -1;
        else if (s1.getFirm().compareTo(s2.getFirm()) > 0) return 1;
        else if (s1.getSquare() < s2.getSquare()) return 1;
        else if (s1.getSquare() > s2.getSquare()) return -1;
        else return 0;}}