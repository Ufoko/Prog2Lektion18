package opgave03.models;

import opgave02.QueueDouble;

public class DequeImplemented<E> implements Deque<E> {


    private Node head;
    private Node tail;


    public class Node<E> {

        private Node nextNode;
        private Node prevNode;
        private E element;

        public Node(Node nextNode, Node prevNode, E element) {
            this.nextNode = nextNode;
            this.prevNode = prevNode;
            this.element = element;
        }

        public void setSentinel() {
            this.nextNode = this;
            this.prevNode = this;
            this.element = null;
        }

    }


    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFirst(E newElement) {
        Node newNode = new Node(null, null, newElement);
        if (!firstElementAdded(newNode)) {
            Node tempNode = head;
            head = newNode;
            head.nextNode = tempNode;
            tempNode.prevNode = newNode;
        }
    }

    @Override
    public void addLast(E newElement) {
        Node newNode = new Node(null, null, newElement);
        if (!firstElementAdded(newNode)) {
            Node tempNode = tail;
            tail = newNode;
            tail.prevNode = tempNode;
            tempNode.nextNode = newNode;
        }

    }


    private boolean firstElementAdded(Node newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        return isEmpty();
    }


    @Override
    public E removeFirst() {

        Node removedNode = head;
        head = removedNode.nextNode;
        head.prevNode = null;

        return (E) removedNode.element;
    }

    @Override
    public E removeLast() {
        Node removedNode = tail;
        tail = removedNode.prevNode;
        tail.nextNode = null;

        return (E) removedNode.element;
    }

    @Override
    public E getFirst() {
        return (E) head.element;
    }

    @Override
    public E getLast() {
        return (E) tail.element;
    }

    @Override
    public int size() {
        int theSize = 0;

        Node curNode = head;
        while (curNode.nextNode != null) {
            theSize++;
            curNode = curNode.nextNode;
        }

        return theSize;
    }
}
