package br.edu.etec.missaosocorroapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ZLogicaPontuacao extends AppCompatActivity {

    Button botao_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.z_tela_pontuacao);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        botao_voltar = findViewById(R.id.btn_voltar);
        botao_voltar.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    ZLogicaPontuacao.this, DLogicaNiveisCrianca.class
            );
            startActivity(nova_tela);

            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
        });

        TextView txtPontos = findViewById(R.id.txv_pontos);


        double pontosFinais = ZPontuacao.getTotal();
        txtPontos.setText("Sua pontuação foi: " + pontosFinais);
    }
}
