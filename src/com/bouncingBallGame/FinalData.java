package com.bouncingBallGame;

import java.awt.*;

public class FinalData {
    public static final int BALL_MAX_SPEED = 10;                            //小球在x和y轴的最大速度
    public static final int BALL_MIN_SPEED = 3;                             //小球在x和y轴的最小速度
    public static final int BALL_NUM_MAX = 15;                                 //小球最大数
    public static final int BALL_NUM_MIN = 1;                                  //小球最小数
    public static final int BALL_SIZE_MAX = 33;                                 //小球最大直径
    public static final int BALL_SIZE_MIN = 3;                                 //小球最小直径

    public static final int SQUARE_SIZE = 16;                               //方块边长

    public static final int TABLE_WIDTH = 500;                              //桌面宽度
    public static final int TABLE_HEIGHT = 500;                             //桌面高度

    public static final int DELAY = 40;                                     //计时器时延

    public static final Dimension SCREEN_SIZE;                              //屏幕尺寸
    public static final Toolkit TK = Toolkit.getDefaultToolkit();           //默认工具

    //静态初始化块
    static {
        SCREEN_SIZE = TK.getScreenSize();
    }
}
