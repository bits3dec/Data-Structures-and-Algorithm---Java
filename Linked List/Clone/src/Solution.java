
public class Solution {
	public static void main(String[] args)  
	{  
	    Node start = new Node(1);  
	    start.next = new Node(2);  
	    start.next.next = new Node(3);  
	    start.next.next.next = new Node(4);  
	    start.next.next.next.next = new Node(5);  
	  
	    // 1's random points to 3  
	    start.random = start.next.next;  
	  
	    // 2's random points to 1  
	    start.next.random = start;  
	  
	    // 3's and 4's random points to 5  
	    start.next.next.random = start.next.next.next.next;  
	    start.next.next.next.random = start.next.next.next.next;  
	  
	    // 5's random points to 2  
	    start.next.next.next.next.random = start.next;  
	  
	    System.out.println("Original list : ");  
	    print(start);  
	  
	    System.out.println();
	    
	    System.out.println("Cloned list : ");  
	    Node cloned_list = clone(start);  
	    print(cloned_list);  
	  
	} 
	
	public static Node clone(Node head) {
		if(head == null) {
			return null;
		}
		
		Node current = head;
		//Insert cloned nodes after every original nodes
		while(current != null) {
			Node next = current.next;
			current.next = new Node(current.data);
			current.next.next = next;
			current = next;
		}
		
		current = head;
		//Update random pointers
		while(current != null) {
			if(current.next != null) {
				current.next.random = current.random != null ? current.random.next : null; 
			}
			current = current.next != null ? current.next.next : null;
		}
		
		
		current = head;
		Node cloned = head.next;
		Node clonedHead = head.next;
		//decouple the original nodes and the cloned nodes
		while(current != null && cloned != null) {
			current.next = current.next != null ? current.next.next : null;
			cloned.next = cloned.next != null ? cloned.next.next : null;
			
			current = current.next;
			cloned = cloned.next;
		}
		
		return clonedHead;
	}
	
	private static void print(Node head) {
		while(head != null) {
			System.out.print("Data: " + head.data + "|" + "HashCode: " + head.hashCode() + " || ");
			head = head.next;
        }
        System.out.println();
	}
}

class Node {
	int data;
	Node next;
	Node random;
	
	Node(int data) {
		this.data = data;
	}
}
