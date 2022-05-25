package Thread;

import java.util.stream.IntStream;

public class RunThread extends Thread {

    @Override
    public void run() {
//        IntStream.rangeClosed(0, 10).boxed().forEach(x->{
//            System.out.println("Run child thread with "+ ++x);
//
//            try {
//                Thread.sleep(1030);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println("  - ==> Child thread stopped");

        int index = 1;

        for (int i = 0; i < 10; i++) {
            System.out.println("  - HelloThread running " + index++);

            try {
                // Ngủ 1030 milli giây.
                Thread.sleep(1030);
            } catch (InterruptedException e) {
            }

        }
        System.out.println("  - ==> HelloThread stopped");
    }
}
