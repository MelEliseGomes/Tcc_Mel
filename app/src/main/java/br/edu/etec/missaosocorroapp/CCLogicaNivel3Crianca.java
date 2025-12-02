package br.edu.etec.missaosocorroapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CCLogicaNivel3Crianca extends AppCompatActivity {

    Button botao_voltar, botao_continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cc_tela_nivel_3_crianca);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_voltar = findViewById(R.id.btn_voltar);
        botao_continuar = findViewById(R.id.btn_iniciar);

        botao_voltar.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    CCLogicaNivel3Crianca.this, BDLogicaNiveisCrianca.class
            );
            startActivity(nova_tela);

            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);

        });

        botao_continuar.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    CCLogicaNivel3Crianca.this, FALogicaPergunta1N3.class
            );
            startActivity(nova_tela);

        });


    }
}
