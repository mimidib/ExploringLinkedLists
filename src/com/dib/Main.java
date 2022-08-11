package com.dib;


public class Main {
    //this application uses a home-made linkedList class to hold a list of numbers and sort them in ascending order
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot()); //list is empty here

        //splitting the cities of Canada by space - adding list items
        String stringData = "5 7 3 9 8 2 1 0 4 6";
        String[] data = stringData.split(" "); //returns a string Array of individual items of String, split where there's a space character
        for (String s : data){ //each list item is assigned to 's' value
            //create new item with value set to the string s
            list.addItem(new Node(s)); //add that list item to MyLinkedList
        }
        //traverse the list starting at the root index of the list
        list.traverse(list.getRoot());

        //below code is a test to validate the deletion of numbers at different places in list works
//        list.removeItem(new Node("3"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("5"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("0"));
//        list.removeItem(new Node("4"));
//        list.removeItem(new Node("2"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("9"));
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("8"));
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("6"));
//        list.traverse(list.getRoot());
//        list.removeItem(list.getRoot());
//        list.traverse(list.getRoot());
//        list.removeItem(list.getRoot());
//        list.traverse(list.getRoot());
    }
}
