/**
 *
 *处理go命令
 *
 * @author zhj
 * @version 1.0
 * */


package cn.edu.whut.sept.zuul;
/**
 * 表示游戏中的“前进”命令
 */
public class GoCommand extends Command
{
    /**
     * 执行“前进”命令
     *
     * @param game 游戏对象
     * @return 如果命令执行完毕返回true，否则返回false
     */
    @Override
    public boolean execute(Game game)
    {
        if(!hasSecondWord()) {
            System.out.println("Go where?");
        }

        String direction = getSecondWord();
        Room currentRoom = game.getCurrentRoom();

        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            game.setCurrentRoom(nextRoom);
            System.out.println(nextRoom.getLongDescription());
        }

        return false;
    }
}
