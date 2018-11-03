package main;

public class Tuple {
    public  Integer key;
    public  Integer value;
    public Tuple(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
    public String toString(){
        return "["+ key + "," + value  + "]";



    }
}
