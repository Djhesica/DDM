package com.example.sorteio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    TextView Titulo;
    EditText nInicial;
    EditText nFinal;
    Button bSortear;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Titulo = findViewById(R.id.Titulo);
        nInicial = findViewById(R.id.nInicial);
        nFinal = findViewById(R.id.nFinal);
        bSortear = findViewById(R.id.bSortear);
        resultado = findViewById(R.id.resultado);
    }

    public  void Sortear(View view) {
        try {
            Random random = new Random();
            int min = Integer.parseInt(nInicial.getText().toString());
            int max = Integer.parseInt(nFinal.getText().toString());
            int resultadoRandom = random.nextInt((max - min) + 1) + min;
            resultado.setText((String.valueOf(resultadoRandom)));
        } catch (Exception e) {
            Toast.makeText(this, "Erro - Informe o intervalo desejado válido", Toast.LENGTH_SHORT).show();
        }
    }
}
