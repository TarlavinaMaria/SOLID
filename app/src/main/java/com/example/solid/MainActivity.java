package com.example.solid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CalculatorContract.View {
    private CalculatorContract.Presenter presenter;

    private EditText etNum1;
    private EditText etNum2;
    private TextView tvResult;
    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Метод onCreate вызывается при создании активити
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupPresenter();
        setupListeners();
    }

    private void initViews() {
        // Метод initViews инициализирует элементы интерфейса
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);
    }

    private void setupPresenter() {
        // Метод setupPresenter создает презентер и связывает его с активити
        Calculator calculator = new Calculator();
        presenter = new CalculatorPresenter(this, calculator);
    }

    private void setupListeners() {
        // Метод setupListeners устанавливает слушатели нажатия на кнопки
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddClicked(etNum1.getText().toString(), etNum2.getText().toString());
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSubtractClicked(etNum1.getText().toString(), etNum2.getText().toString());
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onMultiplyClicked(etNum1.getText().toString(), etNum2.getText().toString());
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDivideClicked(etNum1.getText().toString(), etNum2.getText().toString());
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClearClicked();
            }
        });
    }

    @Override
    public void showResult(String result) {
        // Метод showResult обновляет текстовое поле с результатом
        tvResult.setText("Результат: " + result);
    }

    @Override
    public void showError(String message) {
        // Метод showError обновляет текстовое поле с ошибкой
        tvResult.setText("Ошибка: " + message);
    }

    @Override
    public void clearInputs() {
        // Метод clearInputs очищает текстовые поля
        etNum1.setText("");
        etNum2.setText("");
    }
}