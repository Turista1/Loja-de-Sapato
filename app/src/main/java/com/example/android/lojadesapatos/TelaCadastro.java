package com.example.android.lojadesapatos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {
    Button button;
    String mensagem = "";
    EditText modelo;
    EditText cor;
    EditText tamanho;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            InfoSapato novoSapato = new InfoSapato();
//                novoSapato.modelo = Integer.parseInt(modelo.getText().toString());
            novoSapato.setModelo(modelo.getText().toString());
//                novoSapato.cor = cor.getText().toString();
            novoSapato.setCor(cor.getText().toString());
//                novoSapato.tamanho = Integer.parseInt(tamanho.getText().toString());
            novoSapato.setTamanho(tamanho.getText().toString());
            validarSapato(novoSapato);
            if (mensagem != null && !mensagem.isEmpty()) {
                checar();
            } else {
                Intent intent = new Intent(TelaCadastro.this, TelaCadastroConcluido.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        modelo = (EditText) findViewById(R.id.cadastro_modelo);
        cor = (EditText) findViewById(R.id.cadastro_cor);
        tamanho = (EditText) findViewById(R.id.cadastro_tamanho);
        button = (Button) findViewById(R.id.cadastro_concluido);

        button.setOnClickListener(onClickListener);
    }

    private void validarSapato(InfoSapato sapato) {
        StringBuilder contrutorString = new StringBuilder();

        if (0 == sapato.modelo) {
            contrutorString.append("Favor preencher modelo \n");
        }
        if (sapato.tamanho == 0) {
            contrutorString.append("Favor preencher tamanho\n");
        }
        if (null == sapato.getCor() || sapato.getCor().isEmpty()) {
            contrutorString.append("Favor preencher cor\n");
        }

        mensagem = contrutorString.toString();
    }

    public void checar() {
        Context context = getApplicationContext();
        CharSequence text = mensagem;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
