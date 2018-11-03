import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PerfumeManager {
    private List<Perfume> perfumes = new ArrayList<Perfume>();

    public List<Perfume> getPerfumesFromList(String file) {
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {

                String readedString = scan.nextLine();
                String[] perfumeInfo = readedString.split(",");

                String name = perfumeInfo[0];
                double volume = Double.parseDouble(perfumeInfo[1]);
                int price = Integer.parseInt(perfumeInfo[2]);

                perfumes.add(new Perfume(name, volume, price));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {

            System.out.println("FileNotFound");
        } catch (IOException e) {

            e.printStackTrace();
        }

        return perfumes;

    }

    public void printPerfumesList() {
        for (int i = 0; i < perfumes.size(); i++) {
            System.out.println(perfumes.get(i).toString());

        }

    }

    public List<Perfume> insertSortByVolumeDec() {

        long timeOfWork = 0;
        int numberOfComparison = 0;
        int numberOfExchange = 0;
        System.out.println("\n\nInsertion Sort:");
        Perfume[] perfumeArray = new Perfume[perfumes.size()];
        perfumeArray = perfumes.toArray(perfumeArray);
        long startTime = System.nanoTime();
        for (int i = 1; i < perfumeArray.length; i++) {
            Perfume key = perfumeArray[i];
            int j = i - 1;

            while (j >= 0 && perfumeArray[j].getVolume() > key.getVolume()) {
                perfumeArray[j + 1] = perfumeArray[j];
                j = j - 1;
                numberOfComparison += 1;


            }
            perfumeArray[j + 1] = key;
            numberOfExchange += 1;

        }

        timeOfWork = System.nanoTime() - startTime;

        System.out.println("Number of exchanges:" + numberOfExchange);
        System.out.println("Number of comparison operations:" + numberOfComparison);
        System.out.println("Work time:" + timeOfWork + " nanoseconds");
        System.out.println("Result:");

        perfumes = Arrays.asList(perfumeArray);
        for (Perfume perfume : perfumes) {
            System.out.println(perfume.toString());

        }
        System.out.println("\n\n");
        return perfumes;
    }


    public void mergeSortPrice() {
        MergeSort ms = new MergeSort();
        System.out.println("Merge sort:");
        for (Perfume per : ms.mergeSort(perfumes)) {
            System.out.println(per.toString());
        }


        System.out.println("Number of exchanges:" + ms.numberOfExchange);
        System.out.println("Number of comparison operations:" + ms.numberOfComparison);
        System.out.println("Work time:" + ms.timeOfWork + " nanoseconds");

    }
}
