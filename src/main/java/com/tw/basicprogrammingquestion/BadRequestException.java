package com.tw.basicprogrammingquestion;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        super("错误参数，起始序列和结果个数都要大于0");
    }
}
