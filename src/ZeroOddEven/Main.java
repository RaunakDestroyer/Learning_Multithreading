package ZeroOddEven;

public class Main
{
    public static void main(String[] args)
    {
        ZeroOddEven zeroOddEven = new ZeroOddEven(6);
        Thread T1 = new Thread(() -> {
            try {
                zeroOddEven.printZero();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread T2 = new Thread(() -> {
            try {
                zeroOddEven.printOdd();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread T3 = new Thread(() -> {
            try {
                zeroOddEven.printEven();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        T1.start();
        T2.start();
        T3.start();
    }
}