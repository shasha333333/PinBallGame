package com.bouncingBallGame;

import com.bouncingBallGame.FinalData;

import java.awt.*;

public class Square {
    //方块的颜色
    private final Color color = Color.BLACK;

    //方块的大小
    private final int SQUARE_SIZE;

    //定义变量，记录方块的坐标
    private int squareX;
    private int squareY;

    //初始化
    public Square(){
        this.squareX = FinalData.TABLE_WIDTH/2;
        this.squareY = FinalData.TABLE_HEIGHT/2;
        this.SQUARE_SIZE = FinalData.SQUARE_SIZE;
    }

    //含参初始化
    public Square(int squareX,int squareY) {
        this.squareX = squareX;
        this.squareY = squareY;
        this.SQUARE_SIZE = FinalData.SQUARE_SIZE;
    }

    //更新图像
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(squareX, squareY, SQUARE_SIZE, SQUARE_SIZE);
    }

    /**
     * set函数
     */

    public void setSquareX(int squareX) {
        this.squareX = squareX;
    }

    public void setSquareY(int squareY) {
        this.squareY = squareY;
    }

    /**
     * get函数
     * */

    public Color getColor() { return color; }

    public int getSQUARE_SIZE() {
        return SQUARE_SIZE;
    }

    public int getSquareX() {
        return squareX;
    }

    public int getSquareY() {
        return squareY;
    }

}
