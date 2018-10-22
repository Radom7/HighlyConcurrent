package com.haiyu.publish;

import com.haiyu.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Escape
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 13:53
 */
@Slf4j
@UnThreadSafe
public class Escape {

    private int thisCanBeEscape = 0;

    public  Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
