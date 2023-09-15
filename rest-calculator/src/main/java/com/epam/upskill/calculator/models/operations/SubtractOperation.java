package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.models.Result;

public class SubtractOperation extends OperationAbstract {

	@Override
	public Result perform() throws Exception {
		Result result = operandsValidator();
		if(Boolean.FALSE.equals(result.getError())){
			result.setResult(operand1.subtract(operand2));
			result.setError(Boolean.FALSE);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return super.toString("Subtract ");
	}

}
