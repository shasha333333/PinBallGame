package com.bouncingBallGame;

import com.bouncingBallGame.Ball;
import com.bouncingBallGame.BouncingBallGame;
import com.bouncingBallGame.FinalData;
import com.bouncingBallGame.Square;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyPanel extends JPanel {
    List<Ball> balls;
    Square square;
    public MyPanel(List<Ball> balls, Square square){
        this.setBackground(Color.WHITE);
        this.balls = balls;
        this.square = square;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* TODO 在这里绘制内容 */
        if (BouncingBallGame.getIsOver()) {
            //游戏结束
            g.setColor(Color.RED);
            g.setFont(new Font("Times",Font.BOLD,60));
            g.drawString("游戏结束！",20, FinalData.TABLE_WIDTH/2);
            g.drawString("存活时间"+(BouncingBallGame.getTime())/1000+"秒！",0,FinalData.TABLE_WIDTH/2+60);
        }

        else{
            //游戏中
            //绘制小球
            for (Ball ball : balls) {
                ball.draw(g);
            }
            //绘制鼠标方块
            square.draw(g);
            hideMouse();
//            g.setColor(square.getColor());
////            out.println(square.getSquareX()+" "+square.getSquareY()+" "+square.getColor()+" "+square.getSQUARE_SIZE());
//            g.fillRect(square.getSquareX(), square.getSquareY(), square.getSQUARE_SIZE(), square.getSQUARE_SIZE());
        }
    }

    //隐藏鼠标箭头
    public void hideMouse(){
        var img = FinalData.TK.createImage(this.getClass().getResource(""));
        var cur = FinalData.TK.createCustomCursor(img,new Point(0,0),"隐藏鼠标");
        setCursor(cur);
    }


}