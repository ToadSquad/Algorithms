package Algortihms;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class ConvexHullBrute {
	public static void main(String[] args) {
		Point[] p = new Point[5];
		Random r = new Random();
		for(int x=0;x<p.length;x++){
			p[x] = new Point();
			p[x].setLocation(r.nextInt(100),r.nextInt(100));
		}
		ArrayList<Point[]> a = convexHull(p);
		for(Point[] b:a) {
			System.out.println("("+b[0].x+","+b[0].y+")"+"("+b[1].x+","+b[1].y+")");
		}

	}
	public static ArrayList<Point[]> convexHull(Point[] points) {
		ArrayList<Point[]> convexhull = new ArrayList<>();
		for(int x=0;x<points.length-1;x++) {
			for(int y=x+1;y<points.length;y++) {
				double a = points[x].y-points[y].y;
				double b = points[y].x-points[x].x;
				double c = (points[y].x*points[x].y)-(points[y].y*points[x].x);
				boolean positive = false;
				boolean negative = false;
				for(int z=0;z<points.length;z++) {
					if(equation(a,b,points[z])>c) {
						positive = true;
					}
					if(equation(a,b,points[z])<c) {
						negative = true;
					}
					if(positive&&negative) {
						break;
					}
					
				}
				if(!(positive&&negative)) {
					Point[] p = {points[x],points[y]};
					convexhull.add(p);
				}
				
				
				
			}
		}
		
		
		
		return convexhull;
	}
	public static double equation(double a, double b, Point p) {
		
		
		
		return a*p.x+b*p.y;
		
	}
}
