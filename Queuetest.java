public class Queuetest{
	public static void main(String[] args){
		Queue obj=new Queue();
		obj.enqueue(2);
		obj.enqueue(3);

		System.out.println(obj.first());
		System.out.println(obj.isEmpty());
		System.out.println(obj.len());
		System.out.println(obj.dequeue());
		System.out.println(obj.len());

	}
}