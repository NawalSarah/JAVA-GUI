package com.Nawal;

import java.util.Scanner;

public class citycar extends Volume {
    citycar(double l,double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }
    void info(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter engine capacity & engine type" );

        double capacity =sc.nextDouble();
        String type =sc.next();
        System.out.println("\nSpecs of the car is \nengine capacity-" +capacity + "\n engine type" +type+"\n");
    }
    void cal_volume()
    {
        double vol = l * b * h;

        System.out.println("\nVolume of car="+vol);
    }
}
/*
public class citycar extends Vehicle{


    private int color;

    public citycar(String name, double engineCapacity) {
        super(name, 4.0, "motorcycle", "fuel", 1, 4, 3)

        this.color =color;
    }
    public int  getwheel ()
    {
        return color;
    }
}
*/
 