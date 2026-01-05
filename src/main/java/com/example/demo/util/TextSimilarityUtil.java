package com.example.demo.util;

public class TextSimilarityUtil {
  public static double similarity(String a, String b) {
    if (a == null || b == null)
      return 0.0;
    a = a.toLowerCase();
    b = b.toLowerCase();
    String[] sa = a.split("\\W+");
    String[] sb = b.split("\\W+");
    java.util.Set<String> setA = new java.util.HashSet<>(java.util.Arrays.asList(sa));
    java.util.Set<String> setB = new java.util.HashSet<>(java.util.Arrays.asList(sb));
    java.util.Set<String> inter = new java.util.HashSet<>(setA);
    inter.retainAll(setB);
    int total = Math.max(1, Math.max(setA.size(), setB.size()));
    return (double) inter.size() / (double) total;
  }
}


package com.example.demo.util;

public  class TextSimilarityUtil.java;
public static double similarity(String a,String b){
  
}
