package com.Nawal;


import java.util.Timer;
import java.util.TimerTask;

public class GameOver {
    Timer timer;

    public GameOver(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Game Over");
            timer.cancel(); //Terminate the timer thread
        }
    }
}
