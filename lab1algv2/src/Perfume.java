public class Perfume {
    private double volume;
    private double price;
    private String name;

    public Perfume() {

    }

    public Perfume(String name, double volume, int price) {
        this.name = name;
        this.volume = volume;
        this.price = price;

    }

    @Override
    public String toString() {

        return "Назва парфумів " + this.name + " Об'єм в мл: " + this.volume + " Ціна парфумів: " + this.price;
    }


    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}