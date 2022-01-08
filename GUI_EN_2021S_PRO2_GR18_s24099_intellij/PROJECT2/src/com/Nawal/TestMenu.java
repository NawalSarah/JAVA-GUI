package com.Nawal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class TestMenu {
    TestMenu() {
        JFrame f = new JFrame("MENU");
        JButton b = new JButton("Start");
        JButton c = new JButton("High Score");
        JButton g = new JButton("How to Play");
        JButton d = new JButton("Exit");
        b.setBounds(600, 200, 300, 40);
        c.setBounds(600, 300, 300, 40);
        g.setBounds(600, 400, 300, 40);
        d.setBounds(600, 500, 300, 40);
        f.add(b);
        f.add(c);
        f.add(d);
        f.add(g);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("B5 clicked");
                c.setText("Clicked");
                new TableExample();
            }
        });
        g.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("B5 clicked");
                g.setText("Clicked");
                new HowToPlay();
            }
        });


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
            }
        });
        d.addActionListener(e -> System.exit(0));
        f.setSize(1500, 900);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class TableExample {
    JFrame f;

    TableExample() {
        f = new JFrame();
        String data[][] =
                {{"12000", "7", "6700"},
                        {"42000", "4", "7340"},
                        {"12000", "19", "6760"},
                        {"12000", "23", "6750"},
                        {"54000", "44", "56670"},
                        {"56000", "12", "340"},
                        {"7600", "22", "7430"},
                        {"6500", "12", "340"},
                        {"56400", "31", "6650"},
                        {"45320", "71", "34500"},
                        {"30450", "43", "100"},
                        {"50556", "21", "720"},
                        {"121345", "3", "340"},
                        {"12321", "81", "300"},
                        {"65665", "7", "72220"},
                        {"1212", "6", "70"},
                        {"3413", "5", "600"},
                        {"13243", "1", "8600"},
                        {"134314", "2", "800"},
                        {"41344", "31", "900"},
                        {"134314", "3", "100"},
                        {"67675", "23", "7230"},
                        {"75345", "14", "12800"},
                        {"67655", "36", "100"},
                        {"3134", "7", "100"},
                        {"9000", "15", "7300"}};
        String column[] = {"People Infected", "Countries isolated", "Countries spread "};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(300, 400);
        f.setVisible(true);
    }
}

class HowToPlay {
    JFrame f;

    HowToPlay() {
        f = new JFrame();
        String data[][] ={{"Unleash the Virus strand into the world from the lab."},
                {"Now you you tap on the virus to Isolate it"},
                {"you can tap once again to spread the virus all over the world "},
                {"or you can chose to remove the virus and the virus that has been spread"},
                {"sometimes condition can be set on when/how to cure the virus"},
                {"Remove all the virus to Win or you lose"}};



        String column[] = {"How To Play"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(300, 400);
        f.setVisible(true);
    }
}

