/**

 * 指令类维护两个字段以保存用户输入的指令
 * 可以分别返回用户输入的指令的第一个、第二个关键字，并判断用户指令的合法性
 *
 *
 * @author zhj
 * @version 1.0
 * */

package cn.edu.whut.sept.zuul;
/**
 * 表示游戏中的一个命令
 */
public abstract class Command
{
    private String secondWord;// 第二个单词
    /**
     * 创建一个命令对象
     */
    public Command()
    {
        secondWord = null;
    }
    /**
     * 获取第二个单词
     *
     * @return 第二个单词
     */
    public String getSecondWord()
    {
        return secondWord;
    }
    /**
     * 判断是否有第二个单词
     *
     * @return 如果有第二个单词返回true，否则返回false
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }
    /**
     * 设置第二个单词
     *
     * @param secondWord 第二个单词
     */
    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }
    /**
     * 执行命令
     *
     * @param game 游戏对象
     * @return 如果命令执行完毕返回true，否则返回false
     */
    public abstract boolean execute(Game game);
}
