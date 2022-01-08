package com.Nawal;

import java.util.Scanner;

public class boat extends Volume{
    boat(double l,double b, double h) {
        super();
        this.l = l;
        this.b = b;
        this.h = h;
    }
    void info(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter engine capacity & engine type" );

        double capacity =sc.nextDouble();
        String type =sc.next();
        System.out.println("\nSpecs of the boat is \n engine capacity-" +capacity + "\nengine type-" +type+"\n");
    }
    void cal_volume()
    {
        double vol = l * b * h;

        System.out.println("\nVolume of boat="+vol);
    }
}


/*
public class boat extends Vehicle{


    private int rowing;

    public boat(String name, double engineCapacity) {
        super(name, 4.0, "boat", "fuel", 1, 4, 3)

        this.rowing =rowing;
    }
    public int  rowing ()
    {
        return rowing;
    }
}
*/