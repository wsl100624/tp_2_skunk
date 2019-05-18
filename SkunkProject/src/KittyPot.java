
//Refactor 1st - low coupling
	// Removed kittyPot from Round class, and make it as a static object.

public class KittyPot {
	
	public static int kittyChips;
	
	static int getKittyChips() {
		return kittyChips;
	}
	
	static void addOneChip() {
		kittyChips += Constants.SINGLE_SKUNK_PENALTY;
	}
	
	static void addTwoChips() {
		kittyChips += Constants.DEUCE_SKUNK_PENALTY;
	}
	
	static void addFourChips() {
		kittyChips += Constants.DOUBLE_SKUNK_PENALTY;
	}
	
	static void clearKittyPot() {
		kittyChips = 0;
	}
	
}
