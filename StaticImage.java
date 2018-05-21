public class StaticImage {
    private int x1;

    private int y1;

    private int x2;

    private int y2;

    private boolean isALine = false;

    private int [] xs;

    private int [] ys;

    private int numPoints;

    private boolean isTriangle;

    private boolean isRectangle;

    public StaticImage(int x, int y, int otherX, int otherY) {
        x1 = x;
        x2 = otherX;
        y1 = y;
        y2 = otherY;
        isALine = true;
    }

    public StaticImage(int[] xPoints, int[] yPoints, int nPoints, boolean triangle)
    {
        xs = xPoints;
        ys = yPoints;
        numPoints = nPoints;
    }

    public StaticImage(int width, int height)
    {
        x1 = width;
        y1 = height;
    }

    public int[] getXs()
    {
        return xs;
    }

    public int[] getYs()
    {
        return ys;
    }

    public int getNumPoints()
    {
        return numPoints;
    }

    public boolean isTriangle()
    {
        return isTriangle;
    }

//    public int[] getValsLine()
//    {
//        if(isALine)
//        {
//            int[] temp = {x1,y1,x2,y2};
//            return temp;
//        }
//
//        return null;
//    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public boolean isALine()
    {
        return isALine;
    }

    public boolean isRectangle()
    {
        return isRectangle;
    }
    public int getWidth()
    {
        return x1;
    }

    public int getHeight()
    {
        return y1;
    }
}
