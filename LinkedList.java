public class LinkedList{
	Node head;
	Node tail;
	int size;

	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	//to check the size of a linklist
	public int size(){
		return size;
	}
	//to check weather the linklist is empty or not
	public boolean isEmpty(){
		if (size == 0) {
			return true;
		}
		return false;
	}
	//To display the first element from linklist
	public int first(){
		return head.getElement();
	}
	// 
	public int last(){
		return tail.getElement();
	}

	//To add element at first
	public void addFirst(int n){
		Node newest = new Node(n, null);

		if (size == 0) {
			 head = newest;//we have to make the neswest element as head if it is only one in the linklist
			 tail = newest;//we have to make the newest element as tail if it is only one in the linklist
		}

		else{
			newest.setNext(head);
			head = newest;
		}
		size = size + 1;
	}

	//To add element in the last
	public void addLast(int n){
		Node newest = new Node(n, null);
		if (size == 0) {
			head = newest;
			tail = newest;
		}
		else{
			tail.setNext(newest);
			tail =newest;
		}
		size += 1;
	}

	//to remove first element or head from the linklist
	public int removeFirst(){
		int deletedElement = head.getElement();
		if (size == 0) {
			return 0;
		}
		else{
			head = head.getNext();
			size = size -1;
		}
		return deletedElement;
	}



}

class Node{
	private int element;
	private Node next;
	// constructor
	public Node(int element, Node next ){
	    this.element = element;
		this.next = next;
	}

	// getElement
	public int getElement(){
		return element;
	}

	// getNext()
	public Node getNext(){
		return next;
	}

	// setElement()
	public void setElement(int n){
		element = n;
	}

	// setNext()
	public void setNext(Node n){
		next = n;
	}
}