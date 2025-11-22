package br.edu.etec.missaosocorroapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BTelaIdade extends AppCompatActivity {

    Button botao_voltar, botao_crianca, botao_adolescente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.b_tela_idade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_voltar = findViewById(R.id.btn_voltar);
        botao_crianca = findViewById(R.id.btn_5_a_11);
        botao_adolescente = findViewById(R.id.btn_12_a_15);

        botao_voltar.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    BTelaIdade.this, ATelaInicial.class
            );
            startActivity(nova_tela);
        });

        botao_crianca.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    BTelaIdade.this, C1TelaCrianca.class
            );
            startActivity(nova_tela);
        });

        botao_adolescente.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    BTelaIdade.this, C2TelaAdolescente.class
            );
            startActivity(nova_tela);
        });



    }
}