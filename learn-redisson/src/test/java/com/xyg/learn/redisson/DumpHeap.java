package com.xyg.learn.redisson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiayiguo
 * @since 2021-03-01
 */
public class DumpHeap {
    public static void main(String[] args) {
        List list = new ArrayList<String>();
        while(true) {
            list.add("999999999999999999999999");
        }
    }
}
