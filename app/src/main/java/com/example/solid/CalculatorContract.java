package com.example.solid;

public interface CalculatorContract {
    interface View {
        void showResult(String result);
        void showError(String message);
        void clearInputs();
    }

    interface Presenter {
        void onAddClicked(String num1, String num2);
        void onSubtractClicked(String num1, String num2);
        void onMultiplyClicked(String num1, String num2);
        void onDivideClicked(String num1, String num2);
        void onClearClicked();
    }
}
