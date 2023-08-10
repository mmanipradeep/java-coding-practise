package com.practise.code.functionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class java8FunctionalExample {

	public static void main(String args[]) {

		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(3);
		integerList.add(5);
		integerList.add(2);

		Function<List<Integer>, Integer> sumCalculator = list -> list.stream().mapToInt(Integer::intValue).sum();

		int result = sumCalculator.apply(integerList);
		System.out.println(result);

	}

}
