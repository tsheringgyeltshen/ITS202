import java.util.*;

class Node{
	int element;
	Node next;
}
class Stack{
	private Node top;
	

	public Stack(){
		this.top = null;

	}

	//push()
	public void push(int x) {
		Node node= new Node();
		if (node == null){
			System.out.println("\n stack overflow");
			return;
		}
		System.out.println("\nInserting " +x);
		node.element = x;
		node.next = top;
		top = node;
	}
	public boolean isEmpty(){
		return top == null;
	}
	public int peek()
	{
		// check for empty stack
		if (!isEmpty()) {
			return top.element;
		}
		else {
			System.out.println("\nStack is empty");
			return -1;
		}
	}
	public void pop(){
		if(top==null){
			System.out.println("\nStack overflow");
			return;
		}
		System.out.println("\nremoving " + peek());
		top = (top).next;
	}
}
class Stacklinklist{
	public static void main(String[] args)
	{
		Stack stack = new Stack();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println("\nTop element is " + stack.peek());
		
		stack.pop();
		stack.pop();
		stack.pop();

		if (stack.isEmpty()) {
			System.out.println("\nStack is empty");
		} else {
			System.out.println("\nStack is not empty");
		}
	}
}