package Thread;

import java.util.stream.IntStream;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
//        IntStream.rangeClosed(0, 2).boxed().forEach(x->{
//                System.out.println("Main thread running " + ++x);
//            try {
//                Thread.sleep(2101);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        RunThread runThread = new RunThread();
//        runThread.ChildThread();
//
//        IntStream.rangeClosed(3,5).boxed().forEach(x->{
//            System.out.println("Main thread running " + ++x);
//            try {
//                Thread.sleep(2101);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        System.out.println("  => Main thread end");


        int idx = 1;

        for (int i = 0; i < 2; i++) {

            System.out.println("Main thread running " + idx++);
            // Ngủ 2101 milli giây.
            Thread.sleep(2101);
        }

        RunThread helloThread = new RunThread();

        // Chạy thread
        helloThread.start();

        for (int i = 0; i < 3; i++) {
            System.out.println("Main thread running " + idx++);
            // Ngủ 2101 milli giây.
            Thread.sleep(2101);
        }

        System.out.println("==> Main thread stopped");
    }

}
