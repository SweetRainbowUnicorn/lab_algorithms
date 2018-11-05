package main;

public class Main {
    public static void main(String args[]){
        Calendar calendar = new Calendar();
        
        calendar.addHours(new Tuple(1,4));
        calendar.addHours(new Tuple(3,5));
        calendar.addHours(new Tuple(6,9));
        calendar.addHours(new Tuple(7,9));
        calendar.addHours(new Tuple(7,10));
        calendar.addHours(new Tuple(11,15));



        calendar.printHours(calendar.getHours());
        System.out.println("\nSorted");
        calendar.sortHours();
        calendar.printHours(calendar.getHours());
        System.out.println("\nResult");
        calendar.joinHours();
        calendar.printHours(calendar.getHours());




    }
}
