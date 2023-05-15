import java.util.Arrays;
import java.time.LocalTime;

public class ID9147 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        long start = stopWatch.start();

        // Runtime a program.
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        Arrays.sort(array);

        long stop = stopWatch.stop();
        System.out.println("Time run : " + stopWatch.getElapsedTime(start, stop) + " ms");


    }
}

class StopWatch {

    private long startTime, endTime;

    StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    long start() {
        return this.startTime = System.currentTimeMillis();
    }

    long stop() {
        return this.endTime = System.currentTimeMillis();
    }

    long getElapsedTime(long start, long stop) {
        return stop - start;
    }
}


//    private LocalTime startTime, endTime;
//    StopWatch() {
//        this.startTime = LocalTime.now();
//    }
//    LocalTime startTime() {
//        return this.startTime = LocalTime.now();
//    }
//    LocalTime endTime() {
//        return this.endTime = LocalTime.now();
//    }
//    LocalTime getElapsedTime() {
//        LocalTime start = this.startTime;
//        LocalTime end = this.endTime();
//        return ;
//    }
