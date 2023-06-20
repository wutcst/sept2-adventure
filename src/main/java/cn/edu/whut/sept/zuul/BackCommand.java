package cn.edu.whut.sept.zuul;

public class BackCommand extends Command {

    @Override
    public boolean execute(Game game) {
        if (Player.getPlayer() != null) {
            Player.getPlayer().goBack();
        }
        return false;
    }

}