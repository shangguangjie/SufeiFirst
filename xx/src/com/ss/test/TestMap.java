package com.ss.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Join;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Ints;

public class TestMap {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();
        map.put("num", "1");
        String num = (String)map.get("num");
        if(num.equals("1")) {
            System.out.println("yes");
        }
        if(map.get("num").equals("1")) {
            System.out.println("no");
        }
        
        System.out.println("------------List&Map-------------");
        ImmutableList of1 = ImmutableList.of("a", 1, "b", 1);
        ImmutableMap of2 = ImmutableMap.of("num", "1");
        String str1 = (String)of2.get("num");
        System.out.println(of1.get(1));
        System.out.println(str1);
        
//        File file = new File(getClass().getResource("/test.txt").getFile());
//        List lines = null;
//        lines = Files.readLines(file, Charsets.UTF_8);
        
        System.out.println("------------Joiner&Splitter-------------");
        int[] numbers = { 1, 2, 3, 4, 5 };  
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
        String numbersAsStringDirectly = Ints.join(";", numbers);
        System.out.println(numbersAsString);
        System.out.println(numbersAsStringDirectly);
        
        String testString = "foo , what,,,more,"; 
        Iterable split = Splitter.on(",").omitEmptyStrings().trimResults().split(testString);
        Iterator iterator = split.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        System.out.println("------------Ints-------------");
        int compare = Ints.compare(15, 10);
        System.out.println(compare);
        int[] array = { 1, 2, 3, 4, 5 };
        int[] array2 = { 1, 2, 3, 4, 5 };
        int a = 4;
        boolean contains = Ints.contains(array, a);
        int indexOf = Ints.indexOf(array, a);
        int max = Ints.max(array);
        int min = Ints.min(array);
        int[] concat = Ints.concat(array, array2);
        System.out.println(contains);
        System.out.println(indexOf);
        System.out.println(max);
        System.out.println(min);
        for (int i : concat) {
            System.out.println(i);
        }
        
        System.out.println("-------------验证与条件检查--------------");
        int count = 0;
//        Preconditions.checkArgument(count > 0, "must be positive: %s", count);
        
        System.out.println("-------------Multimap--------------");
        Multimap multimap = ArrayListMultimap.create();
        multimap.put("a", "1");
        multimap.put("a", "2");
        System.out.println(multimap.get("a"));
        
        System.out.println("--------------Join--------------------");
        ImmutableList items = ImmutableList.of("A", "B", "C", "D");
        String join = Join.join(",", items);
        System.out.println(join);
        
        System.out.println("---------------Function闭包-------------------");
        Function<String, Boolean> isPalindrome = new Function<String, Boolean>() {  
            public Boolean apply(String from) {  
                Preconditions.checkNotNull(from);  
                return new StringBuilder(from).reverse().toString().equals(from);  
            }  
        };  
        List<String> from = Lists.newArrayList("rotor", "radar", "hannah", "level", "botox");  
        List<Boolean> to = Lists.transform(from, isPalindrome);  
        for (int i = 0; i < from.size(); i++) {  
            System.out.printf("%s is%sa palindrome\n", from.get(i), to.get(i) ? " " : " NOT ");  
        }   
        // changes in the "from" list are reflected in the "to" list  
        System.out.printf("\nnow replace hannah with megan...\n\n");  
        from.set(2, "megan");  
        for (int i = 0; i < from.size(); i++) {  
            System.out.printf("%s is%sa palindrome\n", from.get(i), to.get(i) ? " " : " NOT ");  
        }  
    }
    
    @Test
    public void test(){
        assertEquals("test", Strings.emptyToNull("test"));  
        assertEquals(" ", Strings.emptyToNull(" "));  
        assertNull(Strings.emptyToNull(""));  
        assertNull(Strings.emptyToNull(null));
        
        assertFalse(Strings.isNullOrEmpty("test"));  
        assertFalse(Strings.isNullOrEmpty(" "));  
        assertTrue(Strings.isNullOrEmpty(""));  
        assertTrue(Strings.isNullOrEmpty(null)); 
        
        assertEquals("test", Strings.nullToEmpty("test"));  
        assertEquals(" ", Strings.nullToEmpty(" "));  
        assertEquals("", Strings.nullToEmpty(""));  
        assertEquals("", Strings.nullToEmpty(null));  
        
        assertEquals("Ralph_____", Strings.padEnd("Ralph", 10, '_'));  
        assertEquals("Bob_______", Strings.padEnd("Bob", 10, '_'));  
           
        assertEquals("_____Ralph", Strings.padStart("Ralph", 10, '_'));  
        assertEquals("_______Bob", Strings.padStart("Bob", 10, '_'));  
          
        assertEquals("xyxyxyxyxy", Strings.repeat("xy", 5));  
    }
}
