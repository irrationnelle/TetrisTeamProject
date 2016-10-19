package Final;

import java.util.Random;
import java.lang.Math;


public class Shape {

    private Tetrominoes pieceShape;
    private int coords[][];


    public Shape() {

        coords = new int[4][2];
        setShape(Tetrominoes.NoShape);

    }

    public void setShape(Tetrominoes shape) {

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = shape.coords[i][j];
            }
        }
        pieceShape = shape;

    }

    private void setX(int index, int x) { coords[index][0] = x; }
    private void setY(int index, int y) { coords[index][1] = y; }
    public int x(int index) { return coords[index][0]; }
    public int y(int index) { return coords[index][1]; }
    public Tetrominoes getShape()  { return pieceShape; }

    public void setRandomShape()
    {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoes[] values = Tetrominoes.values(); 
        setShape(values[x]);
    }

    public int minX()
    {
      int m = coords[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][0]);
      }
      return m;
    }


    public int minY() 
    {
      int m = coords[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coords[i][1]);
      }
      return m;
    }

    public Shape rotateLeft() 
    {
        if (pieceShape == Tetrominoes.OShape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
        	int temp = this.coords[i][0];
			result.coords[i][0] = -1 * this.coords[i][1];
			result.coords[i][1] = temp;
        }
        return result;
    }

    public Shape rotateRight()
    {
        if (pieceShape == Tetrominoes.OShape)
            return this;

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
        	int temp = this.coords[i][0];
			result.coords[i][0] = -1 * this.coords[i][1];
			result.coords[i][1] = temp;
        }
        return result;
    }
}