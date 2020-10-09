import java.util.Scanner;
public class Insertion{
	public static void main(String[] args){
	Insertion object=new Insertion();


		Scanner obj=new Scanner(System.in);
		System.out.println("The length of the array is: ");
		int length=obj.nextInt();
		int[] array=new int[length];

		for(int i=0; i<length; i++){
			System.out.println("Enter the elements: ");
			int a=obj.nextInt();
			array[i]=a;
		}

		System.out.println("The unsorted array is: ");
		for(int j=0; j<array.length; j++){
			System.out.println(""+array[j]+"");
		}

		System.out.println("The sorted array is: ");
		object.Insert(array);
	}
	void Insert(int[] array){
		int n=array.length;
		for(int i=1; i<n; i++){
			int k=array[i];
			int j=i-1;

			while(j>=0 && array[j]>k){
				array[j+1]=array[j];
				j=j-1;
			}
			array[j+1]=k;
		}
		for(int k=0; k<n;k++){
			System.out.println(""+array[k]+"");
		}
	}
}