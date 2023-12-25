package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;


    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }


    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home home) {
        return Double.compare(getArea(), home.getArea());
    }
}
// END
