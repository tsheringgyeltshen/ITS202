import java.util.*;

public class Solution<Key extends Comparable<Key>, Value>  {
    private Node root;
    int size = 0;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size == 0){
        	return true;
        }
        return false;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      return size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
    	Node fast = root;
       if(key == null){
       		throw new IllegalArgumentException("There is not key conatin in the root");
       }
       else{
       		while(fast.key != key){
       			int cmp = key.compareTo(fast.key);
       			if(cmp < 0){
       				fast = fast.left;
       			}
       			else{
       				fast = fast.right;
       			}
       		}
       		return true;
       }
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
    	if(key == null){
	        throw new IllegalArgumentException("argument to get value() is null");
	    }
        Node fast = root;
        while(fast.key != key){
        	int cmp = key.compareTo(fast.key);
        	if(cmp < 0){
        		fast = fast.left;
        	}
	        else if(cmp > 0){
	        	fast = fast.right;
	        }
        }
        if(fast.key == key){
        	System.out.println(fast.val);
        }
        return fast.val;
    }

    // /**
    //  * Inserts the specified key-value pair into the symbol table, overwriting the old 
    //  * value with the new value if the symbol table already contains the specified key.
    //  * Deletes the specified key (and its associated value) from this symbol table
    //  * if the specified value is {@code null}.
    //  *
    //  * @param  key the key
    //  * @param  val the value
    //  * @throws IllegalArgumentException if {@code key} is {@code null}
    //  */
    public void put(Key key, Value val) {
        Node newNode = new Node(key,val);
        if(root == null){
        	root = newNode;
        }
        else{
        	Node fast = root;
        	Node parentkey;
        	while(true){
        		parentkey = fast;
        		int cmp = key.compareTo(fast.key);
        		if(cmp < 0){
        			fast = fast.left;
        			if(fast == null){
        				parentkey.left = newNode;
        				size = size + 1;
        				return;
        			}
        			else if(fast.key == key){
        				fast.val = val;
        				return;
        			}
        		}
        		else if(cmp > 0){
        			fast = fast.right;
        			if(fast == null){
        				parentkey.right = newNode;
        				size = size + 1;
        				return;
        			}
        			else if(fast.key == key){
        				fast.val = val;
        				return;
        			}
        		}
        	}
        }
        size = size + 1;
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
       if(isEmpty()){
       	throw new NoSuchElementException("There is no element in the tree");
       }
       else{
       		Node fast = root;
       		while(fast.left != null){
       			fast = fast.left;
       		}
       		return fast.key;
       }
    } 

    public Key max() { 
        if(isEmpty()){
       		throw new NoSuchElementException("There is no element in the tree");
       }
       else{
       		Node fast = root;
       		while(fast.right != null){
       			fast = fast.right;
       		}
       		return fast.key;
       }
    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
	public Key floor(Key key){
		if(isEmpty()){
			throw new NoSuchElementException("calls floor() with empty symbol table");
		}
		Node fast = root;
		Node parentkey = null;
		while(fast != null){
			parentkey = fast;
			int cmp = key.compareTo(parentkey.key);
			if(key == null){
				throw new IllegalArgumentException("calls floor() with a null key");
			}
			if(cmp == 0){
				return parentkey.key;
			}
			if(cmp < 0){
				fast = parentkey.left;
			}
			
			else if(cmp > 0){
				fast = parentkey.right;
				
				int cm = key.compareTo(fast.key);
				if(cm < 0 ){
					return parentkey.key;
				}
				
				else{
					fast = parentkey.right;
				} 
			}
		}
		return parentkey.key;
	}

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */

    //Return key of rank k.
    public Key select(Key key){
		if(isEmpty()){
			throw new NoSuchElementException("calls floor() with empty symbol table");
		}
		Node fast = root;
		Node parentkey = null;
		while(fast != null){
			parentkey = fast;
			int cmp = key.compareTo(parentkey.key);
			if(key == null){
				throw new IllegalArgumentException("calls floor() with a null key");
			}
			if(cmp > 0){
				fast = parentkey.right;
			}
		
			else if(cmp < 0){
				fast = parentkey.left;
				
				int cm = key.compareTo(parentkey.key);
				if(cm > 0 ){
					return fast.key;
				}
				
				else{
					fast = parentkey.left;
				} 
			}
		}
		return parentkey.key;
	}
    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public void keys(Key low, Key high){
    	if(low == null || high == null){
        	throw new IllegalArgumentException("calls keys() with a null key");
        }
    	Node fast = root;
    	Node parentkey;
        while(fast != null) {
        	parentkey = fast;
        	if(parentkey == null) { 
            	return; 
        	} 
        	int cmp = low.compareTo(parentkey.key);
    		int cm = high.compareTo(parentkey.key); 
            if (cmp < 0) { 
            	fast = parentkey.left;
        	}
        	if (cmp <= 0 && cm >= 0) { 
            	System.out.print(parentkey.key + " "); 
        	} 
        	if (cm > 0) { 
            	fast = parentkey.right;
        	}
        }
    }
   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
        Solution <String, Integer> Obj = new Solution <String, Integer>();
        Obj.put("ABDUL",1);
        Obj.get("ABDUL");
        Obj.put("HRITHIK",2);
        Obj.put("SAI",3);
        Obj.put("SAMAL",6);
        Obj.get("SAI");
        Obj.put("TASHI",4);
        System.out.println(Obj.size());
        System.out.println(Obj.min());
        System.out.println(Obj.floor("HRITHIK"));
        System.out.println(Obj.floor("HAHA"));
        System.out.println(Obj.select("HRITHIKH"));
        Obj.keys("ABDUL","TASHI");
        System.out.println();
        Obj.put("CHIMI",5);
        Obj.put("SAMAL",4);
        Obj.get("SAMAL");
        Obj.put("NIMA",7);
        System.out.println(Obj.size());
        Obj.get("CHIMI");
        System.out.println(Obj.floor("CHIMI"));
        Obj.put("SONAM",8);
        Obj.keys("ABDUL","TASHI");
    }
}