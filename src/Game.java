enum GameStatus {
    DRAW, X_WIN, O_WIN, IN_PROGRESS;
}


public class Game {
    private Player playerX;
    private Player playerO;
    private Renderer renderer;

    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
    }

    public Game(Player playerX, Player playerO, int size, int winSteak, Renderer renderer){

    }

    public int getWinSteak() {
        return Board.WinStreak;
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
        renderer.renderBoard(board);
        while(true) {
            playerX.playTurn(board, Mark.X);
            renderer.renderBoard(board);
            if(Board.boardStatus != GameStatus.IN_PROGRESS) {
                return getWinner();

            }
            playerO.playTurn(board, Mark.O);
            renderer.renderBoard(board);
            if(Board.boardStatus != GameStatus.IN_PROGRESS) {
                return getWinner();

            }
        }
    }
}

