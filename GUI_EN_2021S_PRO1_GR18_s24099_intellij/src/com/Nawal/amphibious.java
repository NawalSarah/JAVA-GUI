package com.Nawal;
import java.util.Scanner;

public class amphibious extends Volume {
    amphibious(double l,double b, double h) {
       this.l = l;
        this.b = b;
        this.h = h;
    }
    void info(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter engine capacity & engine type" );

        double capacity =sc.nextDouble();
        String type =sc.next();
        System.out.println("\nSpecs of the car is \n engine capacity-" +capacity + "\n engine type-" +type+"\n");

    }

    void cal_volume()
    {
        double vol = l * b * h;

        System.out.println("\nVolume of car="+vol);
    }
}




