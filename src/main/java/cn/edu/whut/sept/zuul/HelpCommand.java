/**
 *表示游戏中的“帮助”命令
 *
 * @author zhj
 * @version 1.0
 * */

package cn.edu.whut.sept.zuul;

public class HelpCommand extends Command
{

    private final CommandWords commandWords;

    /**
     * 创建“帮助”命令对象
     *
     * @param words 命令词汇表对象
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
        System.out.println("你迷路了，你独自一人，你在徘徊");
        System.out.println("在大学周围。");
        System.out.println();
        System.out.println("你的命令词是：");
        commandWords.showAll();
        return false;
    }

}
