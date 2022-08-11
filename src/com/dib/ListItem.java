package com.dib;
/*
mimi dib
created on 7/29/22
 */
public abstract class ListItem {
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;
// protected to be able to access from concrete subclass
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    //any concrete class that implements this class will need a constructor to set field 'value'
    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

