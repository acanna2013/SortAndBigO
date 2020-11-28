import java.util.Random;

public class Sorts {

	private int[] nos;
	private int steps;
	

	// Constructs a default array of size 10
	public Sorts() {
		nos = new int[10];
		nos[0] = -10001;
		nos[1] = 3;
		nos[2] = 7;
		nos[3] = 19;
		nos[4] = 15;
		nos[5] = 19;
		nos[6] = 7;
		nos[7] = 3;
		nos[8] = 19;
		nos[9] = -100;

	}

	public Sorts(int[] temp) {
		nos = temp;
	}

	// Constructs an array with size random Sorts from [0,range)
	public Sorts(int size, int range) {
		nos = new int[size];
		for (int i = 0; i < size; i++)
		{
			nos[i] = (int)(Math.random()*range)+1;
		}
	}

	// Constructs an array of random Sorts [0-range) array of size count with a
	// seed
	// The seed allows you to use the same set of random numbers

	public Sorts(int count, int range, long seed) {
		nos = new int[count]; 
		Random rand = new Random(seed);
		for (int i = 0; i < count; i++)
			nos[i] = rand.nextInt(range);
	}

	// This constructor will create an ordered array of consecutive integers
	// true will yield ascending order
	// false will yield descending order
	public Sorts(int count, boolean ordered) {
		nos = new int[count];
		for(int i = 0; i < nos.length; i++) {
		    if (ordered)
		    {
		    	nos[i] = i;
		    }
		    else
		    {
		    	nos[i] = nos.length-i-1; 
		    }
		}
	}

	public int getSteps() {
		return steps;
	}

	public void display() {
		for (int x : nos)
			System.out.print(x + " ");
		System.out.println();
	}

	public int[] getNos() {
		return nos;

	}

	public void swap(int x, int y) {
		int temp = nos[x];
		nos[x] = nos[y];
		nos[y] = temp;
		steps += 3;
	}
	
	public void insertionSort() {
		int temp;
		for (int i =1; i <nos.length; i++)
		{
			steps++;
			for (int j = i-1; j >= 0 && nos[i] < nos[j]; j--, i--)
			{
				steps++;
				temp = nos[i];
				nos[i] = nos[j];
				nos[j] = temp;
			}
		}
	}

	public void selectionSort() {
		steps = 0;
		for (int x = 0; x < nos.length; x++) {
			steps++;
			int minIndex = x;
			int z = x + 1;
			while (z < nos.length) {
				steps++;
				if (nos[z] < nos[minIndex]) {
					minIndex = z;
				}
				z++;
			}
			int temp = nos[minIndex];
			nos[minIndex] = nos[x];
			nos[x] = temp;
		}
	}
	
	public void bubbleSort() {
		//Consecutive values are compared and swapped if necessary
		steps = 0;
		boolean swapped = true;
		steps++;
		int lastSwap = nos.length - 1;
		steps++;
		int temp = 0;
		steps++;
		steps++; // initialize for loop
		for (int i = 0; i < nos.length; i++) {
			steps += 3; // boundary check, increment,if
			if (swapped) {
				swapped = false;
				steps++;
				steps++; // initialize for loop
				for (int j = 0; j < lastSwap; j++) {
					steps += 3; // boundary check, increment,if
					if (nos[j] > nos[j + 1]) {
						swap(j, j + 1);
						swapped = true;
						steps++;
						temp = j;
						steps++;
					}
				}
				lastSwap = temp;
				steps++;
			}

		}
	}
	
	/*For our quadratic sort, we decided to sort according to the maximum value. Similarly, to selection sort,
	 * we find the maximum value of the entire array and sort the max value to the last unsorted array. 
	 * Then, we continue iterating the loop comparing values in the unsorted array to find the max and 
	 * append the max founded to the beginning of the sorted array. We continue until the entire array has 
	 * been traversed. 
	 */
	public void ourSort() {
		int maxIndex = 0;
		int temp;
		for (int i =0; i<nos.length; i++)
		{
			maxIndex=0;
			steps++;
			for (int j=0; j < nos.length-i; j++)
			{
				steps++;
				if (nos[j] > nos[maxIndex]) 
					maxIndex = j;
			}
			temp = nos[nos.length-1-i];
			nos[nos.length-1-i] = nos[maxIndex];
			nos[maxIndex] = temp;
		}
	}


	public static void main(String[] args) {

		Sorts one = new Sorts(60, 1000);
		StopWatch timer = new StopWatch();
		timer.start();
		one.display();
//		one.bubbleSort();
		one.ourSort();
		timer.stop();
		one.display();
		System.out.println("Default Array Steps:     " + one.getSteps());
		System.out.println("Default Array time: " + timer.getElapsedTime()+ " milliseconds.");
//		
		//This is a sample code for testing bubble sort  for data in  reverse order
//		 Sorts two = new Sorts (80, false);
//		 two.display();
//		 timer.reset();
//		 timer.start();
//		 two.ourSort();
//		 timer.stop();
//		 two.display();
//		 System.out.println("Reverse order Steps: " + two.getSteps());
//		 System.out.println("Reverse order time: " + timer.getElapsedTime()+ " milliseconds");
//		 System.out.println();

	}
}
