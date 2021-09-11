package com.example.javabasic._enum.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicStatusTest {

    @Test
    void 비교() {

        //given
        BasicStatus a = BasicStatus.RUNNING;

        //when & then
        assertNotSame(a, BasicStatus.FAILED, "실패 체크");
        assertSame(a, BasicStatus.RUNNING, "진행중 체크");

        System.out.println("이름 >> " + a);
        System.out.println("코드 >> " + a.getCode());
        System.out.println("설명 >> " + a.getDescription());
        System.out.println("> PREPARED? >> " + a.isGreaterThan(BasicStatus.PREPARED));
        System.out.println("> RUNNING? >> " + a.isGreaterThan(BasicStatus.RUNNING));
        System.out.println("> COMPLETED? >> " + a.isGreaterThan(BasicStatus.COMPLETED));

        System.out.println("< PREPARED? >> " + a.isLessThan(BasicStatus.PREPARED));
        System.out.println("< RUNNING? >> " + a.isLessThan(BasicStatus.RUNNING));
        System.out.println("< COMPLETED? >> " + a.isLessThan(BasicStatus.COMPLETED));

    }

}