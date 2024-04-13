package opgave01.models;

import java.util.NoSuchElementException;

public class QueueSingle<E> implements Queue<E> {

    private Node head;
    private Node tail;


    public class Node<E> {

        private Node nextNode;
        private E element;

        public Node(Node nextNode, E element) {
            this.nextNode = nextNode;
            this.element = element;
        }
    }


    @Override
    public void add(E element) {
        Node newNode = new Node(null, element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
    }

    @Override
    public E remove() {

        if (isEmpty()) {
            throw new NoSuchElementException("Den er tom :D");
        }

        Node prevHead = head;
        head = prevHead.nextNode;


        return (E) prevHead.element;
    }

    @Override
    public E element() {

        if (isEmpty()) {
            throw new NoSuchElementException("Den er tom :D");
        }

        return (E) head.element;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
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
