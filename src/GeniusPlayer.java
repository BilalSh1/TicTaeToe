public class GeniusPlayer implements Player {
    private static int startFromTheBeginning = 0;

    @Override
    public void playTurn(Board board, Mark mark) {
        if (startFromTheBeginning == 0) {
            addMarkFromTheBeginning(board, mark);
            startFromTheBeginning = (startFromTheBeginning + 1) % 2;
            return;
        }
        fillColumns(board, mark);
        startFromTheBeginning = (startFromTheBeginning + 1) % 3;
    }

    private void addMarkFromTheBeginning(Board board, Mark mark) {
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                if (board.getMark(row, col) == Mark.BLANK) {
                    board.putMark(mark, row, col);
                    return;
                }
            }
        }
    }

    private void fillColumns(Board board, Mark mark) {
        for (int col = board.getSize() - 1; col >= 0; col--) {
            for (int row = board.getSize() - 1; row >= 0; row--) {
                if (board.getMark(row, col) == Mark.BLANK) {
                    board.putMark(mark, row, col);
                    return;
                }
            }
        }
    }
}