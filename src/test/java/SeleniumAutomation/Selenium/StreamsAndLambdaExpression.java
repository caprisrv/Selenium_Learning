package SeleniumAutomation.Selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAndLambdaExpression {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Ankit");
		names.add("Abhishek");
		names.add("Shweta");
		names.add("Saurabh");
		names.add("Yuvaan");
		Iterator<String> it= names.iterator();
		int count=0;
		
		while(it.hasNext()) {
			String names1 = it.next();
			System.out.println(names1);
			
			if(names1.startsWith("a") || names1.startsWith("A")){
				count++;
			}
		}
		
		System.out.println(count);
		
		//Java 8 Code
		
		//count the names whose name starts with A
		System.out.println("-----------------------------------------");
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		//count the names whose names length is > 7
		System.out.println("-----------------------------------------");
		Long d=names.stream().filter(s->s.length()>7).count();
		System.out.println(d);
		
		//print the names whose names length is > 5
		System.out.println("-----------------------------------------");
		names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		
		//print the 2 names only whose names length is > 5
		System.out.println("-----------------------------------------");
		names.stream().filter(s->s.length()>5).limit(2).forEach(s->System.out.println(s));
		
		//print names which ends with "a" with upper case
		System.out.println("-----------------------------------------");
		
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names which have first letter as a with upper cases and sorted
		System.out.println("-----------------------------------------");
		
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merge two array list
		System.out.println("-----------------------------------------");
		
		List<String> names1 = Arrays.asList("Aashish","Suman","Swati","Rakesh","Vaibhav");
		
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		System.out.println("-----------------------------------------");
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Yuvaan"));
		System.out.println(flag);
		
		//use of collect method
		System.out.println("-----------------------------------------");
		List<String> namesCollect = Arrays.asList("Aashish","Suman","Swati","Rakesh","Vaibhav");
		List<String> l=namesCollect.stream().filter(s->s.endsWith("h")).map(s->s.toUpperCase()).collect(Collectors.toList());
		l.get(1);
		
		System.out.println("-----------------------------------------");
		//print unique number 
		//print sorted number
		
		List<Integer> values = Arrays.asList(1,2,3,3,3,4,5,6,7,9,7);
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		
	}

}
