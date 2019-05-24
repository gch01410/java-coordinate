package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static Map<Integer, FigureCreator> map = new HashMap<>();

    static {
        map.put(2, Line::new);
        map.put(3, Triangle::new);
        map.put(4, Rectangle::new);
    }

    static Figure getInstance(List<Point> points) {
        if (map.get(points.size()) == null) {
            throw new IllegalArgumentException("적합한 도형이 아닙니다.");
        }

        return map.get(points.size()).create(points);
    }
}
