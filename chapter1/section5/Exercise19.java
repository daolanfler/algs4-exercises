package chapter1.section5;

import edu.princeton.cs.algs4.QuickUnionUF;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Exercise19 {
    private Map<Integer, SiteLocation> siteLocation = new HashMap<>();

    public static void main(String[] args) {

        new Exercise19().animation();
    }

    private void animation() {
        int N = 16;

        Exercise18_RandomGrid.Connection[] connections = new Exercise18_RandomGrid().generate(N);

        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(-10, 100);
        StdDraw.setYscale(-10, 100);
        drawSites(N);

        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius();
        QuickUnionUF uf = new QuickUnionUF(N);
        
        StdOut.println("connection sizes is :" + connections.length);
        
        for (int i = 0; i < connections.length; i++) {
            int p = connections[i].p;
            int q = connections[i].q;
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            drawConnection(p, q);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 由于画线有重叠，很难看出最后有几个 component
        StdOut.println("components count: " + uf.count());
    }

    public void drawConnection(int p, int q) {
        SiteLocation a = siteLocation.get(p);
        SiteLocation b = siteLocation.get(q);
        StdDraw.line(a.x, a.y, b.x, b.y);

    }

    public void drawSites(int N) {
        int numOfCols = (int) Math.ceil(Math.sqrt(N));
        int scale = 100;
        double unitSize = scale / numOfCols;
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i < numOfCols; i++) {
            for (int j = 0; j < numOfCols; j++) {
                double x = j * unitSize;
                double y = i * unitSize;

                int siteValue = getSiteValue(i, j, N);
                SiteLocation site = new SiteLocation(x, y);
                siteLocation.put(siteValue, site);
                StdDraw.point(x, y);

            }

        }
    }

    public static int getSiteValue(int i, int j, int N) {
        int rowSize = (int) Math.ceil(Math.sqrt(N));
        return rowSize * i + j;
    }

    public static class SiteLocation {
        double x;
        double y;

        public SiteLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] getInitialArr(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
