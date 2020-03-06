package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBucket){
        int result = -1;
        if (width > 0 && height > 0 && areaPerBucket > 0 && extraBucket >= 0) {
            result = (int)Math.ceil((width * height) / areaPerBucket) - extraBucket;
        }
        return result;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        int result = -1;
        if (width > 0 && height > 0 && areaPerBucket > 0) {
            result = (int)Math.ceil((width * height) / areaPerBucket);
        }
        return result;
    }
    public static int getBucketCount(double area, double areaPerBucket){
        int result = -1;
        if (area > 0 && areaPerBucket > 0) {
            result = (int)Math.ceil(area / areaPerBucket);
        }
        return result;
    }
}
