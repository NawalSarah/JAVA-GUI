package com.Nawal;

import java.util.Scanner;

public abstract class item  {
    private String name;
    public item (String name) {
        this.name = name;
    }
    public abstract double getVolume();
    public String getName() {
        return name;
    }
}
