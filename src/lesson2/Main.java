package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] string = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        String[][] string1 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        String[][] string2 = {
                {"1", "1", "1", "1"},
                {"1", "y", "1", "1"},
                {"1", "1", "jj", "1"},
                {"1", "1", "1", "1"}
        };

        try {
            System.out.println("Сумма элементов = " + sumOfArray(string2));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage() + "\n" + e.getNum());
        }
    }

    public static int sumOfArray(String[][] array) {
        int ROWS = 4;
        int COLS = 4;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != COLS) {
                throw new MyArraySizeException("Неправильный размер массива!");
            }
        }
        if (array.length != ROWS){
            throw new MyArraySizeException("Неправильный размер массива!");
        }

        int sum = 0;
        int current = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw  new MyArrayDataException("неправильный формат элемента!", current);
                }
                current++;
            }
        }
        return sum;
    }
}
