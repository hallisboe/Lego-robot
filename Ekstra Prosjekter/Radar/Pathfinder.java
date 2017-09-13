class Pathfinder {
	public int[] rotateTowardsOpenPath(float[] data){
		int chunkSize = 20;
		float[] averages = new float[data.length - chunkSize];
		for(int i = 0; i < data.length-chunkSize; i++) {
			float lengthAverage = 0f;
			for (int k = 0; k < chunkSize; k++) {
				lengthAverage += data[i + k];
			}
			averages[i] = lengthAverage / (float) chunkSize;
		}
		int max = 0;
		for(int i = 0; i < averages.length; i++) {
			if(averages[max] < averages[i]) {
				max = i;
			}
		}
		// Fjerner den minste verdien 
		//System.out.println((int) Math.round((max + chunkSize / 2) - 80) + " - " + (float) averages[max] * 100);
		int[] test = new int[2];
		test[0] = (int) Math.round(((max + chunkSize / 2) - 80)*2f);
		test[1] = (int) Math.round(averages[max]*20);
		return test;
	}

}