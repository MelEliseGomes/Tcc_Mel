package br.edu.etec.missaosocorroapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TLogicaNivelAdolescente extends AppCompatActivity {

    Button botao_voltar, botao_nivel_1, botao_nivel_2, botao_nivel_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.t_tela_nivel_adolescente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_voltar = findViewById(R.id.btn_voltar);
        botao_nivel_1 = findViewById(R.id.btn_resposta_1);
        botao_nivel_2 = findViewById(R.id.btn_nivel2);
        botao_nivel_3 = findViewById(R.id.btn_nivel3);

        botao_voltar.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    TLogicaNivelAdolescente.this, SLogicaAdolescente.class
            );
            startActivity(nova_tela);

            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);

        });

        botao_nivel_1.setOnClickListener(v -> abrirTelaNivel(4));
        botao_nivel_2.setOnClickListener(v -> abrirTelaNivel(5));
        botao_nivel_3.setOnClickListener(v -> abrirTelaNivel(6));
    }

    private void abrirTelaNivel(int nivel) {
        Intent intent = new Intent(TLogicaNivelAdolescente.this, ELogicaNivel1Crianca.class);
        intent.putExtra("nivel", nivel);
        startActivity(intent);
    }
}