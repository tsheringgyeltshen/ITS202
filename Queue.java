import java.util.*;

public class Queue{
	int rear=-1;
	int front=-1;
	int top=-1;
	int len=0;

	int arr[] = new int[7];
	public void enqueue(int e){
		if(len==0){
			arr[0]=e;
			rear=0;
			front=0;
		}
		else{
			arr[rear+1]=e;
			rear=rear+1;
		}
		len=len+1;
	}
	public int dequeue(){
		if(len==0){
			System.out.println("array is empty");
		}
		else{
			front=front+1;

		}
		len=len-1;
		return arr[front];
	}
	public int first(){
		if(len==0){
			System.out.println("array is empty");
		}
			return arr[front];
	}
	public int len(){
		return len;
	}
	public boolean isEmpty(){
		if(len==0){
			return true;
		}
		else{
			return false;
		}
	}
}