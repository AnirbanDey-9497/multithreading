package src;

public class Thread_Runnable {
    public static void main(String[] args) {
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("We are now in thread"+ Thread.currentThread().getName());
                System.out.println("Current thread priority is"+ Thread.currentThread().getPriority());

                throw new RuntimeException("Intentional Exception");
            }


    });
        thread.setName("New Worker Thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread "+ t.getName() + "Error message "+ e.getMessage() );
            }
        });

        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: "+Thread.currentThread().getName()+"before starting a new thread");
        thread.start();
        System.out.println("We are in thread: "+Thread.currentThread().getName()+"after starting a new thread");
    }
}
