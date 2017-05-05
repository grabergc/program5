//Garrett Graber, CSC 220
//4-27-2017 
//A variation of the List class authored by Dr. Weber that includes an addBeforeNext and remove method.
//If it doesn't work at first, try again. The program can be a little sensitive. 
//Acknowledgements: Dr. Weber, Seth Rhodes, Skyler Knecht

package csc220.program5.grabergc;

import csc220.list.AddIterator;
import csc220.list.Node;
import java.util.NoSuchElementException;

public class List<E> extends csc220.list.List<E> { 
       
   @Override
   public AddIterator<E> addIterator(){return new ListAddIterator<>();}
   
   
   //  This nested class replaces the one in csc220.list.List
   protected class ListAddIterator<T extends E> extends csc220.list.List<E>.ListAddIterator<E> {
       
       private static final boolean DEBUGGING = true;
      
        protected Node<E> prevNode = null;
        
        @Override
        public E next() {
            prevNode= nextNode;
            return super.next();
        }

        // For debugging purposes.
        private void printNodes(String s) {
            if (!DEBUGGING)
                return;
            System.out.print(s);
            if (prevNode != null) {
                System.out.print("--previous data = " + prevNode.data);
            }
            if (nextNode != null) {
                System.out.print("--next data = " + nextNode.data);               
            }
            System.out.println("");
        }
        
        @Override 
        public void addBeforeNext(E e) {
           if (!hasNext()) {
                throw new NoSuchElementException();
            }
            
            Node<E> newNode = new Node();
            newNode.data = e;
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            
        
            
   
       
            
            
        }

        @Override
        public void remove() {
            Node tmpNode = new Node();
            
            //Test if there's a null
            if(prevNode == null){
               throw new NoSuchElementException("Nothing there"); 
            }
            //See if there's one in the middle.
            if(prevNode == nextNode){
                tmpNode.next = nextNode;
                prevNode =  null;
            }
            //Delete First Node 
            if(first == prevNode){
                first = prevNode.next;
                prevNode = null;
            } 
            //Delete Last Node
            if(last == prevNode){
               last = nextNode;
               prevNode = null;
           } 
         
        }
     }
   
   
   }
