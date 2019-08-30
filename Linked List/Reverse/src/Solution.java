
public class Solution {
	public static void main(String[] args) 
	    { 
	        Node head = new Node(85);
	        head.next = new Node(15); 
	        head.next.next = new Node(4); 
	        head.next.next.next = new Node(20); 
	  
	        // 85 -> 15 -> 4 -> 20
	        
	        System.out.println("Given Linked list"); 
	        printList(head); 
	        head = reverse(head); 
	        System.out.println(""); 
	        System.out.println("Reversed linked list "); 
	        printList(head); 
	    } 
	
	public static Node reverse(Node head) {
		if(head == null) {
			return null;
		}
		
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		return head;
	}
	
	private static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
	}
}
