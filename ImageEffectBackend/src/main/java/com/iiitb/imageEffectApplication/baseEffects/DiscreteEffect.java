package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

// Could be things like flip, rotate 90
public interface DiscreteEffect extends PhotoEffect {
    void selectOptionValue(String optionName, int value) throws IllegalParameterException;
}
