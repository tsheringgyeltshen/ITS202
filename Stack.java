public class Stack{

	int max_size=5;
	int top=-1;
	int size=0;

	int arr[]=new int[max_size];
	public void push(int e){//adding element from the array
		if(size>max_size){
			System.out.println("Stack overflow");
		}
		else{
			arr[top+1]=e;
			top++;
		}
		size=size+1;
	}
	public int pop(){//removing element from the top
		if(size==0){
			System.out.println("your stack is empty");
		}
		else{
			int e=arr[top-1];
			top--;
			size=size-1;
		}
		
		return arr[top];
	}


	public int top(){//returns top element of the array
		if(top==-1){
			return 0;
		}
		return arr[top];
	}

	public int size(){
		return size;
	}


	public boolean isEmpty(){//returns the array is empty or not
		if(size==0){
			return true;
		}
		return false;
		}
	}
