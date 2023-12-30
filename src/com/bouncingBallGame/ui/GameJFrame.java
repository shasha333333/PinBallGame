package com.bouncingBallGame.ui;

import com.bouncingBallGame.FinalData;

import javax.swing.*;

public class GameJFrame extends JFrame {

    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //使界面可见
        this.setVisible(true);
    }

    private void initJMenuBar() {
        //创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单下的两个选项的对象 （功能 ，关于我们）
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

        //创建选项下的条目对象
        JMenuItem setBallNum = new JMenuItem("设置小球数量");
        JMenuItem setBallSpeed = new JMenuItem("设置小球初速度");
        JMenuItem setBallDiameter = new JMenuItem("设置小球直径");

        JMenuItem accountItem = new JMenuItem("公众号");

        //将条目添加到选项中
        functionMenu.add(setBallNum);
        functionMenu.add(setBallDiameter);
        functionMenu.add(setBallSpeed);

        aboutMenu.add(accountItem);

        //将选项添加到菜单中
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);

        //给界面添加菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置宽高
        this.setSize(FinalData.TABLE_WIDTH,FinalData.TABLE_HEIGHT);
        //设置标题
        this.setTitle("弹球游戏 1.0");
        //设置居中
        this.setLocationRelativeTo(null);
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GameJFrame();
    }
}
