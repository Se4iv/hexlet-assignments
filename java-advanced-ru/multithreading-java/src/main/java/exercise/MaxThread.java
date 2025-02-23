package exercise;

// BEGIN
public class MaxThread extends Thread{
    private final int[] array;
    private int max = Integer.MIN_VALUE;

    public MaxThread(int[] array) {
        this.array = array;
    }
    @Override
    public void run() {
        for (int i: array) {
            if (i > max){
                max = i;
            }
        }
    }

    public int getMax() {
        return max;
    }
}
// END
