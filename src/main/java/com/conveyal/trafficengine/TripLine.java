package com.conveyal.trafficengine;

import java.awt.geom.Point2D;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

public class TripLine {

	int index;
	long wayId;
	Long nd;
	double dist;
	LineString geom;

	public TripLine(Point2D left, Point2D right, long wayId, Long nd, double dist, int index) {
		GeometryFactory gf = new GeometryFactory();
		
		Coordinate[] coords = new Coordinate[2];
		coords[0] = new Coordinate(left.getX(), left.getY());
		coords[1] = new Coordinate(right.getX(), right.getY());
		this.geom = gf.createLineString(coords);
		
		this.wayId = wayId;
		this.nd = nd;
		this.dist = dist;
		this.index = index;
	}
	
	public String toString(){
		return "[Tripline way:"+wayId+" ix:"+index+"]";
	}

	public Envelope getEnvelope() {
		return geom.getEnvelopeInternal();
	}

	public LineSegment getLineSegment() {
		return new LineSegment( geom.getCoordinateN(0), geom.getCoordinateN(1) );
	}

}