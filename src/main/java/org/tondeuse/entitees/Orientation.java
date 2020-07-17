package org.tondeuse.entitees;

public enum Orientation {

	N("NORTH"), E("EAST"), W("WEST"), S("SOUTH") ;
	
	private String orientation ;
	
	Orientation(String orientation) {
        this.orientation = orientation;
    }
	
	
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	
	
}
