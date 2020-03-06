package ca.aodong;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int[] a = new int[]{1,2,3,4,5};
	int[] b = a;
	b[2] = 33;
        System.out.println("a = " + Arrays.toString(a));
    }
}
