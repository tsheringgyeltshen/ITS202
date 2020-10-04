public class ArrayList
{
	double full_1over4 = 0.25;
	double full_3over4 = 0.75;
	int container = 4;
	static int A;
	int remove;
	int top = 0;
	static double length;
	static int Array[];
	public ArrayList()
	{
		Array = new int[container];
	}
	public void add(int e)
	{
		Array[top] = e;
		top++;
	}
	public void pop()
	{
		top--;
		remove = Array[top];
		Array[top] = 0;
		int count = 0;
		for(int i = 0; i < Array[i]; i++) {
			count++;
		}
		A = count;
		length = (double)A/container;
		System.out.println("Remove Element " +remove);
	}
	
	public void resize()
	{
		if(length == full_1over4 ) {
			int newArray[] = new int[(container/2)*2];
			for(int i = 0; i < Array.length; i++) {
				newArray[i] = Array[i];
			}
			Array = newArray;
			container = container/2;
			for(int n : newArray) {
				System.out.print(n + " ");
				}	
		}
		else if(length == full_3over4) {
			int newArray[] = new int[container*2];
			for(int i = 0; i < Array.length; i++) {
				newArray[i] = Array[i];
			}
			container = container * 2;
			Array = newArray;
			for(int j : newArray) {
			System.out.print(j + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("ArrayIndexOutOfBoundRange");
		}
	}
	public int size()
	{
		return container;
	}
	public String toString()
	{
		String t = Integer.toString(container);
		return t;
	}
     
	public static void main(String[] args) {
		ArrayList object = new ArrayList();
		object.add(2);
		object.add(4);
		object.add(6);
		//obj.add(5);
		object.add(1);
//		obj.add(7);
		object.pop();
		//obj.pop();
		object.resize();
		System.out.println("toString " +object.toString());
		System.out.println("The number of elements in the new Array is " +A);
		System.out.println("The Size of new Array is " +object.size());
	}
}