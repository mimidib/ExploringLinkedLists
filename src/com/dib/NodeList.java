package com.dib;

public interface NodeList {
    //any data structure we create must have a starting node,
    // that's what we're putting in the ListItem, the getRoot.
    ListItem getRoot();
    boolean addItem(ListItem newItem);
    boolean removeItem(ListItem item);

    //to go through the list
    void traverse(ListItem root);

    //in case of the LinkList, this is often called the head of the list but
    // using the term root is also used a lot and actually applies to binary search trees
}
