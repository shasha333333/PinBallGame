package com.bouncingBallGame;

import com.bouncingBallGame.ui.GameJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.*;

public class BouncingBallGame {
    //创建窗口对象
    private final GameJFrame frame = new GameJFrame();
//    private final Frame frame = new Frame("弹球游戏");

    //桌面宽度
    public static final int TABLE_WIDTH = FinalData.TABLE_WIDTH;
    //桌面高度
    public static final int TABLE_HEIGHT = FinalData.TABLE_HEIGHT;

    //小球个数
    public static int ballNum = 10;
    private int ballSize;

    //鼠标坐标(一定要初始化，不然默认数值0直接游戏结束)
    private int mouseCodeX = FinalData.TABLE_WIDTH/2;
    private int mouseCodeY = FinalData.TABLE_HEIGHT/2;

    //小球
    public java.util.List<Ball> balls = new ArrayList<>();

    //鼠标显示方块
    private Square square = new Square();

    //线程池
    private ExecutorService pool = Executors.newCachedThreadPool();

    //定义变量，标识当前游戏是否已结束
    private static boolean isOver = false;

    //声明一个定时器
    private Timer timer;

    //游戏时间
    private static double time;
    private double startTime;
    private double endTime;

    //初始化
    public BouncingBallGame(){}

    //带参初始化
    public BouncingBallGame(int num,int size){
        ballNum = num;
        ballSize = size;
    }

    //返回游戏结束标志
    public static boolean getIsOver() {
        return isOver;
    }

    public static double getTime() { return time; }

    //判断结束方法
    public void end(Ball ball){

        if (mouseCodeX <= 0 || mouseCodeX >= BouncingBallGame.TABLE_WIDTH ||
            mouseCodeY <= 0 || mouseCodeY >= BouncingBallGame.TABLE_HEIGHT){
            isOver = true;
        }

        else if (Math.abs(mouseCodeX-ball.getBallX()) <= ball.getBALL_SIZE() &&
                Math.abs(mouseCodeY-ball.getBallY()) <= ball.getBALL_SIZE()) {
            isOver = true;
        }

        else if (Math.abs(mouseCodeX-ball.getBallX()) <= square.getSQUARE_SIZE() &&
                Math.abs(mouseCodeY-ball.getBallY()) <= square.getSQUARE_SIZE()){
            isOver = true;
        }

    }


    private class MyRunnable implements Runnable{
        Ball ball;
        public MyRunnable(Ball ball){
            this.ball = ball;
        }
        @Override
        public void run() {
            if(!isOver){
//                time++;
                ball.move();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                end(ball);
                //重绘界面
                drawArea.repaint();
                endTime = Calendar.getInstance().getTimeInMillis();
                time = endTime-startTime;
                out.println("游戏进行"+time/1000+"秒");
            }
            else{
                timer.stop();
//                endTime = Calendar.getInstance().getTimeInMillis();
//                time = endTime-startTime;
            }

        }
    }

    //创建绘画区域
    MyPanel drawArea = new MyPanel(balls,square);

    public void init() {

        for(int i = 0 ; i < ballNum ; i++){
            balls.add(new Ball(ballSize));
        }

        //完成鼠标坐标的变化
        MouseMotionListener listener = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseCodeX = e.getX();
                mouseCodeY = e.getY();
                square.setSquareX(mouseCodeX);
                square.setSquareY(mouseCodeY);
            }
        };

//        //给Frame和drawArea注测监听器
//        frame.addMouseMotionListener(listener);
        drawArea.addMouseMotionListener(listener);
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Ball ball : balls) {
                    pool.submit(new MyRunnable(ball));
                }
            }
        };

        timer = new Timer(FinalData.DELAY, task);
        timer.start();

        drawArea.setPreferredSize(new Dimension(BouncingBallGame.TABLE_WIDTH,BouncingBallGame.TABLE_HEIGHT));
        frame.add(drawArea);

        //游戏开始计时
        startTime = Calendar.getInstance().getTimeInMillis();
        //设置frame最佳大小，并可视
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit(0);
            }
        });
    }



    public static void main(String[] args) {
        new BouncingBallGame().init();
    }
}

