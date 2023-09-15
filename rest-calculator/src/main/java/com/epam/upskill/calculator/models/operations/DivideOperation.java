package com.epam.upskill.calculator.models.operations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.epam.upskill.calculator.models.Result;
import com.epam.upskill.calculator.util.Constants;

public class DivideOperation extends OperationAbstract {
	
	private final BigDecimal zero = new BigDecimal(0);
	
	@Override
	public Result perform() throws Exception {
		Result result = operandsValidator();
		if (Boolean.FALSE.equals(result.getError())) {
			if(operand2.compareTo(zero) == 0) {
				result.setError(Boolean.TRUE);
				result.setMessage(Constants.ERROR_MESSAGE_DIVIDE_BY_ZERO);
				getLogger().error("Can't divide by Zero");
			}
			else {
				result.setResult(operand1.divide(operand2, 10, RoundingMode.CEILING));
				result.setError(Boolean.FALSE);
			}}
		return result;
	}

	@Override
	public String toString() {
		return super.toString("Divide ");
	}

}
