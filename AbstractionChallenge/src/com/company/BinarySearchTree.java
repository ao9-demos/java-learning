package com.company;

public class BinarySearchTree<E> implements NodeList<E> {
    private int size;
    private ListItem root;
    private ListItem currentItem;

    public BinarySearchTree() {
        this.size = 0;
        this.root = null;
        this.currentItem = null;
    }

    @Override
    public boolean addItem(E value) {
        resetCurrentItem();
        ListItem newItem = new Node(value);
        if (size == 0) {
            root = newItem;
            resetCurrentItem();
            size += 1;
            return true;
        } else {
            while (true) {
                int compare = newItem.compareTo(currentItem);
                if (compare == 0) {
                    System.out.println("Error, item " + newItem.getValue() + " already exists");
                    resetCurrentItem();
                    return false;
                } else if (compare < 0) {
                    if (!hasLeft()) {
                        currentItem.setLeftLink(newItem);
                        resetCurrentItem();
                        size += 1;
                        return true;
                    } else {
                        left();
                    }
                } else {
                    if (!hasRight()) {
                        currentItem.setRightLink(newItem);
                        resetCurrentItem();
                        size += 1;
                        return true;
                    } else {
                        right();
                    }
                }
            }
        }
    }

    @Override
    public boolean removeItem(E value) {
        resetCurrentItem();
        ListItem parentItem = currentItem;
        ListItem checkItem = new Node(value);
        while (true) {
            int compare = checkItem.compareTo(currentItem);
            if (compare < 0) {
                if (hasLeft()) {
                    parentItem = currentItem;
                    currentItem = currentItem.getLeftLink();
                } else {
                    System.out.println("Error, no such item");
                    resetCurrentItem();
                    return false;
                }
            } else if (compare > 0) {
                if (hasRight()) {
                    parentItem = currentItem;
                    currentItem = currentItem.getRightLink();
                } else {
                    System.out.println("Error, no such item");
                    resetCurrentItem();
                    return false;
                }
            } else {
                performRemoval(parentItem);
                resetCurrentItem();
                size -= 1;
                return true;
            }
        }
    }

    private void performRemoval(ListItem parentItem) {
        if (!hasRight()) {
            int compare = parentItem.compareTo(currentItem);
            if (compare > 0) {
                parentItem.setLeftLink(currentItem.getLeftLink());
            } else if (compare < 0) {
                parentItem.setRightLink(currentItem.getLeftLink());
            } else {
                root = currentItem.getLeftLink();
            }
            currentItem.setLeftLink(null);
        } else if (!hasLeft()) {
            int compare = parentItem.compareTo(currentItem);
            if (compare > 0) {
                parentItem.setLeftLink(currentItem.getRightLink());
            } else if (compare < 0) {
                parentItem.setRightLink(currentItem.getRightLink());
            } else {
                root = currentItem.getRightLink();
            }
            currentItem.setRightLink(null);
        } else {
            ListItem mostRightItem = currentItem.getLeftLink();
            ListItem mostRightParent = currentItem;
            while (mostRightItem.getRightLink() != null) {
                mostRightParent = mostRightItem;
                mostRightItem = mostRightItem.getRightLink();
            }

            int compare = mostRightParent.compareTo(mostRightItem);
            if (compare > 0) {
                mostRightParent.setLeftLink(mostRightItem.getLeftLink());
            } else if(compare <0){
                mostRightParent.setRightLink(mostRightItem.getLeftLink());
            }

            compare = parentItem.compareTo(currentItem);
            if (compare > 0) {
                parentItem.setLeftLink(mostRightItem);
            } else if (compare < 0) {
                parentItem.setRightLink(mostRightItem);
            } else {
                root = mostRightItem;
            }

            mostRightItem.setLeftLink(currentItem.getLeftLink());
            mostRightItem.setRightLink(currentItem.getRightLink());

            currentItem.setLeftLink(null);
            currentItem.setRightLink(null);
        }
    }

    @Override
    public void traverse(E value) {
        ListItem root = findItem(value);
        traverse(root);
    }

    private void traverse(ListItem root) {
        if (root != null) {
            traverse(root.getLeftLink());
            System.out.println(root.getValue());
            traverse(root.getRightLink());
        }
    }

    private ListItem findItem(E value) {
        resetCurrentItem();
        ListItem checkItem = new Node(value);
        int compare = checkItem.compareTo(currentItem);
        while (true) {
            if (compare < 0) {
                if (hasLeft()) {
                    currentItem = currentItem.getLeftLink();
                } else {
                    System.out.println("Error, no such item");
                    return null;
                }
            } else if (compare > 0) {
                if (hasRight()) {
                    currentItem = currentItem.getRightLink();
                } else {
                    System.out.println("Error, no such item");
                    return null;
                }
            } else {
                ListItem temp = currentItem;
                resetCurrentItem();
                return temp;
            }
        }
    }

    @Override
    public E left() {
        currentItem = currentItem.getLeftLink();
        return (E) currentItem.getValue();
    }

    @Override
    public E right() {
        currentItem = currentItem.getRightLink();
        return (E) currentItem.getValue();
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

    public void resetCurrentItem() {
        this.currentItem = this.root;
    }

    public E getCurrentValue() {
        return (E) this.currentItem.getValue();
    }
}
