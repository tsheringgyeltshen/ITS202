public class BST<Key extends Comparable<Key>, Value> {

	private Node root;		
	
	private class Node {
		Key key;
		Value val;
		Node left;
		Node right;
		int N;
		
		public Node(Key key, Value value, Node left, Node right) {
			this.key = key;
			this.val = value;
			this.left = left;
			this.right = right;
			this.N = 1;
		}
	}
	
	public BST() {
		root = null;
	}


	public Value get(Key key) {
		return get(key, root);
	}
	
	private Value get(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		
		if (cmp < 0)
			return get(key, x.left);
		else if (cmp > 0)
			return get(key, x.right);
		
		return x.val;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val) {
		if (x == null) {
			return new Node(key, val, null, null);
		}
		
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			x.val = val;
			return x;
		} else if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public int size() {
		return size(root);
	}
	public boolean isEmpty() {
		return root == null;
	}
	
	private int size(Node x) {
		if (x == null) return 0;
		return x.N;
	}

	public Key min() {
		if (isEmpty()) 
			return null;
		return min(root).key;
	}
	private Node min(Node x) {
		if (x == null)  
			return null;
		if (x.left != null)
			return min(x.left);
		else
			return x;
	}
	
	public Key floor(Key key) {
		Node n = floor(root, key);
		if (n != null) return n.key;
		return key;
	}
	
	private Node floor(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0) 
			return floor(x.left, key);
		else if (cmp > 0) {
			Node t = floor(x.right, key);
			if (t == null) 
				return x;
			else
				return t;
		}
		return x;
	}
	public Key select(int rank) {
		return select(root, rank);
	}

	private Key select(Node x, int rank) {
		if (x == null) return null;
		
		int t = size(x.left);
		if(rank < t) return select(x.left, rank);
		else if (rank > t)
			return select(x.right, rank-t-1);
		return x.key;
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if (x == null) return null;
		
		if (x.left == null) return x.right; 
	
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;	
		return x;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		
		if (cmp > 0) {
			x.right = delete(x.right, key);
		} else if (cmp < 0) {
			x.left = delete(x.left, key);
		} else {
			
			if (x.left == null) 
				return x.right;
			else if (x.right == null) 
				return x.left;
			else {
				
				Node t = x.right;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left; 
			}
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}


public static void main(String[] args){
	BST<String,Integer> obj=new BST <String,Integer>();
	obj.put("Ada",1);
	obj.put("Ballerina",7);
	System.out.println(obj.get("Ada"));
	obj.put("Html",5);
	obj.put("java",7);
	System.out.println(obj.get("java"));
	System.out.println(obj.size());
	System.out.println(obj.min());
	System.out.println(obj.floor("Ballerina"));
	System.out.println(obj.select(3));

	obj.put("java", 8);
	obj.put("Dart",9);
	System.out.println(obj.get("java"));
	System.out.println(obj.size());
	obj.deleteMin();
	obj.delete("java");
	}
}