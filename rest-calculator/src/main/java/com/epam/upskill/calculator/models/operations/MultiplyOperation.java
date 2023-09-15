package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.models.Result;
import com.epam.upskill.calculator.util.Constants;

import java.math.BigDecimal;


public class MultiplyOperation extends OperationAbstract{
	private final BigDecimal zero = new BigDecimal(0);

	@Override
	public Result perform() throws Exception {
		Result result = operandsValidator();
		if(Boolean.FALSE.equals(result.getError())){
			if(operand1.compareTo(zero) == 0 || operand2.compareTo(zero) == 0){
				result.setError(Boolean.TRUE);
				result.setMessage(Constants.ERROR_MESSAGE_MULTIPLY_BY_ZERO);
				getLogger().error("Can't multiply by zero, all results will be 0");
			}else{
				result.setResult(operand1.multiply(operand2));
				result.setError(Boolean.FALSE);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return super.toString("Multiply ");
	}

}
