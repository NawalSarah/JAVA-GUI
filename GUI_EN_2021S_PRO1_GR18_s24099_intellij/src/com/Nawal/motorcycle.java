package com.Nawal;

import java.util.Scanner;

public class motorcycle extends Volume{
    motorcycle  (double l,double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }
    void info(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter engine capacity & engine type" );

        double capacity =sc.nextDouble();
        String type =sc.next();
        System.out.println("\nSpecs of the motorcycle  is \n engine capacity-" +capacity + "\nengine type" +type+"\n");
    }
    void cal_volume()
    {
        double vol = l * b * h;

        System.out.println("\nVolume of motorcycle ="+vol);
    }
}

