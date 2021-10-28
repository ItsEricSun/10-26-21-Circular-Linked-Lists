
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
