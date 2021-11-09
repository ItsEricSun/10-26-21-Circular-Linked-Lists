import java.util.ListIterator;
import java.util.NoSuchElementException;

class LinkedList<E> {
    private Node<E> head = null; 
  
    private class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;
		Node(E d) { 
			data = d; 
		}
		
		Node(E d, Node<E> next, Node<E> prev){
			data = d;
			this.next = next;
			this.prev = prev;
		}
	}
    
    public void add(E data){
		Node<E> new_node = new Node<E>(data, null, null);
		if(head == null) {
			head = new_node;
			return;
		}
		Node<E> last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        new_node.prev = last;
        return;
	}
    
    public E remove(String name){
    	if(head == null) {
    		return null;
    	}
    	Node<E> current = head;
    	while(current != null) {
    		if(current.data.equals(name)) {
    			current.prev.next = current.next;
    			return current.data;
    		}
    	}
    	return null;
    }
    
    public ListIterator<E> iterator() {
		return new LinkedListIterator();
	}
    
    private class LinkedListIterator implements ListIterator<E> {
		private Node<E> cur = head;
		private Node<E> lastA = head;
		
		public boolean hasNext() {
			return cur != null;
		}

		public E next() {
			E data = cur.data;
			lastA = cur;
			cur = cur.next;
			return data;
		}

		public boolean hasPrevious() {
			return cur.prev != null;
		}

		public E previous() {
			cur = cur.prev;
			return cur.data;
		}
		
		public void set(E e) {
			if(cur == null) {
				throw new NoSuchElementException();
			}
			cur.data = e;
		}

		public void remove() {
			if(lastA == null) {
				throw new NoSuchElementException();
			}
			if(cur == null && lastA == head) {
				head = null;
				lastA = null;
			}
			else if (cur == null){
				lastA.prev.next = null;
				lastA = null;
				System.out.println("cur null");
			}
			else if(lastA == head) {
				head = cur;
				cur.prev = null;
				lastA = null;
			} 
			else{
				cur.prev = lastA.prev;
				lastA.prev.next = cur;
				lastA = null;
			}
		}

		public void add(E e) {
			Node<E> new_node = new Node<E>(e, null, null);
			if(cur == null) {
				head = new_node;
				return;
			}
			new_node.next = lastA.next;
			new_node.prev = lastA;
			lastA.next = new_node;
			new_node.next.prev = new_node;
		}

		public int nextIndex() {
			return 0;
		}

		public int previousIndex() {
			return 0;
		}
		
		public E getLastA() {
			return lastA.data;
		}
		
	}
    
//    public void printList(LinkedList list){
//        Node currNode = list.head;
//   
//        System.out.print("\nLinkedList: ");
//   
//        // Traverse through the LinkedList
//        while (currNode != null) {
//            // Print the data at current node
//            System.out.print(currNode.data + " ");
//   
//            // Go to next node
//            currNode = currNode.next;
//        }
//    }
    
    public int size(){
        Node<E> currNode = head;
        int i = 0;
        while (currNode != null) {
            currNode = currNode.next;
            i++;
        }
        return i;
    }
}
