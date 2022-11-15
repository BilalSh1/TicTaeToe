public class Tournament {
    private int rounds;
    private Renderer renderer;
    private Player[] players = new Player[2];
    private int currPlayerIndex = 0;

    public Tournament(int rounds, Renderer renderer, Player[] players) {
        this.rounds = rounds;
        this.renderer = renderer;
        System.arraycopy(players, 0, this.players, 0, players.length);
    }

    public int[] playTournament(int size, int winStreak, String[] playerNames){
        int[] results = new int[3];
        for (int round=0;round<rounds;round++) {
            Game match = new Game(players[currPlayerIndex], players[(currPlayerIndex+1)%2], renderer);
            Mark res = match.run();
            switch (res){
                case X:
                    results[currPlayerIndex]++;
                    break;
                case O:
                    results[(currPlayerIndex+1)%2]++;
                    break;
                default:
                    results[2]++;
            }
            currPlayerIndex = (currPlayerIndex + 1) % 2;
        }
        return results;
    }

    public static void main(String[] args) {
        if(!(2 <= Integer.parseInt(args[2]) &&  Integer.parseInt(args[2]) < Integer.parseInt(args[1]) &&
                Integer.parseInt(args[1]) <= 9)){
            System.out.println("Enter valid board size and win streak! \nThey must be in range of [2, 9]");
            return;
        }
        RendererFactory rendFactory = new RendererFactory();
        PlayerFactory playerFactory = new PlayerFactory();
        Renderer renderer = rendFactory.buildRenderer(args[3].toLowerCase());
        if (renderer == null){
            System.err.println("Choose a renderer and try again \nThe renderer: [console, none]");
            return;
        }
        Player player1 = playerFactory.buildPlayer(args[4].toLowerCase());
        Player player2 = playerFactory.buildPlayer(args[5].toLowerCase());
        if (player1 == null || player2 == null){
            System.err.println("Choose a player and try again \nThe player: [human, clever, whatever, genius]");
            return;
        }
        Player[] players = {player1, player2};
        Tournament tournament = new Tournament(Integer.parseInt(args[0]), renderer, players);
        int[] results = tournament.playTournament(Integer.parseInt(args[1]),
                Integer.parseInt(args[2]), new String[] {"Bilal", "HI"});
        System.out.println(String.format("######### Results #########\n" +
                        "Player 1, %s won: %d rounds\n" +
                        "Player 2, %s won: %d rounds\n" +
                        "Ties:%d\n",
                args[4], results[0], args[5], results[1], results[2]));
    }
}
