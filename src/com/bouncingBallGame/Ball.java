package com.bouncingBallGame;

import java.awt.*;
import java.util.Random;

public class Ball {
    //小球的颜色
    private Color color;

    //小球的大小
    private final int BALL_SIZE;

    //定义变量，记录小球的坐标
    private int ballX;
    private int ballY;

    //定义变量，记录小球在x和y方向上分别移动的速度
    private int speedY;
    private int speedX;

    //初始化
    public Ball() {
        Random rd = new Random();
        //初始化常量字段
        float r,g,b;       //颜色RGB,用于获取浅色
        do{
            r = rd.nextFloat();
            g = rd.nextFloat();
            b = rd.nextFloat();
        }while((r*0.299+g*0.587+b*0.114) <= 0.5);   //色彩心理学公式
        this.color = new Color(r,g,b);
        
        //初始化位置，速度，大小
        this.ballX = rd.nextInt(FinalData.TABLE_WIDTH);
        this.ballY = rd.nextInt(FinalData.TABLE_HEIGHT);
        this.speedX = rd.nextInt(FinalData.BALL_MAX_SPEED) + FinalData.BALL_MIN_SPEED;
        this.speedY = rd.nextInt(FinalData.BALL_MAX_SPEED) + FinalData.BALL_MIN_SPEED;
        this.BALL_SIZE = FinalData.BALL_MAX_SPEED/2 + FinalData.BALL_MIN_SPEED/2;
    }

    /**
     * 含参初始化
     * @param size 小球大小
     */
    public Ball(int size) {
        Random rd = new Random();
        //初始化常量字段
        float r,g,b;       //颜色RGB,用于获取浅色
        do{
            r = rd.nextFloat();
            g = rd.nextFloat();
            b = rd.nextFloat();
        }while((r*0.299+g*0.587+b*0.114) <= 0.5);   //色彩心理学公式
        this.color = new Color(r,g,b);

        //初始化位置，速度，大小
        this.ballX = rd.nextInt(FinalData.TABLE_WIDTH);
        this.ballY = rd.nextInt(FinalData.TABLE_HEIGHT);
        this.speedX = rd.nextInt(FinalData.BALL_MAX_SPEED) + FinalData.BALL_MIN_SPEED;
        this.speedY = rd.nextInt(FinalData.BALL_MAX_SPEED) + FinalData.BALL_MIN_SPEED;
        this.BALL_SIZE = size;
    }

    /**
     * 含参初始化
     * @param ballX 横坐标
     * @param ballY 纵坐标
     * @param speedX x速度
     * @param speedY y速度
     * @param size 小球大小
     * @param rgb rgb数值
     */
    public Ball(int ballX,int ballY,int speedX,int speedY,int size,int rgb) {
        this.ballX = ballX;
        this.ballY = ballY;
        this.speedX = speedX;
        this.speedY = speedY;
        this.BALL_SIZE = size;
        this.color = new Color(rgb);
    }

    //更新位置
    public void move() {
        if (ballX < 0 || ballX + BALL_SIZE > BouncingBallGame.TABLE_WIDTH) {
            speedX = -speedX;
        }
        if (ballY < 0 || ballY + BALL_SIZE > BouncingBallGame.TABLE_HEIGHT) {
            speedY = -speedY;
        }
        ballX += speedX;
        ballY += speedY;
    }

    //更新图像
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

/*    public void flushBallX() {
        ballX += speedX;
    }

    public void flushBallY() {
        ballY += speedY;
    }

    public void reverseBallSpeedX() {
        speedX = -speedX;
    }

    public void reverseBallSpeedY() {
        speedY = -speedY;
    }

    public Color getColor() { return color; }*/

    /**
     * get 函数
     */
    public int getBALL_SIZE() {
        return BALL_SIZE;
    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

/*    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }*/

}
