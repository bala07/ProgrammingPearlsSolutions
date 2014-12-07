import HelperClasses.OutputHelpers;

/**
 * Created by Balasubramanian on 5/21/14.
 */
public class LEDDisplay
{
    private int rows = 11;
    private int columns = 6;

    private char[][] board = null;

    private final int TOP_ROW = 0;
    private final int MIDDLE_ROW = 1;
    private final int BOTTOM_ROW = 2;

    private final int TOP_LEFT = 3;
    private final int BOTTOM_LEFT = 4;
    private final int TOP_RIGHT = 5;
    private final int BOTTOM_RIGHT = 6;

    private char TAB = '|';
    private char HYPHEN = '-';

    public LEDDisplay(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;

        board = new char[rows][columns];
    }

    public void display(int digit)
    {
        clearBoard();

        switch(digit)
        {
            case 0:
                drawZero();
                break;
            case 1:
                drawOne();
                break;
            case 2:
                drawTwo();
                break;
            case 3:
                drawThree();
                break;
            case 4:
                drawFour();
                break;
            case 5:
                drawFive();
                break;
            case 6:
                drawSix();
                break;
            case 7:
                drawSeven();
                break;
            case 8:
                drawEight();
                break;
            case 9:
                drawNine();
                break;
        }

        printBoard();
        OutputHelpers.printSequence('*', 10);
    }

    private void drawZero()
    {
        fill(TOP_ROW);
        fill(BOTTOM_ROW);

        fill(TOP_LEFT);
        fill(BOTTOM_LEFT);

        fill(TOP_RIGHT);
        fill(BOTTOM_RIGHT);
    }

    private void drawOne()
    {
        fill(TOP_RIGHT);
        fill(BOTTOM_RIGHT);
    }

    private void drawTwo()
    {
        fill(TOP_ROW);
        fill(MIDDLE_ROW);
        fill(BOTTOM_ROW);

        fill(TOP_RIGHT);
        fill(BOTTOM_LEFT);
    }

    private void drawThree()
    {
        fill(TOP_ROW);
        fill(MIDDLE_ROW);
        fill(BOTTOM_ROW);

        fill(TOP_RIGHT);
        fill(BOTTOM_RIGHT);
    }

    private void drawFour()
    {
        fill(MIDDLE_ROW);

        fill(TOP_LEFT);
        fill(TOP_RIGHT);
        fill(BOTTOM_RIGHT);
    }

    private void drawFive()
    {
        fill(TOP_ROW);
        fill(MIDDLE_ROW);
        fill(BOTTOM_ROW);

        fill(TOP_LEFT);
        fill(BOTTOM_RIGHT);
    }

    private void drawSix()
    {
        fill(TOP_ROW);
        fill(MIDDLE_ROW);
        fill(BOTTOM_ROW);

        fill(TOP_LEFT);
        fill(BOTTOM_LEFT);
        fill(BOTTOM_RIGHT);
    }

    private void drawSeven()
    {
        fill(TOP_ROW);

        fill(TOP_RIGHT);
        fill(BOTTOM_RIGHT);
    }

    private void drawEight()
    {
        fill(TOP_ROW);
        fill(MIDDLE_ROW);
        fill(BOTTOM_ROW);

        fill(TOP_LEFT);
        fill(BOTTOM_LEFT);
        fill(TOP_RIGHT);
        fill(BOTTOM_RIGHT);
    }

    private void drawNine()
    {
        fill(TOP_ROW);
        fill(MIDDLE_ROW);

        fill(TOP_LEFT);
        fill(TOP_RIGHT);
        fill(BOTTOM_RIGHT);
    }

    private void fill(int index)
    {
        if(index < 3)
        {
            fillRow(index);
        }
        else
        {
            fillColumn(index);
        }
    }

    private void fillRow(int index)
    {
        int rowIndex = 0;

        if(index == MIDDLE_ROW)
        {
            rowIndex = rows/2;
        }
        else if(index == BOTTOM_ROW)
        {
            rowIndex = rows-1;
        }

        for(int column = 1; column < columns-1; ++column)
        {
            board[rowIndex][column] = HYPHEN;
        }
    }

    private void fillColumn(int index)
    {
        int columnIndex = (index == TOP_LEFT || index == BOTTOM_LEFT) ? 0 : columns-1;

        int startRow = (index == TOP_LEFT || index == TOP_RIGHT ) ? 1 : rows/2 + 1;
        int endRow = (index == TOP_LEFT || index == TOP_RIGHT ) ? rows/2 - 1 : (rows - 2);

        for(int row = startRow; row <= endRow; ++row)
        {
            board[row][columnIndex] = TAB;
        }
    }

    private void clearBoard()
    {
        for(int row = 0; row < rows; ++row)
        {
            for(int col = 0; col < columns; ++col)
            {
                board[row][col] = ' ';
            }
        }
    }

    private void printBoard()
    {
        for(int row = 0; row < rows; ++row)
        {
            for(int col = 0; col < columns; ++col)
            {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        LEDDisplay ledDisplay = new LEDDisplay(11, 6);

        ledDisplay.display(0);
        ledDisplay.display(1);
        ledDisplay.display(2);
        ledDisplay.display(3);
        ledDisplay.display(4);
        ledDisplay.display(5);
        ledDisplay.display(6);
        ledDisplay.display(7);
        ledDisplay.display(8);
        ledDisplay.display(9);
    }

}
