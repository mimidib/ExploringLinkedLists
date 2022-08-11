package com.dib;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override //acting like a getter
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override //acting like a getter
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if(item != null){ //compare current value with the parameter value //String's compareTo() returns:
            // -1 if item sorts b4 obj | +1 num (0>) if item sorts after obj | 0 if item == obj
            return ((String) super.getValue()).compareTo((String) item.getValue());
            //render 'value' field a String to get effective comparison from type Object
        }else{
            return -1;
        }
    }
}
