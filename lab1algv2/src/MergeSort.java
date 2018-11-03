import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    static long timeOfWork = 0;
    static int numberOfComparison = 0;
    static int numberOfExchange = 0;
    static long startTime = System.nanoTime();

    public static List<Perfume> mergeSort(List<Perfume> perfumes) {
        if (perfumes.size() <= 1) {
            return perfumes;
        }


        List<Perfume> left = new ArrayList<>();
        List<Perfume> right = new ArrayList<>();
        int middle = perfumes.size() / 2;
        //Splits the array into unsortedList size lists of size one
        for (int i = 0; i < perfumes.size(); i++) {
            if (i < middle) {
                left.add(perfumes.get(i));
            } else {
                right.add(perfumes.get(i));
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    static List<Perfume> merge(List<Perfume> left, List<Perfume> right) {
        List<Perfume> mergedList = new ArrayList<>();

        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                numberOfComparison += 1;
                if (left.get(0).getPrice() < right.get(0).getPrice()) {
                    mergedList.add(left.get(0));
                    left.remove(0);
                    numberOfExchange += 1;
                } else {
                    mergedList.add(right.get(0));
                    right.remove(0);
                    numberOfExchange += 1;
                }
            } else if (left.size() > 0) {
                mergedList.add(left.get(0));
                left.remove(0);
                numberOfExchange += 1;
            } else if (right.size() > 0) {
                mergedList.add(right.get(0));
                right.remove(0);
                numberOfExchange += 1;
            }
        }

        timeOfWork = System.nanoTime() - startTime;
        return mergedList;
    }


}