public class Main {
    public static void main(String[] args) {
        // TEST 1
        SinglyLinkedList<Integer> anIntegerList = new SinglyLinkedList<>();
        anIntegerList.add(99);
        anIntegerList.add(88);
        anIntegerList.add(77);
        anIntegerList.add(66);
        anIntegerList.remove(0);                    // Remove head
        System.out.println("Get: " + anIntegerList.get(1));   // Get contents of index 1
        System.out.println("The list: " + anIntegerList);     // toString
        System.out.println("==========");

        // TEST 2
        SinglyLinkedList<String> aStringList = new SinglyLinkedList<>();
        aStringList.add("One");
        aStringList.add("Two");
        aStringList.add("Three");
        aStringList.add("Four");
        aStringList.pop();                                    // Remove end
        aStringList.remove(1);                      // Remove index 1
        System.out.println("The list: " + aStringList);       // toString
        System.out.println("==========");

        // TEST 3
        DoublyLinkedList<Character> aCharacterList = new DoublyLinkedList<>();
        aCharacterList.add('q');
        aCharacterList.add('w');
        aCharacterList.add('e');
        aCharacterList.add('r');
        aCharacterList.add('t');
        aCharacterList.add('y');
        aCharacterList.remove(2);
        System.out.println("The list: " + aCharacterList);     // toString
        System.out.println("==========");
        aCharacterList.pop();
        System.out.println("The list: " + aCharacterList);     // toString
        System.out.println("==========");


    }
}