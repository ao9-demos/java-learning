package com.company;

public interface NodeList<E> {
    boolean addItem(E value);
    boolean removeItem(E value);
    void traverse(E value);
    E left();
    E right();
    boolean hasLeft();
    boolean hasRight();
    int size();
}
