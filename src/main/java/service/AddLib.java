package service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import model.Book;
import model.Librarys;

public class AddLib {
	static Scanner sc = new Scanner(System.in);

	public static Map<Librarys, Set<Book>> addLibrary(Map<Librarys, Set<Book>> libBookMap) {
		Map<Librarys, Set<Book>> map = new HashMap<Librarys, Set<Book>>();

		System.out.println("Enter the lib id");
		int id = sc.nextInt();
		System.out.println("Enter the lib name");
		String name = sc.next();



		Librarys lib = new Librarys(id, name);

		if (libBookMap.isEmpty()) {

			Set<Book> books = addBooks();

			

			map.put(lib, books);
			return map;
		}
		else {
			
			for (Librarys lib1 : libBookMap.keySet()) {
				
			//	if (libBookMap.containsKey(lib)) {
				if (lib1.getId()==lib.getId()||lib1.getName().equals(lib.getName())) {
					System.out.println("lib id or lib name Already exist...");
						
					return libBookMap;
				} 
				else {
					Set<Book> books = addBooks();


					map.put(lib, books);
					return map;
				}
			}
			
		}
		return null;
	}

	private static Set<Book> addBooks() {
		Set<Book> books = new LinkedHashSet<Book>();
		System.out.println("Enter the how many books you want to add in this lib:");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			System.out.println("Enter the id");
			int id = sc.nextInt();
			System.out.println("Book name");
			String name = sc.next();
			System.out.println("price");
			int price = sc.nextInt();
			books.add(new Book(id, name, price));
		}
		return books;
	}

	public static void Display(Map<Librarys, Set<Book>> libBookMap1) {
		
		Map<Librarys, Set<Book>> libBookMap = sortValues(libBookMap1);
		
		Iterator<Librarys> keyit = libBookMap.keySet().iterator();

		while (keyit.hasNext()) {

			Librarys libtemp = keyit.next();
			System.out.println("=========================");
			System.out.println(libtemp.toString());
			Set<Book> book = libBookMap.get(libtemp);
			System.out.println("========Books for above LIB========");
			for (Book b : book) {
				System.out.println(b.toString());
			}
			System.out.println("=========================");
		}

	}

	private static Map sortValues(Map map)   
	{   
	List list = new LinkedList(map.entrySet());  
	//Custom Comparator  
	Collections.sort(list, new Comparator()   
	{  
	public int compare(Object o1, Object o2)   
	{  
	return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());  
	}  
	});  
	//copying the sorted list in HashMap to preserve the iteration order  
	Map <Librarys, Set<Book>> sortedHashMap = new HashMap <Librarys, Set<Book>>();  
	for (Iterator it = list.iterator(); it.hasNext();)   
	{  
	 Map.Entry entry = (Map.Entry) it.next();  
	sortedHashMap.put(entry.getKey(), entry.getValue());  
	}   
	return sortedHashMap;  
	}  
	
}
