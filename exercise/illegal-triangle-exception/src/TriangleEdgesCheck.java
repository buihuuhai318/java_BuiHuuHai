public class TriangleEdgesCheck {
    public void checkTriangleEdges(double a, double b, double c) throws TriangleEdgesException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleEdgesException("lỗi: tam giác không hợp lệ");
        } else {
            System.out.println("tam giác hợp lệ");
        }
    }
}
