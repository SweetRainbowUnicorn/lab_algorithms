package main;

import java.util.*;

public class Calendar {
    HourComparator comparator = new HourComparator();
    private List<Tuple> hours = new ArrayList<Tuple>();



    public void joinHours() {

        for (int i = 0; i < hours.size() - 1; i++) {
            if (hours.get(i + 1).key <= hours.get(i).value) {
                if (hours.get(i + 1).value <= hours.get(i).value) {
                    hours.remove(i + 1);
                    i--;
                } else {
                    hours.get(i).value = hours.get(i + 1).value;
                    hours.remove(i + 1);
                    i--;
                }
            }
        }
    }


    public List<Tuple> sortHours(){
        hours.sort(comparator);
        return hours;
    }


    public void printHours(List<Tuple> hoursToPrint) {
        for (Tuple tuple : hoursToPrint) {
            System.out.print(tuple.toString() + " ");
        }
    }

    public void addHours(Tuple tuple) {
        hours.add(tuple);
    }


    public List<Tuple> getHours() {
        return hours;
    }

    public void setHours(List<Tuple> hours) {
        this.hours = hours;
    }

}
