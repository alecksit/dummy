/**
 * 
 */
package com.advaizer.enums;

import com.advaizer.exception.ApplicationException;

/**
 * @author sarvesh
 *
 */
public enum PropensityValue {

	HIGH("High"), LOW("Low"), MEDIUM("Medium");
	
    private static final PropensityValue[] ENUMS = PropensityValue.values();

    /** The display name. */
    private String displayName;
    
    /**
     * Instantiates a new roamer type.
     *
     * @param name the name
     */
	private PropensityValue(final String name) { 
		displayName = name;
	}
	
    /**
     * Of.
     *
     * @param type the type
     * @return the roamer type
     */
    public static PropensityValue of(final int type) {
        if (type < 1 || type > 3) {
            throw new ApplicationException("Invalid value for propensity value: " + type, new IllegalArgumentException());
        }
        return ENUMS[type - 1];
    }

    /**
     * Gets the display name.
     *
     * @return the displayName
     */
	public String getDisplayName() {
		return displayName;
	}
}
