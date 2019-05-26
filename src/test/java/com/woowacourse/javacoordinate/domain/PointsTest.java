package com.woowacourse.javacoordinate.domain;

import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PointsTest {
    @Test
    void 포인트_초기화() {
        Points points = new Points(Arrays.asList(new Point(3, 3), new Point(5, 5)));

        assertThat(points.getPoints()).isEqualTo(Arrays.asList(new Point(3, 3), new Point(5, 5)));
    }

    @Test
    void 포인트_중복처리() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Points(Arrays.asList(new Point(3, 3)
                    , new Point(5, 5), new Point(3, 3)));
        }).withMessage("중복된 좌표는 입력할 수 없습니다");
    }

    @Test
    void 포인트의_x좌표_개수_계산() {
        Points points = new Points(Arrays.asList(new Point(3, 3), new Point(5, 5)));

        assertThat(points.calculateXAxisPositionNumber()).isEqualTo(2);
    }

    @Test
    void 포인트의_y좌표_개수_계산() {
        Points points = new Points(Arrays.asList(new Point(3, 3), new Point(5, 3)));

        assertThat(points.calculateYAxisPositionNumber()).isEqualTo(1);
    }
}
