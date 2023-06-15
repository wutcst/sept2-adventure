package cn.edu.whut.sept.zuul;

public class BackCommand extends Command {

    @Override
    public boolean execute(Game game) {
        if(game.getPlayer()!=null)
        {
            game.getPlayer().goBack();
        }
        return false;
    }
}