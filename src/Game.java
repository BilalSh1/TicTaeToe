enum GameStatus {
    DRAW, X_WIN, O_WIN, IN_PROGRESS;
}


public class Game {
    Player playerX;
    Player playerO;
    Renderer renderer;

    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
    }

    public Mark getWinner() {
        if (Board.boardStatus == GameStatus.DRAW) {
            return Mark.BLANK;
        } else {
            return (Board.boardStatus == GameStatus.X_WIN ? Mark.X : Mark.O);
        }
    }

    public Mark run() {
        Board board = new Board();
        Renderer rend = new Renderer();
        rend.renderBoard(board);
        while(true) {
            playerX.playTurn(board, Mark.X);
            rend.renderBoard(board);
            if(Board.boardStatus != GameStatus.IN_PROGRESS) {
                System.out.println(Board.boardStatus);
                return getWinner();

            }
            playerO.playTurn(board, Mark.O);
            rend.renderBoard(board);
            if(Board.boardStatus != GameStatus.IN_PROGRESS) {
                System.out.println(Board.boardStatus);
                return getWinner();

            }
        }
    }

    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        Player player1 = new Player();
        Player player2 = new Player();
        Game match = new Game(player1, player2, renderer);
        match.run();
        }
    }

