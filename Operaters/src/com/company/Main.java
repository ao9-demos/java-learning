package com.company;

public class Main {

    public static void main(String[] args) {
	int result = 10 % 3;
        System.out.println("result = " + result);

        System.out.println("result++ = " + result++);
        System.out.println("++result = " + ++result);
        System.out.println("(result+=10) = " + (result+=10));
        System.out.println("(result*=10) = " + (result*=10));

    if(result > 100 && result != 200) {
        System.out.println("result is valid");
    }

    if(result >100 || result <10) {
        System.out.println("hmmm");

    boolean isCar = false;
    if(!isCar) {
        System.out.println(isCar);
    } else {
        System.out.println("hmmm " + isCar);
    }

    boolean wasCar = isCar ? false : true;
    if(wasCar)  {
        System.out.println("wasCar = " + wasCar);
    }

    double d1 = 20d;
    double d2 = 80d;
    double d3 = 25 * (d1 + d2);
        System.out.println("d3 = " + d3);

    double remain = d3 % 40;
        System.out.println("remain = " + remain);

    if(remain<=20)  {
        System.out.println("Total was over the limit");
    }
    }
    }
}
