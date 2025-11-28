package br.edu.etec.missaosocorroapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ELogicaDescricaoNiveis extends AppCompatActivity {

    TextView tituloNivel, textoNivel;
    Button botao_voltar, botao_continuar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.e_tela_descricao_niveis);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Pegando IDs
        tituloNivel = findViewById(R.id.txt_nivel1);
        textoNivel = findViewById(R.id.txv_descricao_niveis);
        botao_voltar = findViewById(R.id.btn_voltar);
        botao_continuar = findViewById(R.id.btn_nivel1);

        // Recebe nível da outra tela
        int nivel = getIntent().getIntExtra("nivel", 1);

        switch (nivel) {
            case 1:
                tituloNivel.setText("Nível 1");
                textoNivel.setText(getString(R.string.his_niv1));
                break;

            case 2:
                tituloNivel.setText("Nível 2");
                textoNivel.setText(getString(R.string.his_niv2));
                break;

            case 3:
                tituloNivel.setText("Nível 3");
                textoNivel.setText(getString(R.string.his_niv3));
                break;

            case 4:
                tituloNivel.setText("Nível 4");
                textoNivel.setText(getString(R.string.his_niv4));
                break;

            case 5:
                tituloNivel.setText("Nível 5");
                textoNivel.setText(getString(R.string.his_niv5));
                break;

            case 6:
                tituloNivel.setText("Nível 6");
                textoNivel.setText(getString(R.string.his_niv6));
                break;
        }

        botao_voltar.setOnClickListener(v -> {
            Intent voltar = new Intent(
                    ELogicaDescricaoNiveis.this,
                    BLogicaIdade.class
            );
            startActivity(voltar);
            finish();
        });

        botao_continuar.setOnClickListener(v -> {
            Intent voltar = new Intent(
                    ELogicaDescricaoNiveis.this,
                    FLogicaQuestoesN1C.class
            );
            startActivity(voltar);
            finish();
        });

    }
}
