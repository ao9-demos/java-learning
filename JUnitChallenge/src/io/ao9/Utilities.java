package io.ao9;

public class Utilities {
    public char[] everyNthChar(char[] sourceArray, int n){
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length/n;
        char[] result = new char[returnedLength];

        int j = 0;
        for(int i=n-1; i<sourceArray.length; i+=n){
            result[j++] = sourceArray[i];
        }

        return result;
    }

    public String removePairs(String source){
        if(source == null || source.length()<2) return source;

        StringBuilder sb = new StringBuilder();
        char[] chars = source.toCharArray();

        for(int i=0; i<source.length()-1; i++){
            if(chars[i]!=chars[i+1]){
                sb.append(chars[i]);
            }
        }
        sb.append(chars[source.length()-1]);

        return sb.toString();
    }

    public int converter(int a, int b){
        return (a/b)+(a*30)-2;
    }

    public String nullIfOddLength(String source){
        if(source ==null || source.length() % 2 != 0){
            return null;
        }

        return source;
    }
}
