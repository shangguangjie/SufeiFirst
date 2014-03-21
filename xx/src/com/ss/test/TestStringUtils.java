package com.ss.test;

import static org.junit.Assert.*;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * StringUtils学习
 * @author sufei
 *
 */
public class TestStringUtils {
    
    @Test
    public void testNullOrEmpty() {
        String str1 = "";
        String str2 = null;
        String str3 = "ss";
        assertTrue(StringUtils.isEmpty(str1));
        assertTrue(StringUtils.isEmpty(str2));
        assertTrue(StringUtils.isNotEmpty(str3));
    }
    
    @Test
    public void testNullOBlank() {
        String str1 = " ";
        String str2 = null;
        String str3 = "ss";
        assertTrue(StringUtils.isBlank(str1));
        assertTrue(StringUtils.isBlank(str2));
        assertTrue(StringUtils.isNotBlank(str3));
    }
    
    @Test
    public void testSpecial() {
        String str1 = "\n大家好啊 \t";
        String str2 = "\n\r\t    ";
        assertEquals("大家好啊", StringUtils.strip(str1));
        assertNull(StringUtils.stripToNull(str2));
        assertEquals("", StringUtils.stripToEmpty(str2));
    }
    
}
