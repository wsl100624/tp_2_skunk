
//Refactor 1st - low coupling
	// Removed kittyPot from Round class, and make it as a static object.

public class KittyPot {
	
	public static int kittyChips;
	
	static int getKittyChips() {
		return kittyChips;
	}
	
	static void addOneChip() {
		kittyChips += 1;
	}
	
	static void addTwoChips() {
		kittyChips += 2;
	}
	
	static void addFourChips() {
		kittyChips += 4;
	}
	
	static void clearKittyPot() {
		kittyChips = 0;
	}
	
}
