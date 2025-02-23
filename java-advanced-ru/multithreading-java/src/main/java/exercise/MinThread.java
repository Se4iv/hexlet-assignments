package exercise;

// BEGIN
public class MinThread extends Thread{
    private final int[] array;
    private int min = Integer.MAX_VALUE;

    public MinThread(int[] array) {
        this.array = array;
    }
    @Override
    public void run() {
        for (int i: array) {
            if (i < min){
                min = i;
            }
        }
    }

    public int getMin() {
        return min;
    }
}
// END
