package com.conveyal.traffic.stats;

import java.util.Arrays;

public class BaselineStatistics {
	
	public static double MS_TO_KMH = 3.6d;
	
	double speedByHourOfWeek[] = new double[SegmentTimeBins.HOURS_IN_WEEK];
	long averageCount = 0l;
	double averageSpeedSum = 0.0;

	public BaselineStatistics () {
		Arrays.fill(speedByHourOfWeek, Double.NaN);
	}
	
	public double getAverageSpeedKMH() {
		
		return getAverageSpeedMS() * MS_TO_KMH;
	}

	public double getAverageSpeedMS () {
		if(averageCount == 0)
			return Double.NaN;

		return averageSpeedSum / averageCount;
	}

	public double getSpeedByHourOfWeekMS(int hour) {
		return speedByHourOfWeek[hour];
	}

	public double getSpeedByHourOfWeekKMH(int hour) {
		return getSpeedByHourOfWeekMS(hour) * MS_TO_KMH;
	}
}
