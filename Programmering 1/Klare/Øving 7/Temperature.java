class Temperatures {

	double[][] data;

	Temperatures(double[][] data) {

		this.data = data;

	}

	public double getAverageForDay(int day) {
		double sum = 0;
		for(double hour : this.data[day]) {
			sum += hour;
		}
		return sum / (double) this.data[0].length;
	}

	public double[] getAverageForAllDays() {
		double[] averages = new double[data.length];
		for(int i = 0; i < this.data.length; i++) {
			averages[i] = this.getAverageForDay(i);
		}
		return averages;
	}

	public double getAverageForMonth() {
		double sum = 0;
		for(double day : this.getAverageForAllDays()) {
			sum += day;
		}
		return sum / (double) this.data.length;
	}

	public double[] getRanges() {
		double[] ranges = new double[5];

		for(double day : this.getAverageForAllDays()) {
			if(day < -5) {
				ranges[0] += 1;
			}
			else if(day < 0) {
				ranges[1] += 1;
			}
			else if(day < 5) {
				ranges[2] += 1;
			}
			else if(day < 10) {
				ranges[3] += 1;
			}
			else {
				ranges[4] += 1;
			}
		}

		return ranges;
	}

	public double getDataForHour(int day, int hour) {
		return data[day][hour];
	}

	// getDataForHourInDay


	public static void main(String[] args) {
		double[][] data = {{-11, -2, 3, 6}, {-1, -2, 3, 9}, {1, 2, 30, 12}};
		Temperatures temp = new Temperatures(data);
		System.out.println(temp.getAverageForMonth());
		for(double d : temp.getRanges()) {
			System.out.println(d);
		}
	}

}