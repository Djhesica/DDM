package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edPeso, edAltura;
    TextView tvIMC;
    ImageView imageView;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPeso = findViewById(R.id.editTextPeso);
        edAltura = findViewById(R.id.editTextAltura);
        tvIMC = findViewById(R.id.textViewIMC);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
    }

    public double calculaIMC(double peso, double altura ){
        if(altura != 0){
            return peso / (altura*altura);
        }
        return 0;
    }
    public void imc(View view){
        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());
        DecimalFormat f = new DecimalFormat("#.##");
        double imc = calculaIMC(peso, altura);
        tvIMC.setText(f.format(imc));
        imagens(imc);
    }

    public void imagens(double imc){
        if(imc <= 18.5){
            imageView.setImageResource(R.drawable.abaixopeso);
        } else if(imc < 25){
            imageView.setImageResource(R.drawable.normal);
        } else if(imc < 30){
            imageView.setImageResource(R.drawable.sobrepeso);
        }else if(imc < 35 ){
            imageView.setImageResource(R.drawable.obesidade1);
        } else if(imc < 40){
            imageView.setImageResource(R.drawable.obesidade2);
        } else if(imc > 40){
            imageView.setImageResource(R.drawable.obesidade3);
        }
        seekBar.setProgress((int) imc);
    }
}
