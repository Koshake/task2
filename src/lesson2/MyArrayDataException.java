package lesson2;

public class MyArrayDataException extends NumberFormatException {
    private int num;

    public int getNum() {
        return num;
    }

    public MyArrayDataException(String message, int num) {
        super(message);
        this.num = num;
    }
}
