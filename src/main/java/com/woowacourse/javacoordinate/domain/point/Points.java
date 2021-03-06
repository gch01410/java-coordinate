package com.woowacourse.javacoordinate.domain.point;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        checkPoints(points);
        this.points = points;
    }

    private void checkPoints(List<Point> points) {
        if (Objects.isNull(points)) {
            throw new NullPointerException();
        }

        if (points.isEmpty()) {
            throw new IllegalArgumentException("빈 point가 입력되었습니다");
        }

        checkPointsIsDuplicate(points);
    }

    private void checkPointsIsDuplicate(List<Point> points) {
        Set<Point> pointSet = new HashSet<>(points);
        if (pointSet.size() != points.size()) {
            throw new IllegalArgumentException("중복된 좌표는 입력할 수 없습니다");
        }
    }

    public int calculateXAxisPositionNumber() {
        Set<Integer> xAxises = new HashSet<>();
        points.stream().map(Point::getX).forEach(xAxises::add);

        return xAxises.size();
    }

    public int calculateYAxisPositionNumber() {
        Set<Integer> yAxises = new HashSet<>();
        points.stream().map(Point::getY).forEach(yAxises::add);

        return yAxises.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getSize() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Points points1 = (Points) o;

        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }
}
