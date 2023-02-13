package com.example.book_lend_app.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    static  int count = 0;
    static  int count1 = 0;
@Pointcut("execution(* com.example.book_lend_app.controller.BookController.showAllAndSearchSort())")
    public void getAllShowList(){

}
@After(value = "getAllShowList()" )
    public void print(){
    count++;
    System.out.println("Số lượt truy cập vào thư viện là " + count);
}
    @Pointcut("execution(* com.example.book_lend_app.controller.BookController.lend(..))" +
            "||execution(* com.example.book_lend_app.controller.BookController.pay(..))")
    public void showChange() {
    }

    @After(value = "showChange()")
    public void afterChange() {
        count1++;
        System.out.println("Trạng thái thư viện đã thay đổi lần:" + " " + count1);
    }

}
