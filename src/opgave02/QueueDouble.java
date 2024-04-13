package opgave02;

import opgave01.models.Queue;
import opgave01.models.QueueSingle;

import java.util.NoSuchElementException;

public class QueueDouble<E> implements Queue<E> {


    private Node head;
    private Node tail;

    private Node Sentinel;

    public QueueDouble() {
        Sentinel.setSentinel();
    }

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
    public void add(E element) {
        Node newNode = new Node(Sentinel, Sentinel, element);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.prevNode = Sentinel;
            newNode.nextNode = Sentinel;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
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
        head.prevNode = Sentinel;

        if (head.equals(Sentinel)) {
            head = null;
            tail = null;
        }

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
        while (curNode.nextNode != Sentinel) {
            theSize++;
            curNode = curNode.nextNode;
        }

        return theSize;
    }


}
