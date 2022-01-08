package com.Nawal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Main extends JFrame implements Runnable {

    public static void main(String[] args)  {

        new Main();
        new TestMenu();

    }


    int f_width = 1500;
    int f_height = 900;
    Image buffImage;
    Graphics buffer;
    Image[] vi;
    Thread th;
    private ArrayList<virus> vip = new ArrayList<virus>();
    private ArrayList<virus2> vip2 = new ArrayList<virus2>();
    private ArrayList<virus3> vip3 = new ArrayList<virus3>();
    private ArrayList<virus2> vip4 = new ArrayList<virus2>();
    private ArrayList<Point> drag = new ArrayList<Point>();
  //  private Image plane = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\plane.gif").getImage();
    private Image ship = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\ship.png").getImage();
    private Image backImg = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\world.png").getImage();
    private Image Check = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\Check.png").getImage();
    private Image logo1 = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\info.png").getImage();
    private Image logo2 = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\info2.png").getImage();
    private int Option = 0;//Button state
    private int strand;
    private int isolate;
    private int spread;

    class virus {//Increasing in size
        int x;
        int y;
        int w;

        virus(Point p) {
            this.x = p.x;
            this.y = p.y;
            this.w = 4;
        }

        virus(Point p, int w) {
            this.x = p.x;
            this.y = p.y;
            this.w = w;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setW(int w) {
            this.w = w;
        }

        int bigger() {
            w +=2;
            return w;
        }

    }

    class virus2 {//Without size increase
        int x;
        int y;
        int w;

        virus2(Point p, int w) {
            this.x = p.x;
            this.y = p.y;
            this.w = w;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    class virus3 {// Insignificant increase in size
        int x;
        int y;
        int w;

        virus3(Point p) {
            this.x = p.x;
            this.y = p.y;
            this.w = 2;
        }

        virus3(Point p, int w) {
            this.x = p.x;
            this.y = p.y;
            this.w = w;
        }

        int bigger() {
            w += 1;
            return w;
        }
    }

    Main() {

        vi = new Image[3];
        vi[0] = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\virus.png").getImage();
        vi[1] = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\virus2.png").getImage(); //Putting virus images in an array
        vi[2] = new ImageIcon("E:\\nawalsnew\\untitled8\\src\\Images\\virus3.png").getImage();

        setTitle("ANTI PLAGUE INC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(f_width, f_height);


        addMouseListener(new MyMouse());
        addMouseMotionListener(new MyMouse());
        th = new Thread(this);
        th.start();
        setVisible(true);

    }

    public void run() {

        int n = 0;
        while (true) {
            // add(new abc());
            n++;
            try {
                repaint();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if (n == 60) {
                if (Option == 1) {
                    n = 0;
                } else {
                    Option = 2;
                    n = 0;
                    new GameOver(5);

                    System.out.println("GAMEOVER");
                    JOptionPane.showMessageDialog(null, "Game is Over", "InfoBox: GameOver", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }
    }

    public void paint(Graphics g) {
        buffImage = createImage(f_width, f_height);
        buffer = buffImage.getGraphics();
        update(g);

    }

    public void update(Graphics g) {
        Draw();
        g.drawImage(buffImage, 0, 0, this);
    }

    public void Draw() {
        buffer.drawImage(backImg, 0, 0, f_width, f_height, this);
        // buffer.drawImage(plane, 300, 300, f_width/7, f_height/7, this);
        buffer.drawImage(ship, 350, 700, f_width/40, f_height/40, this);
        buffer.drawImage(ship, 700, 200, f_width/40, f_height/40, this);
        buffer.drawImage(ship, 1200, 500, f_width/40, f_height/40, this);
       //  buffer.drawImage(plane, 650, 500, f_width/7, f_height/7, this);
        for (virus data : vip) {
            buffer.drawImage(vi[0], data.x - data.bigger() / 2, data.y - data.bigger() / 2, data.bigger(), data.bigger(), this);
        }

        strand = vip.size();


        for (virus2 data : vip2) {
            buffer.drawImage(vi[1], data.x - data.w / 2, data.y - data.w / 2, data.w, data.w, this);
        }

        isolate = vip2.size();

        for (virus3 data : vip3) {
            buffer.drawImage(vi[2], data.x - data.bigger() / 2, data.y - data.bigger() / 2, data.bigger(), data.bigger(),
                    this);
        }

        spread = vip3.size();

        for (virus2 data : vip4) {
            buffer.drawImage(vi[1], data.x - data.w / 2, data.y - data.w / 2, data.w, data.w, this);
        }

        setTitle("ANTI PLAGUE GAME  : " + strand*3000 + "People Infected : " + isolate + "Countries Isolated  : " + spread+ "Countries spread : ");

        if (Option == 0) {
            buffer.drawImage(logo1, (f_width - 300) /5, 50, 1000, 70, this);
        }

        if (Option == 1) {
            buffer.drawImage(Check, (f_width - 50) / 2, f_height - 100, 50, 50, this);
            buffer.drawImage(logo2, (f_width - 400) / 2, 50, 400, 30, this);
        }

    }

    class MyMouse extends MouseAdapter {

        private Point start;

        public void mousePressed(MouseEvent e) {

            //When the mouse button is pressed
            start = e.getPoint();

            if (Option == 0) { //Basic state
                for (virus data : vip) {
                    if ((data.x - data.bigger() / 4 <= start.x && start.x <= data.x + data.bigger() / 4)
                            && (data.y - data.bigger() / 4 <= start.y && start.y <= data.y + data.bigger() / 4)) {
                        Point p1 = new Point(data.x, data.y);
                        virus2 a = new virus2(p1, data.bigger());
                        vip2.add(a);
                        vip.remove(vip.indexOf(data));
                        return;
                    }

                }

                for (virus2 data2 : vip2) { //Routine that works when a stopped virus is clicked
                    if ((data2.x - data2.w / 4 <= start.x && start.x <= data2.x + data2.w / 4)
                            && (data2.y - data2.w / 4 <= start.y && start.y <= data2.y + data2.w / 4)) {
                        String[] buttonText = { "Remove","Spread" };
                        int result = JOptionPane.showOptionDialog(null, "What kind of action do you want", "Selection window",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttonText,
                                buttonText[0]);
                        if (result == JOptionPane.CLOSED_OPTION) { //When the user closes the window without clicking both.

                        } else if (result == 0) { //If you clicked on (click Remove)
                            // if(isolate>5)
                            vip2.remove(vip2.indexOf(data2));
                            //  else
                          /*  {
                               System.out.println("not possible now!!");
                            }*/

                        } else { //If you click No (click Spread)
                            vip2.remove(vip2.indexOf(data2));
                            Point p2 = new Point(data2.x, data2.y);
                            virus3 a2 = new virus3(p2, data2.w);
                            vip3.add(a2);

                            virus2 a4 = new virus2(p2, data2.w);
                            vip4.add(a4);
                            Option = 1;

                        }

                        return;
                    }

                }

                for (virus3 data : vip3) {
                    if ((data.x - data.w / 8 <= start.x && start.x <= data.x + data.w / 8)
                            && (data.y - data.w / 8 <= start.y && start.y <= data.y + data.w / 8)) {
                        vip3.remove(vip3.indexOf(data));
                        return;
                    }
                }

                virus p4 = new virus(start);
                vip.add(p4);

            }

            if (Option == 1) {//Selection status
                if (((f_width - 50) / 2 - 50 <= start.x && start.x <= (f_width - 50) / 2 + 50)
                        && (f_height - 100 <= start.y && start.y <= f_height - 50)) {
                    for (virus2 data : vip4) {
                        Point p3 = new Point(data.x, data.y);
                        virus a3 = new virus(p3, data.w);
                        vip.add(a3);

                    }
                    vip4.clear();
                    Option = 0;
                    return;
                }
            }
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseDragged(MouseEvent e) {
            Point end = new Point();
            end = e.getPoint();
            if (Option == 1) {
                for (virus2 data : vip4) {
                    if ((data.x - data.w / 4 <= end.x && end.x <= data.x + data.w / 4)
                            && (data.y - data.w / 4 <= end.y && end.y <= data.y + data.w / 4)) {
                        data.setX(end.x);
                        data.setY(end.y);
                        drag.add(end);
                    }
                }

            }
        }

        public void mouseReleased(MouseEvent e) {
            for (int i = 0; i < drag.size(); i += 50) {
                Point p = new Point(drag.get(i));
                virus3 p1 = new virus3(p);
                vip3.add(p1);
            }
            drag.clear();
        }

    }

}



