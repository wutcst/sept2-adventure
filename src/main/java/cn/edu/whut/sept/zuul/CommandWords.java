/**
 * 指令字类维护一个字符串数组以存储程序的所有合法指令
 * 提供了判断指令合法性、访问指令、输出指令的方法接口
 *
 * @author zhj
 * @version 1.0
 * */

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
        commands.put("look", new LookCommand());
        commands.put("back", new BackCommand());
        commands.put("take", new TakeCommand());
        commands.put("drop", new DropCommand());
       
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
