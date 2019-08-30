public class Solution {
	
    public static void main(String[] args) { 

    } 
	
	public static Node flatten(Node head) {
		if(head == null) {
			return null;
		}
		
		Node current = head;
		Node tail = null;
		
		while(current.next != null) {
			current = current.next;
		}
		tail = current;
		
		current = head;
		while(current != tail) {
			if(current.child != null) {
				tail.next = current.child;
				
				Node temp = current.child;
				while(temp.next != null) {
					temp = temp.next;
				}
				tail = temp;
				
				current.child = null;
			}
			current = current.next;
		}
		
		return head;
	}
}

class Node {
	int data;
	Node next;
	Node child;
	
	Node(int data) {
		this.data = data;
	}
}
