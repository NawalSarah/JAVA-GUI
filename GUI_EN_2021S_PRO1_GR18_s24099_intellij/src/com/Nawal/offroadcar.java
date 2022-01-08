package com.Nawal;
import java.util.Scanner;

   class offroadcar extends Volume {
     offroadcar(double l,double b, double h) {
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
         System.out.println("\nSpecs of the car is \nengine capacity-" +capacity + "\nengine type-" +type+"\n");
     }
     void cal_volume()
     {
         double vol = l * b * h;

         System.out.println("\nVolume of car="+vol);
     }
 }

