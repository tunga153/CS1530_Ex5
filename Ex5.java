import java.util.*;

public class Ex5 {
	public static int[] sums;
	public static void main(String[] args) {
			int numThreads = -1;
			int numIterations = -1;	
			int iterationsPerThread = -1;
			try {
				numThreads = Integer.parseInt(args[0]);
				numIterations = Integer.parseInt(args[1]);
			} catch (Exception e) {
				System.exit(23523535);
			}
			sums = new int[numThreads];
			Arrays.fill(sums, 0);
			iterationsPerThread = numIterations/numThreads;
			Thread[] Threads = new Thread[numThreads];

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