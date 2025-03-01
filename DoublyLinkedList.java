public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public DoublyLinkedList() {}

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        // Constructors
        Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    /**
     * Makes a new node to the end of the Doubly linked list
     * @param data Any object to fill the node with.
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);

        if (head == null) {
            // For when it has nothing
            head = newNode;
            tail = newNode;
            return;
        } else {
            // Traversing and adding to the end
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * Remove the last node of the SinglyLinkedList
     */
    public void pop() {
        if (head == null) {
            // For when it has nothing
            return;
        } else if (head.next == null) {
            // For when it has one thing
            head = null;
            tail = null;
            return;
        } else {
            // For when
            // Adjust the tail to the previous node
            tail = tail.prev;
            tail.next = null;
        }
    }

    /**
     * Get the contents of the node in the target index.
     * @param targetIndex The index you want to see.
     * @return The contents of target index or null if not found.
     */
    public T get(int targetIndex) {
        int i = 0;
        Node<T> current = head;
        while (current.next != null) {
            if (i == targetIndex) {
                return current.data;
            }
            current = current.next;
            i++;
        }
        return null;
    }

    /**
     * Remove a node based on the index.
     * @param targetIndex The index you want to remove.
     */
    public void remove(int targetIndex) {
        if (targetIndex == 0) {
            // For when you remove the head
            if (head == tail) {
                // If there's only one node, set head and tail to null
                head = null;
                tail = null;
            } else {
                // Otherwise, adjust head to the next node and its prev pointer to null
                head = head.next;
                head.prev = null;
            }
            return;
        } else {
            int i = 0;
            Node<T> current = head;
            // Traverse the list until index
            while (current != null) {
                if (i == targetIndex) {
                    // Adjust prev and next when it exists
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    }

                }
                current = current.next;
                i++;
            }
        }
    }

    /**
     * Returns a string version of the SinglyLinkedList if possible.
     * @return a String
     */
    @Override
    public String toString() {
        // Traverse the Linked list
        Node<T> current = head;
        // (This was IntelliJ that upgraded my "String" into "StringBuilder"
        // ... and changed my "+" into "appends")
        StringBuilder result = new StringBuilder();
        while (current.next != null) {
            result.append(current.data).append(", ");
            current = current.next;
        }
        result.append(current.data);
        return result.toString();
    }
}
