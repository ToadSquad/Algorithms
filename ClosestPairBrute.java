package Algortihms;

import java.awt.Point;
import java.util.Random;

public class ClosestPairBrute {
	public static void main(String[] args) {
		Point[] p = new Point[5];
		Random r = new Random();
		for(int x=0;x<p.length;x++){
			p[x] = new Point();
			p[x].setLocation(r.nextInt(100),r.nextInt(100));
		}
		Point[] a = closestPair(p);
		for(Point b:a) {
			System.out.println("("+b.x+","+b.y+")");
		}
		//System.out.println(Math.sqrt(Math.pow(a[0].y-a[1].y,2)+Math.pow(a[0].x-a[1].y,2)));
	}
	public static Point[] closestPair(Point[] points) {
		double minDistance = Double.MAX_VALUE;
		Point[] closest = new Point[2];
		for(int x=0;x<points.length-1;x++) {
			for(int y=x+1;y<points.length;y++) {
				double distance = Math.pow(points[x].y-points[y].y,2)+Math.pow(points[x].x-points[y].x,2);
				if(distance<minDistance) {
					minDistance = distance;
					closest[0] = points[x];
					closest[1] = points[y];
				}
				
			}
		}
		
		
		
		return closest;
	}
}
