package ua.com.vtkachenko.ciklum.kyiv.algorythms.club47DelaunayTriangulation.task1;

import geometry.convexhull.GrahamScan;
import geometry.dto.Point;
import geometry.dto.Segment;
import geometry.triangulation.AbstractTriangulation;
import geometry.triangulation.Triangle;
import geometry.triangulation.utils.Draw;
import javax.swing.text.Segment;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvexHullTriangulation extends AbstractTriangulation {

    public ConvexHullTriangulation(List<Point> points){
        super(points);
    }
    
    public static void main(String[] args) {
        Draw draw = new Draw();
    }
    
    @Override
    protected void triangulate(List<Point> points){
        Collectors.sort(points, (p1, p2) -> {int compare = Double.compare(p1.y(), p2.y());
        return compare == 0 ? Double.compare(p1.x(), p2.x()):compare;
        });
        Triangle triangle = new TRiangle(points.get(0), points.get(1), points.get(2));
        List<Segment> prevHull = new ArrayList<>();
        prevHull.add(triangle.side(0));
        prevHull.add(triangle.side(1));
        prevHull.add(triangle.side(2));
        addTriangle(triangle);
        for (int i = 3; i < points.size(); i++) {
            List<Segment> newHull = GrahamScan.convexHull(points.sublist(0, i));

            for (int j = 0; j < prevHull.size(); j++) {
                Segment prevSeg = prevHull.get(j);
                Point newPoint = newHull.get(j+1).end();
                while (!prevSeg.equals(newHull.get(j+2)) && j<prevHull.size()){
                    j++;
//                    Segment newSeg = newHull.get(j);
                    prevSeg = prevHull.get(j);
                    addTriangle(new Triangle(newPoint, prevSeg.start(), prevSeg.end()));
                }
            }
        }
        
    }
}
