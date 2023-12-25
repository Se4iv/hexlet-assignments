package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public double getBalconyArea() {
        return balconyArea;
    }

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }

    public double getArea() {
        return this.area + getBalconyArea();
    }
    @Override
    public int compareTo(Home another) {
        return Double.compare(getArea(), another.getArea());
    }
}
// END
