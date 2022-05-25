package Thread;

import java.util.stream.IntStream;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        IntStream.rangeClosed(0, 2).boxed().forEach(x->{
                System.out.println("Main thread running " + ++x);
            try {
                Thread.sleep(2101);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        RunThread runThread = new RunThread();
        runThread.start();

        IntStream.rangeClosed(3,5).boxed().forEach(x->{
            System.out.println("Main thread running " + ++x);
            try {
                Thread.sleep(2101);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("  => Main thread end");


    }

}
