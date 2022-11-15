public class PlayerFactory {
    public PlayerFactory() {

    }

    public Player buildPlayer(String playerType) {
        if(playerType.equals("human")) {
            return new HumanPlayer();
        }
        return null;
    }
}
