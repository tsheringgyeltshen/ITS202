public class linearsearch{

public static int concide(int arr[],int key){
	for(int i=0; i<arr.length; i++){
		if(arr[i]==key){
			System.out.println("The number you are searching is: "+arr[i]);
		}
	}
	return -1;
}

public static void main(String[] args){
	int a[]={1,2,3,4,5,6,7,8,9,10};
	int n=a.length;
	int key=1;
	concide(a, key);
}
}