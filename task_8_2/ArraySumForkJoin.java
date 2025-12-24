import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.Random;

public class ArraySumForkJoin {

    // sum calculating 
    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 20; // treshhold
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            // if elements amount < 20, calculate sum
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // devide array into 2 parts
                int mid = start + (end - start) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                // start tasks in paralell 
                leftTask.fork(); 
                long rightResult = rightTask.compute();
                long leftResult = leftTask.join();

                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        int size = 1_000_000; // 
        int[] array = new int[size];
        Random random = new Random();

        // initiate array with random numbers
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(101);
        }

        ForkJoinPool pool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        
        long totalSum = pool.invoke(new SumTask(array, 0, array.length));
        
        long endTime = System.currentTimeMillis();

        // results output
        System.out.println("Сума елементів масиву: " + totalSum);
        System.out.println("Час виконання (ForkJoin): " + (endTime - startTime) + " мс");
        
        long checkSum = 0;
        for (int x : array) checkSum += x;
        System.out.println("Перевірочна сума (Single-thread): " + checkSum);
    }
}