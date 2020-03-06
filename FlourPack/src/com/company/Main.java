package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(canPack(1,0,4));
        System.out.println(canPack(1,0,5));
        System.out.println(canPack(0,5,4));
        System.out.println(canPack(-2,2,11));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal){
        boolean result = false;
        if(bigCount >= 0 && smallCount >= 0 && goal >= 0){
            int sumCount = bigCount * 5 + smallCount * 1;
            if (sumCount == goal) {
                result = true;
            } else if(sumCount > goal){
                for(int i=0; i<=bigCount; i++){
                    for(int j=0; j<= smallCount; j++){
                        if (i * 5 + j * 1 == sumCount - goal) {
                            result = true;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
