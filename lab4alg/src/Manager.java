import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Manager {
    public String url;
    private Map<Integer, Coordinates> positions = new HashMap<Integer, Coordinates>();

    public void getMaxDistance() throws IOException {
        readFromFile();
        //printStudents();
        maxDistance();

    }

    private void printStudents() {
        for (Map.Entry<Integer, Coordinates> entry : positions.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

    }

    public Manager(String url) {
        this.url = url;
    }

    private void readFromFile() throws IOException {
        String[] studensXCoord = Files.readAllLines(Paths.get(url)).get(0).split(",");
        String[] studensYCoord = Files.readAllLines(Paths.get(url)).get(1).split(",");

        for (int studentID = 0; studentID < studensXCoord.length; studentID++) {
            positions.put(studentID, new Coordinates());
            positions.get(studentID).setX(Integer.parseInt(studensXCoord[studentID]));
            positions.get(studentID).setY(Integer.parseInt(studensYCoord[studentID]));

        }
    }

    private double calculateDistanceBetweenStudents(int firstStudent, int secondStudent) {
        Coordinates a = positions.get(firstStudent);
        Coordinates b = positions.get(secondStudent);

        return Math.sqrt(Math.abs((b.getX()- a.getX())*(b.getX()- a.getX()) + (b.getY() - a.getY())* (b.getY() - a.getY())));
    }

    private void maxDistance() {
        int curentStudent = setStartStudent();
        int amountOfStudents = positions.size();
        int nextCurrentStudent = 678977;
        double distance = 0;
        double maxDistance = 0;
        while (positions.size() >1) {
            double currMin = 99999;
            for (int nextStudent = 0; nextStudent < amountOfStudents; nextStudent++) {

                if (nextStudent != curentStudent && positions.get(nextStudent) != null) {
                    distance = calculateDistanceBetweenStudents(curentStudent, nextStudent);
                    //System.out.println("from " + curentStudent + " to  " + nextStudent + " distance is " + distance);

                    if (distance < currMin) {
                        currMin = distance;
                       // System.out.println("Найменша відстань " + currMin);
                       // System.out.println("Значить найбличий студент це  " + nextStudent );
                        nextCurrentStudent = nextStudent;
                    }

                }
            }
            System.out.println();
            positions.remove(curentStudent);
            curentStudent = nextCurrentStudent;

            if (currMin > maxDistance) {
                maxDistance = currMin;
                //System.out.println("Тепер найбільша мінімальна відстань  " + maxDistance);

            }

        }
        System.out.println(maxDistance);

    }

    private int setStartStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student id between 0 and " + (positions.size() - 1) + " to start");

        int startID = in.nextInt();
        return startID;
    }
}