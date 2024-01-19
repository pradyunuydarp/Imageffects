package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

// Could be any generic effect with changing values
public interface ParameterizableEffect extends PhotoEffect {
    void setParameter(String paramName, float value) throws IllegalParameterException;
}
