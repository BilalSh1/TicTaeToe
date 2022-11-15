


public class Board {

    public static final int SIZE = 4;
    public static final int WIN_STREAK = 3;

    public static GameStatus boardStatus = GameStatus.IN_PROGRESS;
    private Mark[][] board;
    private int filled_cells;

    public Board(){
        board = new Mark[SIZE][SIZE];
        filled_cells = 0;
        for(int i=0; i<SIZE;i++) {
            for (int j=0; j<SIZE;j++) {
                board[i][j] = Mark.BLANK;
            }
        }

    }

    public boolean putMark(Mark mark, int row, int col){
        if (row<0 || row>=SIZE || col<0 || col>=SIZE || board[row][col] != Mark.BLANK) {
            return false;
        }
        board[row][col] = mark;
        filled_cells++;
        Board.boardStatus = checkGameStatus(row, col, mark);
        return true;
    }

    public Mark getMark(int row, int col){
        return this.board[row][col];
    }

    private GameStatus checkGameStatus(int row, int col, Mark mark) {
        if(horizontalStreak(row, col, mark) >= WIN_STREAK || // Check horizontal streak
                verticalStreak(row, col, mark) >= WIN_STREAK || // Check vertical streak
                leftRightDiagonalStreak(row, col, mark) >= WIN_STREAK || // Check left_right diagonal streak
                rightLeftDiagonalStreak(row, col, mark) >= WIN_STREAK // Check right_left diagonal streak
        ) {
            return (mark == Mark.O ? GameStatus.O_WIN : GameStatus.X_WIN);
        }
        return (filled_cells == SIZE*SIZE ? GameStatus.DRAW : GameStatus.IN_PROGRESS);
    }

    private int rightLeftDiagonalStreak(int row, int col, Mark mark) {
        return (countMarkInDirection(row, col, 1, -1, mark) +
                countMarkInDirection(row, col, -1, 1, mark)) - 1;
    }

    private int leftRightDiagonalStreak(int row, int col, Mark mark) {
        return (countMarkInDirection(row, col, 1, 1, mark) +
                countMarkInDirection(row, col, -1, -1, mark)) - 1;
    }

    private int verticalStreak(int row, int col, Mark mark) {
        return (countMarkInDirection(row, col, -1, 0, mark) +
                countMarkInDirection(row, col, 1, 0, mark)) - 1;
    }

    private int horizontalStreak(int row, int col, Mark mark) {
        return (countMarkInDirection(row, col, 0, -1, mark) +
                countMarkInDirection(row, col, 0, 1, mark)) - 1;
    }

    private int countMarkInDirection(int row, int col, int rowDelta, int colDelta, Mark mark) {
        int count = 0;
        while(row<SIZE && row>=0 && col<SIZE && col>=0 && board[row][col] == mark) {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    }
}
