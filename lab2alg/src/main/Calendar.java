package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Calendar {
    private List<Tuple> hours = new ArrayList<>();
    private List<Tuple> result = new ArrayList<>();


    public void doMagic() {

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

    public void sortHours() {
        sortByKey();
        sortByValue();

    }


    public void sortByKey() {
        int n = hours.size();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (hours.get(j - 1).key > hours.get(j).key) {
                    Collections.swap(hours, j - 1, j);
                }


            }
        }

    }

    public void sortByValue() {
        int n = hours.size();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (hours.get(j - 1).key == hours.get(j).key
                        && hours.get(j - 1).value > hours.get(j).value) {
                    Collections.swap(hours, j - 1, j);
                }


            }
        }

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


    public List<Tuple> getResult() {
        return result;
    }

    public void setResult(List<Tuple> result) {
        this.result = result;
    }
}
