package com.practise.code.functionalprogramming;

import java.util.ArrayList;
import java.util.List;

interface Calculator {

	int calculator(List<Integer> numbers);

}

public class Java7FunctionalInterfaceExample {

	public static void main(String args[]) {

		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(3);
		integerList.add(5);
		integerList.add(2);

		Calculator sumCalculator = new Calculator() {

			@Override
			public int calculator(List<Integer> numbers) {
				int sum = 0;
				for (Integer number : numbers) {
					sum += number;
				}
				return sum;
			}

		};
		int result = sumCalculator.calculator(integerList);
		System.out.println(result);
	}
}
