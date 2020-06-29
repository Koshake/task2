package lesson5;

public class Main {

    static private int SIZE = 10000000;
    static private int HALF = SIZE / 2;

    public static void main(String[] args) {

        method1();

        try {
            method2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method1() {
        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        mathOperation(arr, 0);

        System.out.println("method 1 time: " + (System.currentTimeMillis() - a));
    }

    public static void method2() throws InterruptedException {
        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mathOperation(a1, 0);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mathOperation(a2, HALF);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println("method 2 time: " + (System.currentTimeMillis() - a));
    }

    public static void mathOperation(float[] array, int offset) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5)
                    * Math.cos(0.4f + (i + offset) / 2));
        }
    }
}
