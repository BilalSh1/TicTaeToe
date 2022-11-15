public class PlayerFactory {
    public PlayerFactory() {

    }

    public Player buildPlayer(String playerType) {
        switch(playerType){
            case "human":
                return new HumanPlayer();
            case "whatever":
                return new WhateverPlayer();
            case "clever":
                return new CleverPlayer();
            case "genius":
                return new GeniusPlayer();
            default:
                return null;
        }
    }
}
