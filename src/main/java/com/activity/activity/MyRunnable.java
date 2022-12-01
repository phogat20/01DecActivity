package com.activity.activity;

import java.util.logging.Level;
import java.util.logging.Logger;

class MyRunnable implements Runnable {

    private final long waitTime;

    public MyRunnable(int timeInMillis)
    {
        this.waitTime = timeInMillis;
    }

    @Override
    public void run()
    {
        try {
            // sleep for user given millisecond
            // before checking again
            Thread.sleep(waitTime);

            // return current thread name
            System.out.println(Thread
                    .currentThread()
                    .getName());
        }

        catch (InterruptedException ex) {
            Logger
                    .getLogger(MyRunnable.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
