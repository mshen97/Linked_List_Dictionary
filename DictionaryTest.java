//DictionaryTest.java
//Michael Shen
//mjshen
//cs12b
//pa3


class DictionaryTest{
	public static void main(String[] args){
		String v;
		Dictionary A = new Dictionary();
		//Testing the isEmpty Function

		System.out.println(A.isEmpty());
		A.insert("1", "a");
		System.out.println(A.isEmpty());

		//Testing the A.size function
		
		System.out.println("List size is: " + A.size());
		A.insert("2", "b");
		A.insert("3", "c");
		//A.insert("1", "x"); //Induces DuplicateKeyException
		System.out.println("List size is: " + A.size());


		//Testing the A.lookup function
		v = A.lookup("1");
		System.out.println("key: 1 " + v==null?"not found" : "value = " + v);
		v = A.lookup("2");
		System.out.println("key: 2 " + v==null?"not found" : "value = " + v);
		v = A.lookup("3");
		System.out.println("key: 3 " + v==null?"not found" : "value = " + v);
		v = A.lookup("4");
		System.out.println("key: 4 " + v==null?"not found" : "value = " + v); //Induces null
		
		//Testing the A.delete function
		A.delete("1");
		System.out.println(A);
		A.delete("2");
		System.out.println(A);
		//A.delete("4"); Induces KeyNotFoundException

		//Testing A.makeEmpty function
		A.makeEmpty();
		System.out.println(A.isEmpty());

	}
}
