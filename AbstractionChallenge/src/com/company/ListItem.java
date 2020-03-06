package com.company;

public abstract class ListItem {
    protected ListItem leftLink;
    protected ListItem rightLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
        this.leftLink = null;
        this.rightLink = null;
    }

    public abstract void setLeftLink(ListItem leftLink);

    public abstract void setRightLink(ListItem rightLink);

    public abstract ListItem getLeftLink();

    public abstract ListItem getRightLink();

    public abstract Object getValue();

    public abstract int compareTo(ListItem item);

}
