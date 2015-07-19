/**
 * 
 */
package com.advaizer.enums;

import com.advaizer.exception.ApplicationException;

/**
 * @author sarvesh
 *
 */
public enum Propensity {

	
	ROAMING_PACK, VOIP, SEAMLESS;
	
    private static final Propensity[] ENUMS = Propensity.values();
    /**
     * Of.
     *
     * @param type the type
     * @return the roamer type
     */
    public static Propensity of(final int type) {
        if (type < 1 || type > 3) {
            throw new ApplicationException("Invalid value for propensity: " + type, new IllegalArgumentException());
        }
        return ENUMS[type - 1];
    }

}
