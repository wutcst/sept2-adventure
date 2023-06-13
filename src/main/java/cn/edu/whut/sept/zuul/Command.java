/**
 * 指令类维护两个字段以保存用户输入的指令
 * 可以分别返回用户输入的指令的第一个、第二个关键字，并判断用户指令的合法性
 *
 *
 * @author zhj
 * @version 1.0
 * */


package cn.edu.whut.sept.zuul;

public abstract class Command
{
    private String secondWord;

    public Command()
    {
        secondWord = null;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean hasSecondWord()
    {
        return secondWord != null;
    }

    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }

    public abstract boolean execute(Game game);
}
