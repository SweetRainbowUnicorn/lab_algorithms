import java.io.IOException;

public class Main {

    public static void main(String [] sviat) throws IOException {
        String url = "D:\\lab_algo\\lab4alg\\src\\input";
        Manager manager = new Manager(url);
        manager.getMaxDistance();
    }
}
