//Dictionary.java
//Michael Shen
//mjshen
//cs12b
//pa3

public class Dictionary implements DictionaryInterface {

   private class Node {
      String key;
      String value;
      Node next;

      Node(String x, String y){
         key = x;
         value = y;
         next = null;
      }
   }

   private Node head;     
   private int numItems;  

   public Dictionary(){
      head = null;
      numItems = 0;
   }


   private Node findKey(String key){
      Node N = head;
      while(N != null){
         if(N.key.equals(key)){
            return N;
         }
         else{
            N = N.next;
         }
      }
      return null;
   }


   public boolean isEmpty(){
      return(numItems == 0);
   }

   public int size() {
      return numItems;
   }

   public String lookup(String key){
      Node N = findKey(key);
      if(N == null){
         return null;
      }
      else{
         return N.value;
      }
   }

   public void insert(String key, String value) throws DuplicateKeyException{
      if(lookup(key) != null){
         throw new DuplicateKeyException("cannot insert duplicate keys " + key);
      }
      else if(numItems==0){
         Node N = new Node(key,value);
         head = N;
         numItems++;
      }
      else{
         Node M = new Node(key, value);
         Node h = head;
         while(h.next != null){
            h = h.next;
         }
         h.next = M;
         numItems++;
      }
   }

   public void delete(String key) throws KeyNotFoundException{
      if(findKey(key)==null){
         throw new KeyNotFoundException("cannot delete non-existent key");
      }
      else if(numItems==1){
         head = null;
         numItems--;
      }
      else{
         Node N = head;
         Node h = head.next;
         if(N.key==key){
            head = head.next;
            numItems--;
         }
         while(h!=null){
            if(h.key==key){
               N.next = h.next;
               numItems--;
               break;
            }
            else{
               h = h.next;
               N = N.next;
            }
         }
      }
   }

   public void makeEmpty(){
      head = null;
      numItems = 0;
   }

   public String toString(){
      StringBuffer sb = new StringBuffer();
      Node N = head;
      for( ;N!=null; N=N.next){
         sb.append(N.key).append(" ").append(N.value).append("\n");
      }
      return new String(sb);
   }
}
# Linked_List_Dictionary
