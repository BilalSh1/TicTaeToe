import java.util.Scanner;

public class HumanPlayer implements Player {
    public HumanPlayer(){}

    @Override
    public void playTurn(Board board, Mark mark) {
        Scanner scanner = new Scanner(System.in);
        int coordinates = Integer.parseInt(scanner.nextLine());
        while(!(coordinates > 0 && ((int)coordinates / 10) <= board.getSize()&& (coordinates % 10) <= board.getSize() &&
                board.getMark(((int)(coordinates / 10)) - 1, (coordinates % 10) - 1) == Mark.BLANK)) {
            System.out.println("Invalid coordinates, type again: ");
            coordinates = Integer.parseInt(scanner.nextLine());
        }
        int row = ((int)(coordinates / 10)) - 1;
        int col = (coordinates % 10) - 1;
        board.putMark(mark, row, col);
    }
}
