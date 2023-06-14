/**
 * @author  xs
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.HashMap;
import java.util.Iterator;
/**
 * 表示游戏中的所有命令词汇
 */
public class CommandWords
{
    private HashMap<String, Command> commands;
    /**
     * 创建CommandWords对象并初始化命令词汇表
     */
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("help", new HelpCommand(this));
        commands.put("quit", new QuitCommand());
    }
    /**
     * 获取指定命令词汇对应的命令对象
     *
     * @param word 命令词汇
     * @return 对应的命令对象，如果没有找到返回null
     */
    public Command get(String word)
    {
        return (Command)commands.get(word);
    }
    /**
     * 显示所有命令词汇
     */
    public void showAll()
    {
        for(Iterator i = commands.keySet().iterator(); i.hasNext(); ) {
            System.out.print(i.next() + "  ");
        }
        System.out.println();
    }
}
