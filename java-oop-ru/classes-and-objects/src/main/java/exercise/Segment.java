package exercise;

// BEGIN
public class Segment {
    private Point beginpoint;
    private Point endpoint;

    public Segment(Point beginpoint, Point endpoint) {
        this.beginpoint = beginpoint;
        this.endpoint = endpoint;
    }

    public Point getBeginPoint() {
        return beginpoint;
    }

    public Point getEndPoint() {
        return endpoint;
    }

    public Point getMidPoint() {
        return new Point((getBeginPoint().getX() + getEndPoint().getX()) / 2, (getBeginPoint().getY()
                + getEndPoint().getY()) / 2);
    }
}
// END
