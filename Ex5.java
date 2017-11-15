import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ex5 {
	public static int[] sums;
	public static void main(String[] args) {
		int numThreads = -1;
		int numIterations = -1;	

		try {
			numThreads = Integer.parseInt(args[0]);
			numIterations = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.exit(23523535);
		}
		sums = new int[numThreads];
		Arrays.fill(sums, 0);
		final int iterationsPerThread = numIterations/numThreads;
		Thread[] threads = new Thread[numThreads];
		for(int i = 0; i < numThreads; i++ ){
			final int ithread = i;
			threads[i] = new Thread(() -> {
				monteCarlo(ithread, iterationsPerThread);
			});
		}
		try {
			for(Thread t: threads) {
				t.start();
			}

			for(Thread t: threads) {
				t.join();
			}
		} catch(Exception e) {
			System.exit(11);
		}

		int totalSum = 0;
		for(int i = 0; i < numThreads; i++) {
			totalSum += sums[i];
		}

		System.out.println("Total: " + numIterations);
		System.out.println("Total within radius: " + totalSum);
		double ratio = ((double) totalSum)/((double) numIterations);
		System.out.println("Ratio: " + ratio);
		System.out.println("PI = " + (ratio * 4)) ;



	}

	public static void monteCarlo(int index, int iterations) {
		ThreadLocalRandom r = ThreadLocalRandom.current();
		for(int i = 0; i < iterations; i++) {
			double x = r.nextDouble(1);
			double y = r.nextDouble(1);
			if((x*x + y*y) < 1.0) {
				sums[index]++;
			}
		}
	}


}