/**
 * 该类是“World-of-Zuul”应用程序的主方法入口。
 * Main类的实例将创建并初始化game类，并调用game中的play方法，使游戏进入初始界面。
 *
 * @author zhj
 * @version 1.0
 */


package cn.edu.whut.sept.zuul;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
