package test;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

    public class BouncingBall extends JPanel implements Runnable {
        private static final long serialVersionUID = 1L;
        private static final int WIDTH = 800;
        private static final int HEIGHT = 600;
        private static final int BALL_SIZE = 50;
        private static final int DELAY = 20;

        private List<Ball> balls = new ArrayList<>();

        public BouncingBall() {
            JFrame frame = new JFrame("Bouncing Ball");
            frame.setSize(WIDTH, HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.add(this);
            frame.setVisible(true);

            Ball ball1 = new Ball(0, 0, BALL_SIZE, Color.RED);
            Ball ball2 = new Ball(200, 200, BALL_SIZE, Color.GREEN);
            Ball ball3 = new Ball(400, 400, BALL_SIZE, Color.BLUE);
            balls.add(ball1);
            balls.add(ball2);
            balls.add(ball3);

            new Thread(this).start();
        }

        public void run() {
            while (true) {
                for (Ball ball : balls) {
                    ball.move();
                }
                repaint();
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Ball ball : balls) {
                ball.draw(g);
            }
        }

        public static void main(String[] args) {
            new BouncingBall();
        }

        private class Ball {
            private int x;
            private int y;
            private int size;
            private Color color;
            private int dx = 50;
            private int dy = 20;

            public Ball(int x, int y, int size, Color color) {
                this.x = x;
                this.y = y;
                this.size = size;
                this.color = color;
            }

            public void move() {
                if (x < 0 || x + size > WIDTH) {
                    dx = -dx;
                }
                if (y < 0 || y + size > HEIGHT) {
                    dy = -dy;
                }
                x += dx;
                y += dy;
            }

            public void draw(Graphics g) {
                g.setColor(color);
                g.fillOval(x, y, size, size);
            }
        }
    }


