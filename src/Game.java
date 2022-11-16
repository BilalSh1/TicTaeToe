enum GameStatus {
    DRAW, X_WIN, O_WIN, IN_PROGRESS;
}
public class Game {
    private Player playerX;
    private Player playerO;
    private Renderer renderer;
    private int gameWinStreak = 3;
    private int boardSize = 5;

    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
    }

    public Game(Player playerX, Player playerO, int size, int winSteak, Renderer renderer){
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.gameWinStreak = winSteak;
        this.boardSize = size;
    }

    public int getWinSteak() {
        return gameWinStreak;
    }

    public Mark getWinner(GameStatus gameStatus) {
        if (gameStatus == GameStatus.DRAW) {
            return Mark.BLANK;
        } else {
            return (gameStatus == GameStatus.X_WIN ? Mark.X : Mark.O);
        }
    }

    public Mark run() {
        Board board = new Board(boardSize);
        board.winStreak = getWinSteak();
        renderer.renderBoard(board);
        while(true) {
            playerX.playTurn(board, Mark.X);
            renderer.renderBoard(board);
            if(board.gameStatus != GameStatus.IN_PROGRESS) {
                return getWinner(board.gameStatus);
            }
            playerO.playTurn(board, Mark.O);
            renderer.renderBoard(board);
            if(board.gameStatus != GameStatus.IN_PROGRESS) {
                return getWinner(board.gameStatus);

            }
        }
    }

}

