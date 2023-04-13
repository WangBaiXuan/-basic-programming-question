package com.tw.basicprogrammingquestion;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
    private final int topNumber = 26 + 26 * 26 + 26 * 26 * 26;

    public int getTopNumber() {
        return topNumber;
    }

    public List toColumnNumberList(int start, int count) {
        if (start <= 0 || count <= 0) {
            throw new BadRequestException();
        }
        if (((start + count) - 1) > topNumber) {
            throw new ResultBeyondZZZException();
        }
        List result = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            result.add(toColumnNumber(start + i));
        }
        return result;
    }

    private String toColumnNumber(int number) {
        StringBuilder result = new StringBuilder();
        char columnNumber;
        if (number <= 26) {
            columnNumber = (char) (65 + (number - 1) % 26);
            result.append(columnNumber);
        } else if (number > 26 && number <= 26 + 26 * 26) {
            columnNumber = (char) (65 + (((number - 26) - 1) / 26));
            result.append(columnNumber);
            columnNumber = (char) (65 + (number - 1) % 26);
            result.append(columnNumber);
        } else if (number > 26 + 26 * 26 && number <= topNumber) {
            columnNumber = (char) (65 + (((number - (26 * 26 + 26)) - 1) / (26 * 26)));
            result.append(columnNumber);
            columnNumber = (char) (65 + (((number - (26 * 26 + 26)) - 1) / 26));
            result.append(columnNumber);
            columnNumber = (char) (65 + (number - 1) % 26);
            result.append(columnNumber);
        }
        return result.toString();
    }
}
