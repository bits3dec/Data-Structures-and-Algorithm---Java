
public class Solution {
	public static void main(String[] args) 
    { 
        // 1->2->3->4->5->6->7->8->9->10
        Node head = new Node(1);
        head.next = new Node(2); 
        head.next.next = new Node(3); 
        head.next.next.next = new Node(4); 
        head.next.next.next.next = new Node(5); 
        head.next.next.next.next.next = new Node(6); 
        head.next.next.next.next.next.next = new Node(7); 
        head.next.next.next.next.next.next.next = new Node(8); 
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10); 
        
        System.out.println("Given Linked list"); 
        printList(head); 
        head = reverseKSize(head, 4); 
        System.out.println(""); 
        System.out.println("Reversed linked list "); 
        printList(head); 
    } 
	
	public static Node reverseKSize(Node head, int k) {
		if(head == null) {
            return null;
        }

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        while(current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            ++count;
        }

        //next is now pointing to (k+1)th node
        if(next != null) {
            head.next = reverseKSize(next, k);
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
