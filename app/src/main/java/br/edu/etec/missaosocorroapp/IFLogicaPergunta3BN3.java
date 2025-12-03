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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IFLogicaPergunta3BN3 extends AppCompatActivity {

    Button botao_voltar, botao_alternativa_a, botao_alternativa_b, botao_alternativa_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ef_tela_pergunta_3b_n2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_alternativa_a = findViewById(R.id.btn_a);
        botao_alternativa_b = findViewById(R.id.btn_b);
        botao_alternativa_c = findViewById(R.id.btn_c);


        TextView txtPergunta = findViewById(R.id.txv_pergunta);
        txtPergunta.setText(getString(R.string.texto_pergunta_3b_crianca_nivel_1));

        String altA = getString(R.string.texto_opcao_p3b_n2_a); // correta → tela L
        String altB = getString(R.string.texto_opcao_p3b_n2_b); // incorreta → tela M
        String altC = getString(R.string.texto_opcao_p3b_n2_c); // incorreta → tela N

        List<String> alternativas = new ArrayList<>();
        alternativas.add(altA);
        alternativas.add(altB);
        alternativas.add(altC);

        Collections.shuffle(alternativas);

        botao_alternativa_a.setText(alternativas.get(0));
        botao_alternativa_b.setText(alternativas.get(1));
        botao_alternativa_c.setText(alternativas.get(2));

        botao_alternativa_a.setOnClickListener(v -> abrirProximaTela(botao_alternativa_a.getText().toString()));
        botao_alternativa_b.setOnClickListener(v -> abrirProximaTela(botao_alternativa_b.getText().toString()));
        botao_alternativa_c.setOnClickListener(v -> abrirProximaTela(botao_alternativa_c.getText().toString()));

        botao_voltar = findViewById(R.id.btn_voltar);
        botao_voltar.setOnClickListener(v -> {
            Intent nova_tela = new Intent(
                    IFLogicaPergunta3BN3.this, BDLogicaNiveisCrianca.class
            );
            startActivity(nova_tela);

            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
        });
    }


    private void abrirProximaTela(String textoSelecionado) {

        String altA = getString(R.string.texto_opcao_p3b_n2_a);
        String altB = getString(R.string.texto_opcao_p3b_n2_b);
        String altC = getString(R.string.texto_opcao_p3b_n2_c);

        Intent intent;

        if (textoSelecionado.equals(altA)) {

            AAClassePontuacao.adicionar(1.0);
            intent = new Intent(this, ABLogicaPontuacao.class);

        } else if (textoSelecionado.equals(altB)) {

            AAClassePontuacao.adicionar(0.5);
            intent = new Intent(this, ABLogicaPontuacao.class);

        } else {

            AAClassePontuacao.adicionar(0);
            intent = new Intent(this, ABLogicaPontuacao.class);
        }

        startActivity(intent);

    }
}