package questions;

public class TNN08Day13P47 {

    public static void main(String[] args) {
        TNN08Day13P47 t = new TNN08Day13P47();
        int[][] array = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int row = array.length;
        int column = array[0].length;
        int[][] r = new int[row][column];
        t.getMyPresents(array, row, column, r);
        System.out.println(r[row - 1][column - 1]);
        System.out.println(t.getMyBetterPresents(array, row, column));
    }

    public void getMyPresents(int[][] array, int row, int column, int[][] r) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int preValue = 0;
                if (i > 0) {
                    preValue = r[i - 1][j];
                }
                if (j > 0) {
                    if (r[i][j - 1] > preValue) {
                        preValue = r[i][j - 1];
                    }
                }
                r[i][j] = preValue + array[i][j];
            }
        }
    }

    public int getMyBetterPresents(int[][] array, int row, int column) {
        int r = 0;
        int[] temp = new int[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int preValue = 0;
                if (j > 0) {
                    preValue = temp[j - 1];
                }
                if (temp[j] > preValue) {
                    preValue = temp[j];
                }

                temp[j] = preValue + array[i][j];
                if (i == row - 1 && j == column - 1) {
                    r = temp[j];
                }
            }
        }

        return r;
    }
}
