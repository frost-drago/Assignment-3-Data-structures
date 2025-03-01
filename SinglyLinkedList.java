public class SinglyLinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList() {}

    static class Node<T> {
        T data;
        Node<T> next;

        // Constructors
        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * Makes a new node to the end of the Singly linked list
     * @param data Any object to fill the node with.
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);

        if (head == null) {
            // For when it has nothing
            head = newNode;
        } else {
            // Traversing and adding to the end
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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
            return;
        } else {
            // Traversing to just before the end and removing the end
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
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
            head = head.next;
        } else {
            int i = 0;
            Node<T> current = head;
            // Traverse the list until index - 1.
            // current's next = next's next
            while (current.next != null) {
                if (i == targetIndex - 1) {
                    current.next = current.next.next;
                    return;
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
