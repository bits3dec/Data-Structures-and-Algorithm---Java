public class Solution {
    public static void main(String[] args) { 
/*
        1 -> 2 -> 3 -> 4 -> 5
        |              |
        6 -> 7 -> 8    12 -> 13
             |    |    |
             11   9    14 -> 15
                  |    |
                 10    16 -> 17

        o/p: 1, 2, 3, 4, 5, 6, 7, 8, 12, 13, 11, 9, 14, 15, 10, 16, 17
*/
		Node head = new Node(1);  
		head.next = new Node(2);  
		head.next.next = new Node(3);  
		head.next.next.next = new Node(4);  
		head.next.next.next.next = new Node(5);  

		head.child = new Node(6);
		head.child.next = new Node(7);
		head.child.next.child = new Node(11);
		head.child.next.next = new Node(8);
		head.child.next.next.child = new Node(9);
		head.child.next.next.child.child = new Node(10);

		head.next.next.next.child = new Node(12);
		head.next.next.next.child.next = new Node(13);
		head.next.next.next.child.child = new Node(14);
		head.next.next.next.child.child.next = new Node(15);
		head.next.next.next.child.child.child = new Node(16);
		head.next.next.next.child.child.child.next = new Node(17);

		print(head);
		flatten(head);
		print(head);
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

	private static void print(Node head) {
        if(head == null) {
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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
