package com.haiyu.publish;

import com.haiyu.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Title: UnsafePublish
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 13:48
 */
@Slf4j
@UnThreadSafe
public class UnsafePublish {

    private String[] states = {"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
