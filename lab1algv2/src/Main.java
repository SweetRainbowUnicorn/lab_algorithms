public class Main {
    public static void main(String[] args) {
        PerfumeManager sortManager = new PerfumeManager();
        sortManager.getPerfumesFromList("C:\\Users\\User\\IdeaProjects\\lab1algv2\\src\\perfume.txt");
        sortManager.printPerfumesList();
        sortManager.insertSortByVolumeDec();
        sortManager.mergeSortPrice();
    }

}
