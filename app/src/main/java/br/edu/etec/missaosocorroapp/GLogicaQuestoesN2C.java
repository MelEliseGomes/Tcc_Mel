package br.edu.etec.missaosocorroapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GLogicaQuestoesN2C extends AppCompatActivity {


    Button botao_voltar, btnA, btnB, btnC;
    TextView textoPergunta;

    int indice = 0;

    int acertos = 0;

    String[] perguntas = {
            "1) Qual é a resposta correta da primeira questão?",
            "2) Segunda pergunta: qual alternativa está correta?",
            "3) Última questão, escolha a certa!"
    };

    int[] respostas = {
            1,
            1,
            1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.g_tela_questoes_n2_c);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_voltar = findViewById(R.id.btn_voltar);
        textoPergunta = findViewById(R.id.txt_pergunta);
        btnA = findViewById(R.id.btn_alternativa_a);
        btnB = findViewById(R.id.btn_alternativa_b);
        btnC = findViewById(R.id.btn_alternativa_c);

        atualizarPergunta();

        botao_voltar.setOnClickListener(v -> {
            Intent voltar = new Intent(GLogicaQuestoesN2C.this, BLogicaIdade.class);
            startActivity(voltar);

            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);

            finish();
        });

        btnA.setOnClickListener(v -> verificarResposta(0));
        btnB.setOnClickListener(v -> verificarResposta(1));
        btnC.setOnClickListener(v -> verificarResposta(2));
    }

    private void atualizarPergunta() {
        textoPergunta.setText(perguntas[indice]);
    }

    private void verificarResposta(int respostaEscolhida) {

        if (respostaEscolhida == respostas[indice]) {
            acertos++;
        }

        indice++;

        if (indice < perguntas.length) {
            atualizarPergunta();
        } else {
            Toast.makeText(
                    this,
                    "Você acertou " + acertos + " de " + perguntas.length + " perguntas!",
                    Toast.LENGTH_LONG
            ).show();

            finish();
        }
    }
}
