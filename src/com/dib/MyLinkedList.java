package com.dib;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        //check for an empty ListItem as the head of the list
        if (this.root == null) {
            //the list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) { //while every link we land on is not empty
            //compare current to param newItem
            int comparison = (currentItem.compareTo(newItem));

            //testing the result of comparison
            if (comparison < 0) {//if comparison < 0 , still newItem > current
                // continue to process comparisons through list if:
                if (currentItem.next() != null) {//if we can move forward to the next item
                    //continue by comparing the next item
                    currentItem = currentItem.next();

                } else { //we reached the end of the list,

                    // insert newItem at end of list
                    currentItem.setNext(newItem).setPrevious(currentItem); // shortcut version of  below commented out.
                    // this ^ works because setNext gives a return of the item we are setting as Next (the item in parenthesis gets returned), so we can then do .setPrevious() as if newItem.setPrevious()

                    /*currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);*/
                    return true;
                }
            } else if (comparison > 0) {//meaning newItem < currentItem
                // place newItem b4 currentItem's place

                //check if current item has a previous position first
                if (currentItem.previous() != null) {
                    //get the item b4 currentItem to link next to newItem
                    ListItem itemBeforeCurrent = currentItem.previous();
                    itemBeforeCurrent.setNext(newItem).setPrevious(itemBeforeCurrent);
                    newItem.setNext(currentItem).setPrevious(newItem);

                    /* shortcut ^^
                    itemBeforeCurrent.setNext(newItem);

                    //set newItem between itemBeforeCurrent and currentItem
                    newItem.setPrevious(itemBeforeCurrent);
                    newItem.setNext(currentItem);

                    //set currentItem after newItem
                    currentItem.setPrevious(newItem);*/

                    //currentItem's next() should be the same
                } else { //if current item has no previous, it is the first item (root)
                    //the node without previous is the root, set newItem as root, and the old root as the second item
                    newItem.setNext(this.root).setPrevious(newItem);
                    //this.root.setPrevious(newItem); shortcut ^
                    this.root = newItem; //set new item as root
                }
                //whether we inserted it at the head or in the middle of the list, it was inserted correctly
                return true;
            } else {
                //equal  so don't add
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        //traverse the list until we find the ite, to be removed
        //then we set the previous link to point next to the nextItem's next()

        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem != null) { //while there's still records in list to traverse
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                //we have a match on item to delete
                if (currentItem == this.root) { //if this is the root item
                    this.root = currentItem.next(); // making the root item be the second item in the list
                } else { //if not root, and there is a previous item
                    //make the previous item refer next to the currentItems next link
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0 ){ //we haven't reached the right point of the list yet
                currentItem = currentItem.next(); //continue traversing
            } else { //if comparison is > 0
                //we went past the point we could've deleted it
                //we are at an item greater than the one to be deleted
                // so the item isn't in the list
                return false;
            }
        }
        //we reached the end of the list without finding item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) { //to display linked list
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            //check we have data
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
