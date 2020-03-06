package com.company;

public class MyLinkedList<E> implements NodeList<E>{
    private int size;
    private ListItem currentItem;
    private ListItem firstItem;
    private ListItem root;
    private ListItem lastItem;

    public MyLinkedList() {
        this.size = 0;
        this.firstItem = null;
        this.lastItem = null;
        this.root = new Node(null);
        this.currentItem = root;
    }

    @Override
    public boolean addItem(E value) {
        currentItem = root;
        ListItem newItem = new Node(value);
        if (size == 0) {
            firstItem = newItem;
            firstItem.setLeftLink(root);
            root.setRightLink(firstItem);
            lastItem = newItem;
            size += 1;
            return true;
        } else {
            ListItem checkItem = firstItem;
            while (true) {
                int compare = newItem.compareTo(checkItem);
                if (compare == 0) {
                    System.out.println("Error: Item " + newItem.getValue() + " already exists");
                    return false;
                } else if (compare < 0) {
                    newItem.setLeftLink(checkItem.getLeftLink());
                    checkItem.getLeftLink().setRightLink(newItem);
                    newItem.setRightLink(checkItem);
                    checkItem.setLeftLink(newItem);

                    if (checkItem == firstItem) {
                        firstItem = newItem;
                    }

                    size += 1;
                    return true;

                } else if (compare > 0) {
                    if (checkItem == lastItem) {
                        newItem.setLeftLink(checkItem);
                        checkItem.setRightLink(newItem);
                        lastItem = newItem;
                        return true;
                    } else {
                        checkItem = checkItem.getRightLink();
                    }
                }
            }
        }
    }

    @Override
    public boolean removeItem(E value) {
        ListItem foundItem = findItem(value);
        if (foundItem == null) {
            System.out.println("Error, item " + value + " doesn't exist");
            return false;
        } else {
            if (foundItem.getLeftLink() != null) {
                foundItem.getLeftLink().setRightLink(foundItem.getRightLink());
            }
            if (foundItem.getRightLink() != null) {
                foundItem.getRightLink().setLeftLink(foundItem.getLeftLink());
            }
            if (foundItem == firstItem) {
                firstItem = foundItem.getRightLink();
            }
            if (foundItem == lastItem) {
                if (lastItem != firstItem) {
                    lastItem = foundItem.getLeftLink();
                } else {
                    lastItem = null;
                }
            }
            foundItem.setLeftLink(null);
            foundItem.setRightLink(null);
            size -= 1;
            return true;
        }
    }

    private ListItem findItem(E value) {
        currentItem = root;
        while (hasRight()) {
            int compare = String.valueOf(right()).compareTo(String.valueOf(value));
            if (compare == 0) {
                ListItem temp = currentItem;
                currentItem = root;
                return temp;
            }
        }
        currentItem = root;
        return null;
    }

    @Override
    public void traverse(E value) {

    }

    @Override
    public E left() {
        E temp = (E) currentItem.getValue();
        currentItem = currentItem.getLeftLink();
        return temp;
    }

    @Override
    public E right() {
        E temp = (E) currentItem.getRightLink().getValue();
        currentItem = currentItem.getRightLink();
        return temp;
    }

    @Override
    public boolean hasLeft() {
        if (currentItem.getLeftLink() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean hasRight() {
        if (currentItem.getRightLink() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
