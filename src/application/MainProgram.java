package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import entities.Collaborator;

public class MainProgram {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Collaborator> list = new ArrayList<>();
		
		/*    Setting ClassPath (In my pc case, it was created a Folder named 
			  ".txt Files for Coding Tests" at Folder "C" to receive the File 
			  "collaborators-list.txt")
		*/
		String path = "C:\\.txt Files for Coding Tests\\collaborators-list.txt";
		 
		/*
			  Try With Resources Method with BufferedReader instanced by a FileReader 
			  instance with path variable as parameter
		*/
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		
		/*    For IO cases like BufferedReader and FileReader that need to be closed later,
			  in which Try Catch methods lead to verbose syntax due to a prolix Finally Method 
			  with another Try Catch in it, it is highly recommended that we apply the
			  Try With Resources Method passing those IO objects as parameters,
		      to solve the close cases in a efficient and resolute command
		*/
			String collaboratorCsv = br.readLine();
			
			//While loop designed to read all elements from the list line-by-line. 
			while (collaboratorCsv != null) {
			/*Technique used to assign the different elements from the CSV-style line
			  to a String Vector fields, separating those elements from one another using
			  "," as a separator 
			 */
				String[] fields = collaboratorCsv.split(",");
			 /*
			  Using the "fields" vector's elements as parameters to instance a new Collaborator Object 
			  and then adding it to the List<Collaborator> list
			  */
				list.add(new Collaborator(fields[0], Double.parseDouble(fields[1])));
			 /*
			  Using BufferedReader method readLine at br object to make collaboratorCsv jump to the next line
			  until it is null 
			 */
				collaboratorCsv = br.readLine();
			}
			 /*
			  Using Collections.sort() Method since Collaborator Class now implements Comparable Interface
			  */
			Collections.sort(list);
			
			//Read method using For Each
			for (Collaborator emp : list) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}
			//Generic RunTimeException Type "IOException" 
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}