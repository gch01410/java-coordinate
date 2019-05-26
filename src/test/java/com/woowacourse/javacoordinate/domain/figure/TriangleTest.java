package com.woowacourse.javacoordinate.domain.figure;

import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {
    private Points points;

    @BeforeEach
    void setUp() {
        points = new Points(Arrays.asList(new Point(10, 10),
                new Point(14, 15), new Point(20, 8)));
    }

    @Test
    void 삼각형_초기화() {
        assertThatCode(() -> new Triangle(points)).doesNotThrowAnyException();
    }

    @Test
    void 생성자에_null_입력_예외처리() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Triangle(null));
    }

    @Test
    void 삼각형_초기화_오류_포인트_개수가_다를_때() {
        points = new Points(Arrays.asList(new Point(10, 10),
                new Point(14, 15)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Triangle(points)).withMessage("삼각형은 3개의 Point가 필요합니다");
    }

    @Test
    void 삼각형_초기화_오류_한_직선에_포인트가_있을_때() {
        points = new Points(Arrays.asList(new Point(10, 10),
                new Point(10, 15), new Point(10, 20)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Triangle(points)).withMessage("모든 Point가 한 직선에 있습니다.");
    }

    @Test
    void 삼각형_면적_구하기() {
        Figure triangle = new Triangle(points);

        assertThat(triangle.calculateArea()).isEqualTo(29.0, offset(0.99));
    }
}
