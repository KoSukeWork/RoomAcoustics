package com.casey;
import sun.awt.image.ImageWatched;

import javax.xml.bind.Marshaller;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.LinkedList;

/**
 * Created by casey on 5/3/15.
 */
//Mode Canvas is a graph meant to display the modes on a frequency spectrum so they can be visually compared
public class ModeCanvas extends Canvas {

//    Room room1 = UserInputPanel.getRoom1();

    //TODO: This produces null pointer exceptions. This needs fixing
    LinkedList<Integer> lengthModesInt = new LinkedList<Integer>();
    LinkedList<Integer> widthModesInt = new LinkedList<Integer>();
    LinkedList<Integer> heightModesInt = new LinkedList<Integer>();

    public ModeCanvas(){
        setPreferredSize(new Dimension(360, 300));
        setVisible(true);
        setBackground(Color.GRAY);
    }

    public void paint(Graphics g){
        //border
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 340, 260);

        //horizontal lines
        //height zone
        g.setColor(Color.DARK_GRAY);
        g.fillRect(12, 12, 337, 83);

        //width zone
//        g.setColor(Color.GREEN);
        g.fillRect(12, 97, 337, 83);

        //length zone
//        g.setColor(Color.BLUE);
        g.fillRect(12, 182, 337, 87);

        //horizontal lines - removed, but used for reference
//        g.drawLine(10, 30, 350, 30);
//        g.drawLine(10, 50, 350, 50);
//        g.drawLine(10, 70, 350, 70);
//        g.drawLine(10, 90, 350, 90);
//        g.drawLine(10, 110, 350, 110);
//        g.drawLine(10, 130, 350, 130);
//        g.drawLine(10, 150, 350, 150);
//        g.drawLine(10, 170, 350, 170);
//        g.drawLine(10, 190, 350, 190);
//        g.drawLine(10, 210, 350, 210);
//        g.drawLine(10, 230, 350, 230);
//        g.drawLine(10, 250, 350, 250);

        //vertical dashes and freq labels
        g.setColor(Color.BLACK);
        g.drawString("30Hz", 30, 295);
        g.drawLine(40, 10, 40, 280);
        g.drawLine(80, 10, 80, 280);
        g.drawLine(120, 10, 120, 280);
        g.drawLine(160, 10, 160, 280);
        g.drawString("100Hz", 100, 295);
        g.drawLine(200, 10, 200, 280);
        g.drawLine(240, 10, 240, 280);
        g.drawLine(280, 10, 280, 280);
        g.drawLine(320, 10, 320, 280);
        g.drawLine(360, 10, 360, 280);
        g.drawString("200Hz", 200, 295);
        g.drawLine(400, 10, 400, 280);
        g.drawLine(440, 10, 440, 280);
        g.drawLine(480, 10, 480, 280);
        g.drawLine(520, 10, 520, 280);
        g.drawString("300Hz", 300, 295);
        g.drawLine(560, 10, 560, 280);
        g.drawLine(590, 270, 590, 280);


        // mode labels
        g.setColor(Color.WHITE);
        g.drawString("Height Modes", 136, 92);
        g.drawString("Width Modes", 136, 177);
        g.drawString("Length Modes", 136, 263);

        //draw length modes
        while (!lengthModesInt.isEmpty()) {
            g.setColor(Color.RED);
            for( int x : lengthModesInt){
                int lengthX = x;
                //draw mode on canvas
                g.drawOval(5,5,lengthX,80);
            }
        }

        //draw width modes
        while (!widthModesInt.isEmpty()) {
            g.setColor(Color.GREEN);
            for(int x : widthModesInt){
                int widthX = x;
                //draw mode on canvas
                g.drawOval(5,5,widthX,150);
            }
        }

        //draw height modes
        while (!heightModesInt.isEmpty()) {
            g.setColor(Color.BLUE);
            for(int x : heightModesInt){
                int heightX = x;
                //draw mode on canvas
                g.drawOval(5,5,heightX,230);
            }
        }
        repaint();
    }


    //extract modes from Room and add to local LinkedList
    //length
    //TODO: All of these methods cause null pointer exceptions - never did get it working
    public LinkedList<Integer> drawLengthModes(Room room1){
        LinkedList<Integer> lengthModes = room1.getLengthModes();

        for(int x : lengthModes){
            System.out.println(x + ", ");
            lengthModesInt.add(x);
        }
        return lengthModesInt;
    }
    //width
    public LinkedList<Integer> drawWidthModes(Room room1) {
        LinkedList<Integer> widthModes = room1.getWidthModes();

        for (int x : widthModes) {
            System.out.println(x + ", ");
            widthModesInt.add(x);
        }
        return widthModesInt;
    }
    //height
    public LinkedList<Integer> drawHeightModes(Room room1) {
        LinkedList<Integer> heightModes = room1.getHeightModes();

        for (int x : heightModes) {
            System.out.println(x + ", ");
            heightModesInt.add(x);
        }
        return heightModesInt;
    }
}
