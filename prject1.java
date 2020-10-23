/*import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> extends List<E> {

    public Iterator<E> iterator() {

        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            private Node<E> curr = head;
        };
    }

    public void insert(E data) {
        insert(null, head, data);
    }
    private void insert(Node<E> prev, Node<E> curr, E data) {
        Node<E> temp = new Node<>(data);
        if((curr == null || curr.data.compareTo(data)>=0) && prev == null){
            temp.next = head;
            head = temp;
        }

        else if((curr == null || curr.data.compareTo(data) >= 0) && prev.data.compareTo(data)<=0){
            temp.next = curr;
            prev.next = temp;
        }
        else insert(curr, curr.next, data);
    }


    public void remove(E data) {
        remove(head, data);
    }
    private void remove(Node<E> curr, E data){
        if(curr == null){
            return;
        }
        if(curr.next != null && curr.next.data == data && curr.next.next == null){
            curr.next = null;
        }
        else if(curr.next != null && curr.next.data == data){
            curr.next = curr.next.next;
        }
        else if(head.data == data){
            head = head.next;
        }
        else{
            remove(curr.next, data);
        }

    }



    public E retrieve(int index) {
        if(head != null){
            return retrieve(head, index);
        }
        return null;
    }
    private E retrieve(Node<E> curr, int index){
        if(index == 0 && curr != null){
            return curr.data;
        }
        if(curr.next != null) {
            return retrieve(curr.next, index-1);
        }
        else return null;
    }



    public boolean search(E data) {
        return search(data, head);
    }

    private boolean search(E data, Node<E> curr){
        if(curr.data == data){
            return true;
        }
        else if(curr.next == null){
            return false;
        }
        return search(data, curr.next);
    }
}
*/