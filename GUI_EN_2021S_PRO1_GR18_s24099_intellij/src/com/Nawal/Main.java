package com.Nawal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws TooManyThingsException {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> people = new HashMap<String,Double>();
        RentalProperty[] P = new RentalProperty[1000];
        Tenant[] T = new Tenant[1000];
        Rental R[] = new Rental[10000];
        int n;
        while (true) {
            System.out.println("1 Add new Rental Property");
            System.out.println("2 Add a New Tenant");
            System.out.println("3 Create a New Rental");
            System.out.println("4 Print List of all properties");
            System.out.println("5 Print List of Tenants");
            System.out.println("6 Print List of All Rentals");
            System.out.println("7 Adjust rent amounts");
            System.out.println("8 Add Item to Room");
            System.out.println("0 Quit");
            n = sc.nextInt();
            if (n == 1) {
                System.out.print("Enter PropNo: ");
                String no = sc.next();
                System.out.print("Enter PropType: ");
                String type = sc.next();
                //System.out.print("Enter Volume");

                double vol, rent, value;
                while (true) {
                    System.out.print("Enter saleValue: ");
                    value = sc.nextDouble();
                    if (value > 0) {
                        break;
                    }
                    System.out.println("Sales value must be greater than 0");
                }
                while (true) {
                    System.out.print("Enter rent amount: ");
                    rent = sc.nextDouble();
                    if (rent > 0) {
                        break;
                    }
                    System.out.println("Rent Amount must be greater than 0");
                }
                while (true) {
                    System.out.print("Enter volume of Apartment ");
                    vol = sc.nextDouble();
                    if (vol > 0) {
                        break;
                    }
                    System.out.println("Volume must be greater than 0");
                }
                for (int i = 0; i < P.length; i++) {
                    if (P[i] == null) {
                        P[i] = new RentalProperty(no, type, vol, value, rent);
                        System.out.println("New Rental Property added");
                        System.out.println(P[i].toString());
                        break;
                    }
                }
            } else if (n == 2) {
                System.out.print("Enter Tenant name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Enter Tenant Cellphone: ");
                String number = sc.next();
                System.out.print("Enter PESEL ");
                String PES = sc.next();
                System.out.print("Enter ROOM number (1-4) ");
                String Room = sc.next();
                System.out.print("Enter volume ");
                Double volofRoom = sc.nextDouble();
                for (int i = 0; i < T.length; i++) {
                    if (T[i] == null) {
                        T[i] = new Tenant(name, number, PES, Room, volofRoom);
                        System.out.println("New Tenant added");
                        System.out.println(T[i].toString());
                        break;
                    }
                }
            } else if (n == 3) {
                System.out.print("Enter Rental PropNo: ");
                String propno = sc.next();
                int rentalIndex = -1;
                boolean isFound = false;
                while (!isFound) {
                    for (int i = 0; i < P.length; i++) {
                        if (P[i] != null) {
                            if (P[i].getPropNo().equals(propno)) {
                                isFound = true;
                                rentalIndex = i;
                                break;
                            }
                        }
                    }
                    if (!isFound) {
                        System.out.println("Not Found!!");
                        System.out.print("Enter different property number: ");
                        propno = sc.next();
                    }
                }
                System.out.print("Enter Name ");
                String name = sc.next();
                int tenantIndex = -1;
                boolean isTenantFound = false;
                while (!isTenantFound) {
                    for (int i = 0; i < T.length; i++) {
                        if (T[i] != null) {
                            if (T[i].getName().equals(name)) {
                                isTenantFound = true;
                                tenantIndex = i;
                                break;
                            }
                        }
                    }
                    if (!isTenantFound) {
                        System.out.println("Not Found!!");
                        System.out.print("Enter different cellphone: ");
                        name = sc.next();
                    }
                }
                System.out.print("Enter PESEL ");
                String pesel = sc.next();
                tenantIndex = -1;
                 isTenantFound = false;
                while (!isTenantFound) {
                    for (int i = 0; i < T.length; i++) {
                        if (T[i] != null) {
                            if (T[i].getpesel().equals(pesel)) {
                                isTenantFound = true;
                                tenantIndex = i;
                                break;
                            }
                        }
                    }
                    if (!isTenantFound) {
                        System.out.println("Not Found!!");
                        System.out.print("Enter different PESEL: ");
                        name = sc.next();
                    }
                }
                System.out.print("Do you want Parking space ? Yes/No ");
                String answer = sc.next();
                double space = 6000;
                double vol = 0.0;
                Boolean yn = (answer.equalsIgnoreCase("Yes") ? true : false);
                if (yn == true) {
                    for (int k = 0; k < 4; k++) {
                    System.out.println("parking space added\n");
                    System.out.println("1.Add City Car\n");
                    System.out.println("2.Add offroad \n");
                    System.out.println("3.Add motorcycle \n");
                    System.out.println("4.Add boat \n");
                    System.out.println("5.Add amphibious \n");
                    System.out.println("6.Add No More\n");
                    int c = sc.nextInt();

                            double l, h, b;
                            if (c == 1) {
                                System.out.println("\nEnter length ,breadth, height for city car:");

                                l = sc.nextDouble();
                                b = sc.nextDouble();
                                h = sc.nextDouble();
                                Volume v;
                                v = new citycar(l, b, h);
                                v.info();
                                v.cal_volume();
                            }
                            if (c == 2) {
                                System.out.println("\nEnter length,height,breadth,length for Offroad car");

                                l = sc.nextDouble();
                                b = sc.nextDouble();
                                h = sc.nextDouble();
                                Volume B;
                                B = new offroadcar(l, b, h);
                                B.info();
                                B.cal_volume();
                            }
                            if (c == 3) {
                                System.out.println("\nEnter length,height,breadth,length for motorcycle car");

                                l = sc.nextDouble();
                                b = sc.nextDouble();
                                h = sc.nextDouble();
                                Volume M;
                                M = new motorcycle(l, b, h);
                                M.info();
                                M.cal_volume();
                            }
                            if (c == 4) {
                                System.out.println("\nEnter length,height,breadth,length for boat car");

                                l = sc.nextDouble();
                                b = sc.nextDouble();
                                h = sc.nextDouble();
                                Volume S;
                                S = new boat(l, b, h);
                                S.info();
                                S.cal_volume();
                            }
                            if (c == 5) {
                                System.out.println("\nEnter length,height,breadth,length for amphibious car");

                                l = sc.nextDouble();
                                b = sc.nextDouble();
                                h = sc.nextDouble();
                                Volume A;
                                A = new amphibious(l, b, h);
                                A.info();
                                A.cal_volume();

                            }
                            if (c == 6) {
                                System.out.println("Exit!");
                                break;
                            }
                        }
                    }

            else {
                    System.out.println("no parking space added");
                }

                System.out.print("Enter rental start Date (Format DD/MM/YYYY): ");
                String date = sc.next();
                System.out.print("Enter number of days ");
                String term = sc.next();
                new Reminder(5);

                System.out.println("Rent scheduled.");
                try{
                    // Create new file
                    String content = "Rent Expired Property number-" +propno+ ", Mobile Number " +pesel+ ",Name " +name;
                    String path="E:\\nawalsnew\\letter.txt";
                    File file = new File(path);

                    // If file doesn't exists, then create it
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);

                    // Write in file
                    bw.write(content);

                    // Close connection
                    bw.close();
                }
                catch(Exception e){
                    System.out.println(e);
                }
                for (int i = 0; i < R.length; i++) {
                    if (R[i] == null) {
                        R[i] = new Rental(P[rentalIndex], T[tenantIndex], vol, date, answer, term);
                        break;
                    }
                }
            } else if (n == 4) {
                for (int i = 0; i < P.length; i++) {
                    if (P[i] != null) {
                        System.out.println(P[i].toString());
                    }
                }
            } else if (n == 5) {
                for (int i = 0; i < T.length; i++) {
                    if (T[i] != null) {
                        System.out.println(T[i].toString());
                    }
                }
            } else if (n == 6) {
                try {
                    for (int i = 0; i < R.length; i++) {
                        if (R[i] != null) {
                            String content = (R[i].toString())+"\n";


                            String path = "E:\\nawalsnew\\status.txt";
                            File file = new File(path);

                            // If file doesn't exists, then create it
                            if (!file.exists()) {
                                file.createNewFile();
                            }

                            FileWriter fw = new FileWriter(file.getAbsoluteFile());
                            BufferedWriter bw = new BufferedWriter(fw);

                            // Write in file
                            bw.write(content);

                            // Close connection
                            bw.close();
                        }
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }



            } else if (n == 7) {
                System.out.println("Enter percent increase in rent: ");
                int increase = sc.nextInt();
                for (int i = 0; i < P.length; i++) {
                    if (P[i] != null) {
                        double new_rent = P[i].getRentAmt() * ((1 + increase) / 100);
                        P[i].setRentAmt(new_rent);
                    }
                }
            } else if (n == 8) {
                double total = 0.0;
                System.out.println("Enter room number");
                String room = sc.next();
                int tenantIndex = -1;
                boolean isTenantFound = false;
                while (!isTenantFound) {
                    for (int i = 0; i < T.length; i++) {
                        if (T[i] != null) {
                            if (T[i].getRoom().equals(room)) {
                                isTenantFound = true;
                                tenantIndex += i;
                                break;
                            }
                        }
                    }
                    System.out.println("Enter volume of your room");
                    double Rvol = sc.nextDouble();
                    people.put("Box", 323.0);
                    people.put("Cupboard", 3033.1);
                    people.put("Bed", 33.2);
                    people.put("Lamp", 32.3);
                    people.put("Desk", 30.4);
                    System.out.println("Enter more items to add");
                    System.out.println("item Name");
                    String s = sc.next();
                    System.out.println("item Volume");
                    double d = sc.nextDouble();
                    people.put(s, d);
                    for (String i : people.keySet()) {
                        System.out.println("key: " + i + " volume: " + people.get(i) + "\n");
                        total += people.get(i);
                    }
                    System.out.println(total);
                    if (total > Rvol) {
                        throw new TooManyThingsException("Remove some items  to  insert others");
                    } else
                        System.out.println("Items added successfully");
                }
            }
            else if (n == 0) {
                System.out.println("Exit!");
                break;
            }

        }


    }
}
