package com.company;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    public void setLeftLink(ListItem leftLink) {
        this.leftLink = leftLink;
    }

    @Override
    public void setRightLink(ListItem rightLink) {
        this.rightLink = rightLink;
    }

    @Override
    public ListItem getLeftLink() {
        return this.leftLink;
    }

    @Override
    public ListItem getRightLink() {
        return this.rightLink;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public int compareTo(ListItem item) {
        if (item == null) {
            return -1;
        } else {
            return String.valueOf(this.value).compareTo(String.valueOf(item.value));
        }
    }


}
