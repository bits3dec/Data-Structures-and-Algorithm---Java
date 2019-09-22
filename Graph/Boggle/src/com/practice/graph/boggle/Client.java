package com.practice.graph.boggle;

import java.util.Set;
import java.util.HashSet;

public class Client {
	public static void main(String[] args) {
		char boggle[][] = { { 'G', 'I', 'Z' }, 
							{ 'U', 'E', 'K' }, 
							{ 'Q', 'S', 'E' } 
						  }; 
		
		Set<String> lookup = new HashSet<>();
		lookup.add("GEEKS");
		lookup.add("FOR");
		lookup.add("QUIZ");
		lookup.add("GUQ");
		lookup.add("EE");

		System.out.println("Following words of dictionary are present"); 	
		Boggle.findWords(boggle, lookup);
	}
}
