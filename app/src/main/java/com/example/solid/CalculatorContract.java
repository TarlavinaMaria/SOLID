package com.example.solid;

// Интерфейс CalculatorContract определяет контракт между представлением и презентером
public interface CalculatorContract {
    // Интерфейс View определяет методы, которые будут использоваться в представлении
    interface View {
        void showResult(String result);

        void showError(String message);

        void clearInputs();
    }

    interface Presenter {
        // Интерфейс Presenter определяет методы, которые будут использоваться в презентере
        void onAddClicked(String num1, String num2);

        void onSubtractClicked(String num1, String num2);

        void onMultiplyClicked(String num1, String num2);

        void onDivideClicked(String num1, String num2);

        void onClearClicked();
    }
}
