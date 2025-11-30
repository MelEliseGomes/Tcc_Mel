package br.edu.etec.missaosocorroapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class D1LogicaNivelCrianca extends AppCompatActivity {

    Button botao_voltar, botao_nivel_1, botao_nivel_2, botao_nivel_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.d1_tela_nivel_crianca);
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
                    D1LogicaNivelCrianca.this, C1LogicaCrianca.class
            );
            startActivity(nova_tela);

            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);

        });

        botao_nivel_1.setOnClickListener(v -> abrirTelaNivel(1));
        botao_nivel_2.setOnClickListener(v -> abrirTelaNivel(2));
        botao_nivel_3.setOnClickListener(v -> abrirTelaNivel(3));
    }

    private void abrirTelaNivel(int nivel) {
        Intent intent = new Intent(D1LogicaNivelCrianca.this, ELogicaDescricaoNiveis.class);
        intent.putExtra("nivel", nivel);
        startActivity(intent);
    }


}