
public class Board {
    private int size = 4;
    public int winStreak = 3;
    public GameStatus gameStatus = GameStatus.IN_PROGRESS;
    private Mark[][] board;
    private int filled_cells;

    public Board(){
        board = new Mark[size][size];
        filled_cells = 0;
        for(int i = 0; i< size; i++) {
            for (int j = 0; j< size; j++) {
                board[i][j] = Mark.BLANK;
            }
        }
    }

    public Board(int size) {
        this.size = size;
        board = new Mark[size][size];
        filled_cells = 0;
        for(int i = 0; i< size; i++) {
            for (int j = 0; j< size; j++) {
                board[i][j] = Mark.BLANK;
            }
        }

    }

    public int getSize() {
        return size;
    }

    public Mark[][] getBoard() {
        return this.board;
    }

    public boolean putMark(Mark mark, int row, int col) {
        if (row<0 || row>= size || col<0 || col>= size || board[row][col] != Mark.BLANK || filled_cells == size*size) {
            return false;
        }
        board[row][col] = mark;
        filled_cells++;
        gameStatus = checkBoardStatus(row, col, mark);
        return true;
    }

    public Mark getMark(int row, int col){
        if (row < size && col < size) {
            return this.board[row][col];
        }
        return Mark.BLANK;
    }

    private GameStatus checkBoardStatus(int row, int col, Mark mark) {
        if(horizontalStreak(row, col, mark) >= winStreak || // Check horizontal streak
                verticalStreak(row, col, mark) >= winStreak || // Check vertical streak
                leftRightDiagonalStreak(row, col, mark) >= winStreak || // Check left_right diagonal streak
                rightLeftDiagonalStreak(row, col, mark) >= winStreak // Check right_left diagonal streak
        ) {
            return (mark == Mark.O ? GameStatus.O_WIN : GameStatus.X_WIN);
        }
        return (filled_cells == size * size ? GameStatus.DRAW : GameStatus.IN_PROGRESS);
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
        while(row< size && row>=0 && col< size && col>=0 && board[row][col] == mark) {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    }
}
