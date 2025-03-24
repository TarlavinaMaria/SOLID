package com.example.solid;

public class CalculatorPresenter implements CalculatorContract.Presenter {
    private CalculatorContract.View view;
    private Calculator calculator;

    public CalculatorPresenter(CalculatorContract.View view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    @Override
    public void onAddClicked(String num1, String num2) {
        performCalculation(num1, num2, Operation.ADD);
    }

    @Override
    public void onSubtractClicked(String num1, String num2) {
        performCalculation(num1, num2, Operation.SUBTRACT);
    }

    @Override
    public void onMultiplyClicked(String num1, String num2) {
        performCalculation(num1, num2, Operation.MULTIPLY);
    }

    @Override
    public void onDivideClicked(String num1, String num2) {
        performCalculation(num1, num2, Operation.DIVIDE);
    }

    @Override
    public void onClearClicked() {
        view.clearInputs();
        view.showResult("");
    }

    private void performCalculation(String num1Str, String num2Str, Operation operation) {
        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);

            double result = calculator.calculate(num1, num2, operation);
            view.showResult(String.valueOf(result));
        } catch (NumberFormatException e) {
            view.showError("Please enter valid numbers");
        } catch (ArithmeticException e) {
            view.showError(e.getMessage());
        } catch (Exception e) {
            view.showError("An error occurred");
        }
    }
}
