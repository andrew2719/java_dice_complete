package com.andrew.dice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class Dice extends JFrame {
    private JPanel panel;
    private JButton click;
    private JLabel y1, y2, y3, y4,y5,y6 ,c1, c2, c3, c4,c5,c6, res, computer, you,test,fivedice,clickhere;
    int count = 1;
    Random rd = new Random();
    Integer[] yy = {0,0,0,0,0,0};
    Integer[] cc = {0,0,0,0,0,0};

    public Dice()
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);


        you = new JLabel("YOU");
        you.setBounds(30, 150, 80, 25);
        panel.add(you);

        computer = new JLabel("COMPUTER");
        computer.setBounds(30, 350, 80, 25);
        panel.add(computer);

        y1 = new JLabel();
        y1.setBounds(200, 150, 100, 100);
        panel.add(y1);

        y2 = new JLabel();
        y2.setBounds(350, 150, 100, 100);
        panel.add(y2);

        y3 = new JLabel();
        y3.setBounds(500, 150, 100, 100);
        panel.add(y3);

        y4 = new JLabel();
        y4.setBounds(650, 150, 100, 100);
        panel.add(y4);

        y5 = new JLabel();
        y5.setBounds(800, 150, 100, 100);
        panel.add(y5);

        y6 = new JLabel();
        y6.setBounds(950, 150, 100, 100);
        panel.add(y6);

        c1 = new JLabel();
        c1.setBounds(200, 300, 100, 100);
        panel.add(c1);

        c2 = new JLabel();
        c2.setBounds(350, 300, 100, 100);
        panel.add(c2);

        c3 = new JLabel();
        c3.setBounds(500, 300, 100, 100);
        panel.add(c3);

        c4 = new JLabel();
        c4.setBounds(650, 300, 100, 100);
        panel.add(c4);

        c5 = new JLabel();
        c5.setBounds(800, 300, 100, 100);
        panel.add(c5);

        c6 = new JLabel();
        c6.setBounds(950, 300, 100, 100);
        panel.add(c6);


        click = new JButton("Click");
        click.setBounds(350, 20, 80, 25);
        panel.add(click);

        res = new JLabel("Result");
        res.setBounds(325, 50, 150, 25);
        panel.add(res);

/*
        test = new JLabel();
        test.setBounds(350, 100, 100, 100);
        try {
            BufferedImage img = null;
            img = ImageIO.read(getClass().getResource("1.jpg"));
            Image img1 = img.getScaledInstance(test.getWidth(), test.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            test.setIcon(format);
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel.add(test);
        */

        click.addActionListener(new ActionListener() {
            public  void addpic(String s1,String s2,JLabel y,JLabel c)
            {
                try {
                    BufferedImage imgy = null,imgc = null;
                    imgy = ImageIO.read(Objects.requireNonNull(getClass().getResource(s1)));
                    imgc = ImageIO.read(Objects.requireNonNull(getClass().getResource(s2)));
                    Image img1 = imgy.getScaledInstance(y.getWidth(), y.getHeight(), Image.SCALE_SMOOTH);
                    Image img2 = imgc.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon format1 = new ImageIcon(img1);
                    ImageIcon format2 = new ImageIcon(img2);
                    y.setIcon(format1);
                    c.setIcon(format2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                panel.add(y);
                panel.add(c);
            }
            public void whowon(Integer[] yy, Integer[] cc) // finding who won in the game
            {

                if(getmax(yy)>getmax(cc))
                {
                    res.setText("You won");
                }
                else if(getmax(yy)<getmax(cc))
                {
                    res.setText("Computer won");
                }
                else
                {
                    res.setText("Draw");
                }
            }
            public int getmax(Integer[] arr) // every time we get the max in that array
            {
                int max = 0;
                for(int i=0;i<6;i++)
                {
                    if(arr[i]>max)
                    {
                        max = arr[i];
                    }
                }
                return max;
            }

            public void generation(JLabel y,JLabel c) // it generates
            {
                int a = rd.nextInt(6)+1;
                int b = rd.nextInt(6)+1;
                String s1 = String.valueOf(a)+".jpg";
                String s2 = String.valueOf(b)+".jpg";
                addpic(s1,s2,y,c); // ading the dice pictures to the position
                yy[a-1] +=1;
                cc[b-1] +=1;
                int maxy = getmax(yy);
                int maxc = getmax(cc);
                res.setText("You: "+maxy+" Computer: "+maxc);
            }
            public void degen(JLabel y,JLabel c)
            {
                y.setIcon(null);
                c.setIcon(null);
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                /*generation(y1,c1);
                generation(y2,c2);
                generation(y3,c3);
                generation(y4,c4);
                generation(y5,c5);
                generation(y6,c6);
                whowon(yy,cc);

                String s = res.getText();
                JOptionPane.showMessageDialog(null,s);
                JOptionPane.showMessageDialog(null,"Game Over");
                degen(y1,c1);
                degen(y2,c2);
                degen(y3,c3);
                degen(y4,c4);
                degen(y5,c5);
                degen(y6,c6);
                res.setText("Result");
                count=1;
                yy = new Integer[]{0,0,0,0,0,0};
                cc = new Integer[]{0,0,0,0,0,0};*/

                if(count<=6){
                    int y = rd.nextInt(6)+1;
                    int c = rd.nextInt(6)+1;
                    if(count==1)
                    {
                        generation(y1,c1);
                    }
                    else if(count==2)
                    {
                        generation(y2,c2);
                    }
                    else if(count==3)
                    {
                        generation(y3,c3);
                    }
                    else if(count==4)
                    {
                        generation(y4,c4);
                    }
                    else if(count==5)
                    {
                        generation(y5,c5);
                    }
                    else if(count==6)
                    {
                        generation(y6,c6);
                    }
                    count++;
                }
                else
                {
                    // initializing everything back to  0
                    whowon(yy,cc);
                    String s = res.getText();
                    JOptionPane.showMessageDialog(null,s);
                    JOptionPane.showMessageDialog(null,"Game Over");
                    degen(y1,c1);
                    degen(y2,c2);
                    degen(y3,c3);
                    degen(y4,c4);
                    degen(y5,c5);
                    degen(y6,c6);
                    res.setText("Result");
                    count=1;
                    yy = new Integer[]{0,0,0,0,0,0};
                    cc = new Integer[]{0,0,0,0,0,0};
                }
            }
        });
    }
    public static void main(String[] args) {
        // calling the constructor
        Dice dice = new Dice();
    }
}