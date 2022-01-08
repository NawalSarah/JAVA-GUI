package com.Nawal;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 3500);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Rent DUE");
            timer.cancel(); //Terminate the timer thread
        }
    }
}
