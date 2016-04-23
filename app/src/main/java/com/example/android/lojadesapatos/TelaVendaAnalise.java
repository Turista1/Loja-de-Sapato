package com.example.android.lojadesapatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaVendaAnalise extends AppCompatActivity {
    Button corrigir;
    Button concluido;
    TextView cliente;
    TextView metodo;
    TextView modelo;
    TextView cor;
    TextView tamanho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.venda_analise);
        cliente = (TextView) findViewById(R.id.info_cliente);
        modelo = (TextView) findViewById(R.id.info_modelo);
        metodo = (TextView) findViewById(R.id.info_metodo);
        cor = (TextView) findViewById(R.id.info_cor);
        tamanho = (TextView) findViewById(R.id.info_tamanho);
        corrigir = (Button) findViewById(R.id.corrigir);
        corrigir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaVendaAnalise.this, TelaVenda.class);
                startActivity(intent);
            }
        });
        concluido = (Button) findViewById(R.id.venda_concluida);
        concluido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaVendaAnalise.this, TelaVendaConcluida.class);
                startActivity(intent);
            }
        });
        InfoSapato novoSapato = (InfoSapato) getIntent().getSerializableExtra("sapato");
        String pagamento = getIntent().getStringExtra("pagamento");
        String nomeCliente = getIntent().getStringExtra("cliente");

        cliente.setText(nomeCliente);
        metodo.setText(pagamento);
        modelo.setText(String.valueOf(novoSapato.modelo));
        cor.setText(novoSapato.cor);
        tamanho.setText(String.valueOf(novoSapato.tamanho));
    }
}
