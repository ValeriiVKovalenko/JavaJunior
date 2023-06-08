package javarush.my_linkedlist;

public class MyLinkedListRepeat<E> {

    private Node<E> head;
    private int size;

    public class Node<E> {
        private Node<E> next;
        private E value;

        public Node(E value) {
            this.next = null;
            this.value = value;
        }
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);

        if (size == 0) {
            head = newNode;
        } else {
            Node<E> headNode = head;
            while (headNode.next != null) {
                headNode = headNode.next;
            }
            headNode.next = newNode;
        }
        size++;
    }

    public boolean remove(E element) {
        if (size == 0) {
            return false;
        }

        Node<E> headNode = head;
        Node<E> prevNode = null;

        while (headNode != null) {

            if (headNode.value.equals(element)) {

                if (prevNode == null) {
                    head = headNode.next;
                } else {
                    prevNode.next = headNode.next;
                }
                size--;
                return true;
            } else {
                prevNode = headNode;
                headNode = headNode.next;
            }
        }
        return false;
    }

    public String toString() {
        if (head == null) {
            return "[]"; // Если список пуст, возвращаем пустые квадратные скобки
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.value);
            if (currentNode.next != null) {
                sb.append(", "); // Добавляем запятую и пробел между элементами
            }
            currentNode = currentNode.next;
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedListRepeat<Integer> list = new MyLinkedListRepeat<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(10);
        list.remove(2);
        System.out.println(list);
    }
}
