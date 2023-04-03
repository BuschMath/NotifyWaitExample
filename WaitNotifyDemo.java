
/*In this example, the WaitNotifyDemo class demonstrates the usage of 
    the notify() and wait() methods for inter-thread communication. The 
    main thread creates two other threads, t1 and t2. Thread t1 waits 
    for a notification from thread t2 using the wait() method, and thread 
    t2 notifies t1 using the notify() method. */

public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1 waiting...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 notified!");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 notifying...");
                lock.notify();
            }
        });

        t1.start();
        Thread.sleep(1000); // wait for a bit
        t2.start();
    }
}
