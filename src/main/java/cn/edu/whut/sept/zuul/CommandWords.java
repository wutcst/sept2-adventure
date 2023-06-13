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

public class CommandWords
{
    private HashMap<String, Command> commands;

    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("help", new HelpCommand(this));
        commands.put("quit", new QuitCommand());
    }

    public Command get(String word)
    {
        return (Command)commands.get(word);
    }

    public void showAll()
    {
        for(Iterator i = commands.keySet().iterator(); i.hasNext(); ) {
            System.out.print(i.next() + "  ");
        }
        System.out.println();
    }
}
