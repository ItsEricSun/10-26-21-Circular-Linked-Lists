import java.util.ListIterator;
import java.util.NoSuchElementException;

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
		l.add(new Player("C"));
		l.add(new Player("B"));
		ListIterator<Player> i = l.iterator();
		System.out.println(i.next().toString());
		System.out.println(i.next().toString());
		System.out.println(i.next().toString());
		i.set(new Player("D"));
		System.out.println(i.previous().toString());
		System.out.println(i.next().toString());
		System.out.println(i.previous().toString());
//		System.out.println(l.getCurData().toString());
//		l.printList();
	}
	
	public ListIterator<E> iterator() {
		return new CircularlyLinkedListIterator();
	}
	
	private class CircularlyLinkedListIterator implements ListIterator<E> {
		private Node<E> cur = head;
		private Node<E> lastA = null;
		
		public boolean hasNext() {
			return true;
		}

		public E next() {
			E data = cur.data;
			lastA = cur;
			cur = cur.next;
			return data;
		}

		public boolean hasPrevious() {
			return false;
		}

		public E previous() {
			return lastA.data;
		}
		
		public void set(E e) {
			if(cur == null) {
				throw new NoSuchElementException();
			}
			lastA.data = e;
		}

		public void remove() {
			if(cur == null) {
				throw new NoSuchElementException();
			}
			if(cur == head) {
				head = null;
				cur = head;
			} else if(lastA == head) { 
				lastA.next = lastA;
				cur = lastA;
				head = lastA;
			} else {
				Node<E> cur2 = head;
				while(cur2.next != lastA) {
					cur2 = cur2.next;
				}
				cur2.next = cur;
			}
		}

		public void add(E e) {
			Node<E> new_node = new Node<E>(e);
			if(head == null) {
				head = new_node;
				new_node.next = head;
				cur = head;
			} else {
				lastA.next = new_node;
				new_node.next = cur;
				lastA = lastA.next;
				cur = cur.next;
			}
		}

		public int nextIndex() {
			return 0;
		}

		public int previousIndex() {
			return 0;
		}
		
	}
}
