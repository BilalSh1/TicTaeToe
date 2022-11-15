public class Tournament {


    public static void main(String[] args) {
        RendererFactory rendFactory = new RendererFactory();
        PlayerFactory playerFactory = new PlayerFactory();
        Renderer renderer = rendFactory.buildRenderer("console");
        Player player1 = playerFactory.buildPlayer("human");
        Player player2 = playerFactory.buildPlayer("human");
        Game match = new Game(player1, player2, renderer);
        match.run();
    }
}
