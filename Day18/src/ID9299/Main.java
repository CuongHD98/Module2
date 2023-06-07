package ID9299;

public class Main {
    public static void main(String[] args) {
        Runnable lazyRunnable = new LazyPrimeFactorization();
        Runnable optimizedRunnable = new OptimizedPrimeFactorization();

        Thread lazyThread = new Thread(lazyRunnable);
        Thread optimizedThread = new Thread(optimizedRunnable);

        lazyThread.start();
        optimizedThread.start();
    }
}

class LazyPrimeFactorization implements Runnable {
    private int currentNumber = 2;

    @Override
    public void run() {
        System.out.println("LazyPrimeFactorization started.");
        while (true) {
            if (isPrime(currentNumber)) {
                System.out.println("LazyPrimeFactorization: " + currentNumber);
            }
            currentNumber++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class OptimizedPrimeFactorization implements Runnable {
    private int currentNumber = 2;

    @Override
    public void run() {
        System.out.println("OptimizedPrimeFactorization started.");
        while (true) {
            if (isPrime(currentNumber)) {
                System.out.println("OptimizedPrimeFactorization: " + currentNumber);
            }
            currentNumber++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

