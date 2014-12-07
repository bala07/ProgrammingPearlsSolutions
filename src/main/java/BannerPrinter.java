import HelperClasses.OutputHelpers;

/**
 * Created by Balasubramanian on 5/7/14.
 */
public class BannerPrinter
{
    private final int rows = 5;

    private final int columns = 5;

    private char marker = '*';

    private char[][] banner = new char[rows][columns];

    BannerFiller bannerFiller = new BannerFiller(marker);

    public BannerPrinter(char marker)
    {
        this.marker = marker;
        clearBanner();
    }

    public void printBanner(char ch)
    {
        clearBanner();
        OutputHelpers.printDashes(rows + 10);

        switch(ch)
        {
            case 'A' :
            case 'a' :
                bannerFiller.fillBannerForA();
                break;

            case 'B' :
            case 'b' :
                bannerFiller.fillBannerForB();
                break;

            case 'C' :
            case 'c' :
                bannerFiller.fillBannerForC();
                break;

            case 'D' :
            case 'd' :
                bannerFiller.fillBannerForD();
                break;

            case 'E' :
            case 'e' :
                bannerFiller.fillBannerForE();
                break;

            case 'F' :
            case 'f' :
                bannerFiller.fillBannerForF();
                break;

            case 'G' :
            case 'g' :
                bannerFiller.fillBannerForG();
                break;

            case 'H' :
            case 'h' :
                bannerFiller.fillBannerForH();
                break;

            case 'I' :
            case 'i' :
                bannerFiller.fillBannerForI();
                break;

            case 'J' :
            case 'j' :
                bannerFiller.fillBannerForJ();
                break;

            case 'K' :
            case 'k' :
                bannerFiller.fillBannerForK();
                break;

            case 'L' :
            case 'l' :
                bannerFiller.fillBannerForL();
                break;

            case 'M' :
            case 'm' :
                bannerFiller.fillBannerForM();
                break;

            case 'N' :
            case 'n' :
                bannerFiller.fillBannerForN();
                break;

            case 'O' :
            case 'o' :
                bannerFiller.fillBannerForO();
                break;

            case 'P' :
            case 'p' :
                bannerFiller.fillBannerForP();
                break;

            case 'Q' :
            case 'q' :
                bannerFiller.fillBannerForQ();
                break;

            case 'R' :
            case 'r' :
                bannerFiller.fillBannerForR();
                break;

            case 'S' :
            case 's' :
                bannerFiller.fillBannerForS();
                break;

            case 'T' :
            case 't' :
                bannerFiller.fillBannerForT();
                break;

            case 'U' :
            case 'u' :
                bannerFiller.fillBannerForU();
                break;

            case 'V' :
            case 'v' :
                bannerFiller.fillBannerForV();
                break;

            case 'W' :
            case 'w' :
                bannerFiller.fillBannerForW();
                break;

            case 'X' :
            case 'x' :
                bannerFiller.fillBannerForX();
                break;

            case 'Y' :
            case 'y' :
                bannerFiller.fillBannerForY();
                break;

            case 'Z' :
            case 'z' :
                bannerFiller.fillBannerForZ();
                break;
        }

        OutputHelpers.printCharMatrix(banner);

        OutputHelpers.printDashes(rows + 10);
    }

    private void clearBanner()
    {
        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < columns; ++j)
            {
                banner[i][j] = ' ';
            }
        }
    }

    public static void main(String[] args)
    {
        BannerPrinter tester = new BannerPrinter('*');

        tester.printBanner('A');
        tester.printBanner('B');
        tester.printBanner('C');
        tester.printBanner('D');
        tester.printBanner('E');
        tester.printBanner('F');
        tester.printBanner('G');
        tester.printBanner('H');
        tester.printBanner('I');
        tester.printBanner('J');
        tester.printBanner('K');
        tester.printBanner('L');
        tester.printBanner('M');
        tester.printBanner('N');
        tester.printBanner('O');
        tester.printBanner('P');
        tester.printBanner('Q');
        tester.printBanner('R');
        tester.printBanner('S');
        tester.printBanner('T');
        tester.printBanner('U');
        tester.printBanner('V');
        tester.printBanner('W');
        tester.printBanner('X');
        tester.printBanner('Y');
        tester.printBanner('Z');
    }

    public class BannerFiller
    {

        private char marker;

        BannerFiller(char marker)
        {
            this.marker = marker;
        }

        private void fillBannerForA()
        {
            fillRow(0);
            fillRow((rows-1)/2);

            fillColumn(0);
            fillColumn(columns - 1);
        }

        private void fillBannerForB()
        {
            fillRow(0);
            fillRow((rows-1)/2, 1, columns-1);
            fillRow(rows-1);

            fillColumn(1);
            fillColumn(columns - 1);
        }

        private void fillBannerForC()
        {
            fillRow(0);
            fillRow(rows-1);

            fillColumn(0);
        }

        private void fillBannerForD()
        {
            fillRow(0);
            fillRow(rows-1);

            fillColumn(1);
            fillColumn(columns-1);
        }

        private void fillBannerForE()
        {
            fillRow(0);
            fillRow((rows-1)/2, 0, (columns-1)/2 + 1);
            fillRow(rows-1);

            fillColumn(0);
        }

        private void fillBannerForF()
        {
            fillRow(0);
            fillRow((rows-1)/2, 0, (columns-1)/2 + 1);

            fillColumn(0);
        }

        private void fillBannerForG()
        {
            fillRow(0);
            fillRow(rows-1);
            fillRow((rows-1)/2, (columns-1)/2, columns-1);

            fillColumn(0);
            fillColumn(columns-1, (rows-1)/2, rows-1);
        }

        private void fillBannerForH()
        {
            fillRow((rows-1)/2);

            fillColumn(0);
            fillColumn(columns-1);
        }

        private void fillBannerForI()
        {
            fillRow(0);
            fillRow(rows-1);

            fillColumn(columns/2);
        }

        private void fillBannerForJ()
        {
            fillRow(0);
            fillRow(rows-1, 0, (columns-1)/2);

            fillColumn((columns-1)/2);
        }

        private void fillBannerForK()
        {
            fillRow((rows-1)/2, 0, 1);

            fillColumn(0);

            fillFullDiagonal((rows-1) / 2, 1, -1, 1);
            fillFullDiagonal((rows-1) / 2, 1, 1, 1);
        }

        private void fillBannerForL()
        {
            fillRow(rows-1);

            fillColumn(0);
        }

        private void fillBannerForM()
        {
            fillColumn(0);
            fillColumn(columns-1);

            fillPartialDiagonal(0, 0, (rows-1)/2, (columns-1)/2);
            fillPartialDiagonal(0, columns-1, (rows-1)/2, (columns-1)/2);

        }

        private void fillBannerForN()
        {
            fillColumn(0);
            fillColumn(columns-1);

            fillFullDiagonal(0, 0, 1, 1);
        }

        private void fillBannerForO()
        {
            fillRow(0);
            fillRow(rows-1);

            fillColumn(0);
            fillColumn(columns-1);

        }

        private void fillBannerForP()
        {
            fillRow(0);
            fillRow((rows-1)/2);

            fillColumn(0);
            fillColumn(columns-1, 0, (rows-1)/2);
        }

        private void fillBannerForQ()
        {
            fillRow(0, 0, columns-2);
            fillRow(rows-1);

            fillColumn(0);
            fillColumn(columns-2);

        }

        private void fillBannerForR()
        {
            fillRow(0);
            fillRow((rows-1)/2);

            fillColumn(0);
            fillColumn(columns-1, 0, (rows-1)/2);

            fillPartialDiagonal((rows-1)/2, (columns-1)/2, rows-1, columns-1);
        }

        private void fillBannerForS()
        {
            fillRow(0);
            fillRow((rows-1)/2);
            fillRow(rows-1);

            fillColumn(0, 0, (rows-1)/2);
            fillColumn(columns-1, (rows-1)/2, rows-1);
        }

        private void fillBannerForT()
        {
            fillRow(0);

            fillColumn((columns-1)/2);
        }

        private void fillBannerForU()
        {
            fillRow(rows-1);

            fillColumn(0);
            fillColumn(columns-1);

        }

        private void fillBannerForV()
        {
            fillColumn(0, 0, (rows-1)/2);
            fillColumn(columns-1, 0, (rows-1)/2);

            fillPartialDiagonal((rows-1)/2, 0, rows-1, (columns-1)/2);
            fillPartialDiagonal((rows-1)/2, columns-1, rows-1, (columns-1)/2);
        }

        private void fillBannerForW()
        {
            fillColumn(0);
            fillColumn(columns-1);

            fillPartialDiagonal(rows-1, 0, (rows-1)/2, (columns-1)/2);
            fillPartialDiagonal(rows-1, columns-1, (rows-1)/2, (columns-1)/2);
        }

        private void fillBannerForX()
        {
            fillFullDiagonal(0, 0, 1, 1);
            fillFullDiagonal(0, columns-1, 1, -1);
        }

        private void fillBannerForY()
        {
            fillColumn((columns-1)/2, (rows-1)/2, rows-1);

            fillPartialDiagonal(0, 0, (rows-1)/2, (columns-1)/2);
            fillPartialDiagonal(0, columns-1, (rows-1)/2, (columns-1)/2);
        }

        private void fillBannerForZ()
        {
            fillRow(0);
            fillRow(rows-1);

            fillFullDiagonal(0, columns-1, 1, -1);
        }

        private void fillRow(int rowIndex)
        {
            for(int col = 0; col < columns; ++col)
            {
                banner[rowIndex][col] = marker;
            }
        }

        private void fillRow(int rowIndex, int startColumn, int endColumn)
        {
            for(int col = startColumn; col <= endColumn; ++col)
            {
                banner[rowIndex][col] = marker;
            }
        }

        private void fillColumn(int columnIndex)
        {
            for(int row = 0; row < rows; ++row)
            {
                banner[row][columnIndex] = marker;
            }
        }

        private void fillColumn(int columnIndex, int startRow, int endRow)
        {
            for(int row = startRow; row <= endRow; ++row)
            {
                banner[row][columnIndex] = marker;
            }
        }

        private void fillFullDiagonal(int rowIndex, int colIndex, int rowIncrement, int colIncrement)
        {
            int row = rowIndex, col = colIndex;

            while(row >=0 && row < rows && col >= 0 && col < columns)
            {
                banner[row][col] = marker;

                row += rowIncrement;
                col += colIncrement;
            }
        }

        private void fillPartialDiagonal(int startRowIndex, int startColIndex, int endRowIndex, int endColIndex)
        {
            int rowIncrement = (startRowIndex < endRowIndex) ? 1 : -1;
            int colIncrement = (startColIndex < endColIndex) ? 1 : -1;

            int row = startRowIndex, col = startColIndex;

            while(row != endRowIndex && col != endColIndex)
            {
                banner[row][col] = marker;
                row += rowIncrement;
                col += colIncrement;
            }

            banner[endRowIndex][endColIndex] = marker;
        }

    }

}
