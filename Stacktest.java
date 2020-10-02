public class Stacktest{
	public static void main(String[] args){
		Stack obj=new Stack();
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(2);
		obj.push(3);
		obj.push(4);

		System.out.println(obj.isEmpty());
		System.out.println(obj.top());
		System.out.println(obj.size());
		System.out.println(obj.pop());
		System.out.println(obj.size());
	}
}