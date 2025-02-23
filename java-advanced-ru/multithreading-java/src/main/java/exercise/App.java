package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] array) {
    MaxThread maxThread = new MaxThread(array);
    MinThread minThread = new MinThread(array);
    Map<String, Integer> result = new HashMap<>();


    maxThread.start();
    LOGGER.log(Level.INFO,"Thread " + Thread.currentThread().getName() + " started");
    minThread.start();
    LOGGER.log(Level.INFO, "Thread " + Thread.currentThread().getName() + " started");
    try {
        maxThread.join();
        LOGGER.log(Level.INFO,"Thread " + Thread.currentThread().getName() + " finished");
        minThread.join();
        LOGGER.log(Level.INFO,"Thread " + Thread.currentThread().getName() + " finished");
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    result.put("min", minThread.getMin());
    result.put("max", maxThread.getMax());
    return result;
    }
    // END
}
