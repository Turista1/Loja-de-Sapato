package com.example.android.lojadesapatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class TelaVendaConcluida extends AppCompatActivity {
    ImageButton botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.venda_concluida);
        botao = (ImageButton) findViewById(R.id.voltar_inicio);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaVendaConcluida.this, TelaInicial.class);
                startActivity(intent);
            }
        });
    }
}
