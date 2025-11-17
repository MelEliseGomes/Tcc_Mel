package br.edu.etec.missaosocorroapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class C2TelaAdolescente extends AppCompatActivity {

    Button botao_voltar;
    Button botao_comecar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.c2_tela_adolescente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_voltar = findViewById(R.id.btn_voltar);
        botao_comecar = findViewById(R.id.btn_comecar);

        botao_voltar.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    C2TelaAdolescente.this, BTelaIdade.class
            );
            startActivity(nova_tela);
        });

        botao_comecar.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    C2TelaAdolescente.this, D2TelaNivelAdolescente.class
            );
            startActivity(nova_tela);
        });

    }
}