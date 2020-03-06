package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();
        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("squares.size() = " + squares.size());
        System.out.println("cubes.size() = " + cubes.size());

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("union.size() = " + union.size());

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        for(int number : intersection){
            System.out.println(number + " is the square of " + Math.sqrt(number) + " and is the cube of " + Math.cbrt(number) );
        }

        Set<Integer> asymmetricDifference = new HashSet<>(squares);
        asymmetricDifference.removeAll(cubes);
        System.out.println("asymmetricDifference.size() = " + asymmetricDifference.size());

        Set<Integer> symmetricDifference = new HashSet<>(union);
        symmetricDifference.removeAll(intersection);
        System.out.println("symmetricDifference.size() = " + symmetricDifference.size());

        System.out.println("squares.contains(intersection) = " + squares.containsAll(intersection));
        System.out.println("asymmetricDifference.contains(intersection) = " + asymmetricDifference.containsAll(intersection));

    }
}
