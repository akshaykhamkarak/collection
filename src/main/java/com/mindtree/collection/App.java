package com.mindtree.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import model.Book;
import model.Librarys;
import service.AddLib;


public class App {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;
		Map<Librarys, Set<Book>> libBookMap = new HashMap<Librarys, Set<Book>>();

		do {
			Option.disply();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				libBookMap.putAll( AddLib.addLibrary(libBookMap));
				break;

			case 2:
				AddLib.Display(libBookMap);

				break;

			case 3:
				// AddLib.displyDataSortByPrice(libBookMap);
				break;
			case 4:
				System.out.println("Exit");
				break;
			default:
				System.out.println("You enter wrong choice");
				break;
			}

		} while (choice != 4);

	}

}
