package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        //if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    public static boolean isPalindrome(long num){
        String str = num+"";
        int strLen = str.length();

        if (strLen % 2 != 0) return false;
        for (int i = 0; i< strLen/2; i++){
            if (str.charAt(i) != str.charAt(strLen-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // Calculate prime numbers
        List<Integer> primes = new ArrayList<Integer>();
	    for(int i = 10000; i < 100000; i++){
	        if (isPrime(i)) primes.add(i);
        }

        // Calculate composition of 2 prime numbers and show on console if it is palindrome
        int primesLen = primes.size();
        long maxComposition = 0l; // is palindrome
        int multiplier1 = 0;
        int multiplier2 = 0;
        long composition;
        for (int i = 0; i<primesLen; i++){
            for (int j = i; j<primesLen; j++){
                composition = (long) primes.get(i) * primes.get(j);
                if (isPalindrome(composition)) {
                    System.out.println(composition);
                    if (maxComposition < composition) {
                        maxComposition = composition;
                        multiplier1 = primes.get(i);
                        multiplier2 = primes.get(j);
                    }
                }
            }
        }

        // Show results
        if (maxComposition>=10000*10000){
            System.out.println("maxComposition = "+maxComposition+
                    " multiplier1 = " +multiplier1 + " multiplier2 = " +multiplier2);
        } else {
            System.out.println("maxComposition not found");
        }
    }
}