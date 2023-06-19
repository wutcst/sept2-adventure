/**
 *
 *处理go命令
 *
 * @author zhj
 * @version 1.0
 * */


package cn.edu.whut.sept.zuul;

import java.util.HashMap;
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
            System.out.println("去哪?");
        }

        String direction = getSecondWord();
        Room currentRoom = game.getPlayer().getCurrentRoom();


        Room nextRoom = game.getPlayer().getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("这个方向没有房间!");
        }
        else {
            if(game.getPlayer()!=null)
            {
                HashMap<String, Monster> monsters=currentRoom.getMonsters();
                if(monsters.get(direction)!=null){
                    boolean flag=game.getPlayer().fight(monsters.get(direction));
                    if(!flag){
                        game.setFail();
                        System.out.println("你被怪物击败，濒临死亡！");
                        return true;
                    }
                    System.out.println("你获得了胜利！");
                    System.out.println();
                }
                if(nextRoom.getDescription().equals("在一个有传送门的房间！")){
                    game.setWin();
                    System.out.println("你找到了传送门，逃离了这个混乱的区域");
                    return true;
                }
                game.getPlayer().enterRoom(nextRoom);
                System.out.println(nextRoom.getDescription());
            }
            else
            {
                System.out.println("玩家未初始化！");
            }
        }

        return false;
    }
}
