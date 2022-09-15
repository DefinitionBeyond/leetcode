import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @create: 2022-07-11 14:55
 **/
public class MutiThreadPrint {


    public  void print() throws InterruptedException {

        CountDownLatch downLatch = new CountDownLatch(5);

        for (int i = 0 ; i< 5; i++){

            try {
                downLatch.countDown();
                MyThread myThread = new MyThread();
                myThread.start();
            }finally {
                downLatch.await();
                if (downLatch.getCount() == 0){
                    notifyAll();
                    downLatch = new CountDownLatch(5);
                }
            }

        }

    }

    static class MyThread extends Thread{

        int a = 0;
        @Override
        public void run() {
            if(a < 24) {
                System.out.print(a++);
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
