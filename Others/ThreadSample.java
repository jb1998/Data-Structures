//import java.util.Date;
//
//public class ThreadSample extends Thread {
//    int times;
//
//    ThreadSample(int times) {
//        this.times = times;
//    }
//
//    @Override
//    public void run() {
//
//        for (int i = 0; i < times; i++) {
//            System.out.println(times + " " + i + 1 + new Date());
//            try {
//                this.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static void main(String args[]) {
//        ThreadSample threadSample = new ThreadSample(10);
//        threadSample.start();
//
//    }
//}
