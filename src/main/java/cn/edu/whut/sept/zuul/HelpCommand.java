/**
 *表示游戏中的“帮助”命令
 *
 * @author zhj
 * @version 1.0
 * */

package cn.edu.whut.sept.zuul;

public class HelpCommand extends Command
{

    private CommandWords commandWords;

    /**
     * 创建“帮助”命令对象
     *
     * @param commandWords 命令词汇表对象
     */
    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }

    /**
     * 执行“帮助”命令
     *
     * @param game 游戏对象
     * @return 如果命令执行完毕返回true，否则返回false
     */
    public boolean execute(Game game)
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        commandWords.showAll();
        return false;
    }
}
