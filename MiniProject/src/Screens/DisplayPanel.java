/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Cyb3rtr0N_4vn335H
 */
public class DisplayPanel extends JPanel {

    JFrame frame = new JFrame();
    int height, width;
//    String shape;
    Color color;
//    String transitionType;
    Transition transition;
    Shapes shapes;
    Timer timer;

    public DisplayPanel() {
        frame.setTitle("Transition Output");
        frame.setBackground(Color.white);
        frame.add(this);
        frame.setBounds(300, 300, 400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setdetails(Transition transition, int height, int width, Shapes shapes) {
//        this.transitionType = transitionType;
        this.transition = transition;
        this.height = height;
        this.width = width;
        this.shapes = shapes;
        timer = new Timer();
        timer.schedule(new Taskscheduler(), 100, 1000);
    }

    public void setdetails(Transition transition, int height, int width, Color color) {
//        this.transitionType = transitionType;
        this.transition = transition;
        this.height = height;
        this.width = width;
        this.color = color;
        timer = new Timer();
        timer.schedule(new Taskscheduler(), 100, 1000);
    }

    public void setDetails(Transition transition, Shapes shapes, Color color) {
        this.transition = transition;
        this.color = color;
        this.shapes = shapes;
        timer = new Timer();
        timer.schedule(new Taskscheduler(), 100, 1000);
    }

    @Override
    public void paint(Graphics graphics) {
        if (transition != null) {
            switch (transition) {
                case COLOR:
                    int r,
                     g,
                     b;
                    r = (int) (Math.floor(Math.random() * 256));
                    g = (int) (Math.floor(Math.random() * 256));
                    b = (int) (Math.floor(Math.random() * 256));
                    graphics.setColor(new Color(r, g, b));
                    drawGraphics(graphics);
//                    switch (shape) {
//                        case "Oval":
//                            graphics.fillOval(50, 50, width, height);
//                            break;
//                        case "Triangle":
//                            int x[] = {50 + width / 2, 50, 50 + width,};
//                            int y[] = {50, 50 + height, 50 + height};
//                            graphics.fillPolygon(x, y, 3);
//                            break;
//                        case "Quadilateral":
//                            graphics.fillRect(50, 50, width, height);
//                            break;
//                        default:
//                            break;
//                    }

                    break;

                case SHAPE:
//                    int option;
//                    option = (int) (Math.floor(Math.random() * 3));
                    graphics.setColor(color);
                    shapes = Shapes.values()[new Random().nextInt(Shapes.values().length)];
                    drawGraphics(graphics);
//                    switch (option) {
//                        case 0:
//                            graphics.fillOval(50, 50, width, height);
//                            break;
//                        case 1:
//                            int x[] = {50 + width / 2, 50, 50 + width,};
//                            int y[] = {50, 50 + height, 50 + height};
//                            graphics.fillPolygon(x, y, 3);
//                            break;
//                        case 2:
//                            graphics.fillRect(50, 50, width, height);
//                            break;
//                        default:
//                            break;
//                    }

                    break;

                case SIZE:
                    height = (int) (Math.floor(Math.random() * 325));
                    width = (int) (Math.floor(Math.random() * 325));
                    graphics.setColor(color);
                    drawGraphics(graphics);
                    break;

                default:
                    break;
            }
        }

    }

    private void drawGraphics(Graphics graphics) {
        if (shapes != null) {
            switch (shapes) {
                case OVAL:
                    graphics.fillOval(50, 50, width, height);
                    break;
                case TRIANGLE:
                    int x[] = {50 + width / 2, 50, 50 + width,};
                    int y[] = {50, 50 + height, 50 + height};
                    graphics.fillPolygon(x, y, 3);
                    break;
                case QUADILATERAL:
                    graphics.fillRect(50, 50, width, height);
                    break;
                default:
                    break;
            }
        }
    }

    public void stop() {
        timer.cancel();
    }

    class Taskscheduler extends TimerTask {

        @Override
        public void run() {
            frame.repaint();
        }
    }
}
