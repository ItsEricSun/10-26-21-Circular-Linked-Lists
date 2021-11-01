public class CircularLinkedList<E> {
	private Node<E> head = null; 
	private Node<E> cur = null;
	
	private class Node<E> {
		E data;
		Node<E> next;
		Node(E d) { 
			data = d; 
		}
		
		Node(E d, Node<E> next){
			data = d;
			this.next = next;
		}
		
		E getData() {
			return data;
		}
	}
	
	public void add(E data){
		Node<E> new_node = new Node<E>(data);
		if(head == null) {
			head = new_node;
			new_node.next = head;
			cur = head;
		}
		cur.next = new_node;
		new_node.next = head;
		cur = cur.next;
	}
	
	public Node<E> getHead() {
		return head;
	}
	
	public Node<E> getCur() {
		return cur;
	}
	
	public E getCurData() {
		return cur.data;
	}
	
	public void setCur(E data) {
		cur.data = data;
	}
	
	public void next() {
		cur = cur.next;
	}

	public void printList(){
		if(head == null) {
			System.out.println("Empty");
			return;
		}
		Node<E> currNode = head;
		System.out.print("Forwards: ");
		System.out.print(currNode.data + " ");
		currNode = currNode.next;
		while (currNode != head) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}

	public int size(){
		Node<E> currNode = head;
		int i = 0;
		while (currNode != null) {
			currNode = currNode.next;
			i++;
		}
		return i;
	}
	
	public static void main(String[] args) {
		CircularLinkedList<Player> l = new CircularLinkedList<>();
		l.add(new Player("A"));
//		System.out.println(l.getCur());
//		l.printList();
		l.add(new Player("C"));
		l.add(new Player("B"));
		l.next();
		System.out.println(l.getCurData().toString());
//		l.printList();
	}
}
