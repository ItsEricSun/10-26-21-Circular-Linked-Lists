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
		
		public boolean hasNext() {
			return cur.next != null;
		}

		public E next() {
			cur = cur.next;
			return cur.data;
		}

		public boolean hasPrevious() {
			return cur.prev != null;
		}

		public E previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
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
			if(cur == null) {
				throw new NoSuchElementException();
			}
			if(cur == head && cur == tail) {
				head = null;
				tail = null;
				cur = head;
			} else if(cur == head) { 
				head = cur.next;
				cur = cur.next;
				cur.prev = null;
			} else if (cur == tail) {
				tail = cur.prev;
				cur = cur.prev;
				cur.next = null;
			} else {
				cur.next.prev = cur.prev;
				cur.prev.next = cur.next;
			}
		}

		public void add(E e) {
			Node<E> new_node = new Node<E>(e);
			new_node.next = null;
			new_node.prev = null;
			if (head == null) {
				head = new_node;
				tail = new_node;
				return;
			}
			if(cur == head) {
				Node<E> first = head;
				first.prev = new_node;
				new_node.next = first;
				head = new_node;
				return;
			}
			new_node.next = cur;
			new_node.prev = cur.prev;
			cur.prev.next = new_node;
			cur.prev = cur.prev.next;
		}

		public int nextIndex() {
			return 0;
		}

		public int previousIndex() {
			return 0;
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
