package com.tw.basicprogrammingquestion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicProgrammingQuestionApplicationTests {
    private final Sheet sheet = new Sheet();


    @Test
    void should_return_A_when_input_1_1() {
        assertEquals(List.of("A"), sheet.toColumnNumberList(1, 1));
    }

    @Test
    void should_return_A_B_when_input_1_2() {
        assertEquals(List.of("A", "B"), sheet.toColumnNumberList(1, 2));
    }

    @Test
    void should_return_Z_AA_AB_when_input_26_3() {
        assertEquals(List.of("Z", "AA", "AB"), sheet.toColumnNumberList(26, 3));
    }

    @Test
    void should_return_BA_when_input_53_1() {
        assertEquals(List.of("BA"), sheet.toColumnNumberList(53, 1));
    }

    @Test
    void should_return_AAB_when_input_704_1() {
        assertEquals(List.of("AAB"), sheet.toColumnNumberList(704, 1));
    }

    @Test
    void should_return_AAB_when_input_729_2() {
        assertEquals(List.of("ABA", "ABB"), sheet.toColumnNumberList(729, 2));
    }

    @Test
    void should_throw_beyondZZZException_when_result_beyond_ZZZ() {
        assertThrows(ResultBeyondZZZException.class, () -> sheet.toColumnNumberList(sheet.getTopNumber(), 2), "结果超出ZZZ");
    }

    @Test
    void should_throw_badRequestException_when_result_beyond_ZZZ() {
        assertThrows(BadRequestException.class, () -> sheet.toColumnNumberList(-1, 2), "错误参数，起始序列和结果个数都要大于0");
    }
}
