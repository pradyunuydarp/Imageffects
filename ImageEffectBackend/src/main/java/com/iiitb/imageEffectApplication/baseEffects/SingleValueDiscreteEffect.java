package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public interface SingleValueDiscreteEffect extends PhotoEffect {
    void setParameterValue(int parameterValue) throws IllegalParameterException;
}
