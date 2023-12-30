package com.bouncingBallGame.ui;

import com.bouncingBallGame.BouncingBallGame;
import com.bouncingBallGame.FinalData;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏开始界面
 */
public class MenuJFrame extends JFrame {
    /**
     * 类常量
     */
    private static final Dimension SCREEN_SIZE = FinalData.SCREEN_SIZE;
    private static final int Min = SCREEN_SIZE.width/50;         //长与宽的单位

    public MenuJFrame(){
        super();
        initJFrame();
        initComponent();
        this.setVisible(true);
    }

    /**
     * 窗口初设定
     */
    private void initJFrame(){
        setTitle("多线程弹球");
        setSize(13*Min+(Min>>1),18*Min+(Min>>1));
        setLayout(null);
        setLocation((SCREEN_SIZE.width-getWidth())>>1,(SCREEN_SIZE.height-getHeight())>>1);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 组件初设定
     */
    private void initComponent(){
        //游戏标题
        var labelTitle = new JLabel("多线程弹球");
        labelTitle.setBounds(Min,Min,11*Min,3*Min);
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setFont(new Font("楷体",Font.BOLD,50));
        labelTitle.setForeground(Color.PINK);
        add(labelTitle);
//        labelTitle.setBorder(border);

        //开始游戏按钮
        var buttonStart = new JButton("开始游戏");
        buttonStart.setBounds(3*Min,5*Min,7*Min,2*Min);
        buttonStart.setFont(new Font("宋体",Font.PLAIN,30));
        add(buttonStart);

        //小球数滚动条定义
        var sliderBallNum = new JSlider(FinalData.BALL_NUM_MIN,FinalData.BALL_NUM_MAX);
        sliderBallNum.setBounds(3*Min,10*Min,7*Min,Min);
        add(sliderBallNum);

        //小球大小滚动条定义
        var sliderBallSize = new JSlider(FinalData.BALL_SIZE_MIN,FinalData.BALL_SIZE_MAX);
        sliderBallSize.setBounds(3*Min,14*Min,7*Min,Min);
        add(sliderBallSize);

        //小球数展示框定义
        var labelBallNum = new JLabel();
        labelBallNum.setText("小球数:"+sliderBallNum.getValue());
        labelBallNum.setBounds(4*Min,9*Min,5*Min,Min);
        labelBallNum.setFont(new Font("宋体",Font.PLAIN,30));
        labelBallNum.setHorizontalAlignment(JLabel.CENTER);
        add(labelBallNum);

        //小球大小展示框定义
        var labelBallSize = new JLabel();
        labelBallSize.setText("小球大小:"+sliderBallSize.getValue());
        labelBallSize.setBounds(4*Min,13*Min,6*Min,Min);
        labelBallSize.setFont(new Font("宋体",Font.PLAIN,30));
        labelBallSize.setHorizontalAlignment(JLabel.CENTER);
        add(labelBallSize);

        //监听器
        sliderBallNum.addChangeListener(e -> {
            labelBallNum.setText("小球数:"+sliderBallNum.getValue());
        });
        sliderBallSize.addChangeListener(e -> {
            labelBallSize.setText("小球大小:"+sliderBallSize.getValue());
        });

        buttonStart.addActionListener(e ->{
//            new JFrame("测试").setVisible(true);
            new BouncingBallGame(sliderBallNum.getValue(),sliderBallSize.getValue()).init();
            this.setVisible(false);
        });
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        new MenuJFrame();
    }
}
