
public class ourSort {
	
	public static void sortVoneshaAnna(int[] nos) {
		int maxIndex = 0;
		int temp;
		for (int i =0; i<nos.length; i++)
		{
			maxIndex=0;
			for (int j=0; j < nos.length-i; j++)
			{
				if (nos[j] > nos[maxIndex]) 
					maxIndex = j;
			}
			temp = nos[nos.length-1-i];
			nos[nos.length-1-i] = nos[maxIndex];
			nos[maxIndex] = temp;
		}
		
		for (int x : nos)
			System.out.print(x + " ");
		System.out.println();
	}
	
	public static void main(String []args) {
		Sorts one = new Sorts(20,10);
		one.display();
		sortVoneshaAnna(one.getNos());
	}
}
