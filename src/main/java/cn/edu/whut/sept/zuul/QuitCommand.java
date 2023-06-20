/**
 *表示游戏中的“退出”命令
 *
 * @author zhj
 * @version 1.0
 * */

package cn.edu.whut.sept.zuul;

public class QuitCommand extends Command
{
    /**
     * 执行“退出”命令
     *
     * @param game 游戏对象
     * @return 如果命令执行完毕返回true，否则返回false
     */
    public boolean execute(Game game)
    {
        if(hasSecondWord()) {
            System.out.println("退出什么？");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

}
