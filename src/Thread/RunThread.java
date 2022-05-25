package Thread;

import java.util.stream.IntStream;

public class RunThread extends Thread {

    @Override
    public void run() {
        IntStream.rangeClosed(0, 10).boxed().forEach(x->{
            System.out.println("     + Run child thread with "+ ++x);

            try {
                Thread.sleep(1030);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(" ==> Child thread stopped");


    }
}
