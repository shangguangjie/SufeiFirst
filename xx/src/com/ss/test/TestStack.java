package com.ss.test;

import java.util.Stack;

public class TestStack {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("ee");
        stack.push('e');
        Object[] objs = stack.toArray();
        String [] strs=new String[objs.length];
        for(int i=0;i<objs.length;i++){
             strs[i]=objs[i].toString();
        }
        System.out.println(stack.capacity());
        System.out.println(stack.get(1));
        System.out.println(stack.size());
        System.out.println((strs[0]));
    }
}
