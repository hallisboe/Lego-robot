// TODO:
// - Lage radar klasse som tegner radar på skjermen

public class Run {

	public static void main(String[] args) {
		Radar radar = new Radar('B', "S1", 900, 160, true, 80);
		radar.start();
		Pathfinder pathfinder = new Pathfinder();
		radar.iterate(170);
		
	}
}	

