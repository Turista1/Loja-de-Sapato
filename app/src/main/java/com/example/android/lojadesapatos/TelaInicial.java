package com.example.android.lojadesapatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends AppCompatActivity {
    Button opcaoVenda;
    Button opcaoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        opcaoVenda = (Button) findViewById(R.id.venda);
        opcaoVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaVenda.class);
                startActivity(intent);
            }
        });
        opcaoCadastro = (Button) findViewById(R.id.cadastro);
        opcaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaCadastro.class);
                startActivity(intent);
            }
        });
    }


}
