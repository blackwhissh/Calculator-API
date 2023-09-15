package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.models.Result;

import java.math.BigDecimal;

public class FactorialOperation extends OperationAbstract {
    @Override
    public Result perform() throws Exception {
        Result result = validateFactorial();
        int fact = 1;
        if (Boolean.FALSE.equals(result.getError())) {
            int operand = operand1.intValue();
            for (int i = 1; i <= operand; i++) {
                fact = fact * i;
            }
            BigDecimal decimalOperand = new BigDecimal(fact);
            result.setError(Boolean.FALSE);
            result.setResult(decimalOperand);
        }
        return result;
    }
}
