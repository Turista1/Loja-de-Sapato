package com.example.android.lojadesapatos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TelaVenda extends AppCompatActivity {
    Button botao;
    EditText modelo;
    EditText cor;
    EditText tamanho;
    EditText nomeCliente;
    RadioButton credito;
    RadioButton debito;
    RadioGroup pagamento;
    String mensagem = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.venda);
        nomeCliente = (EditText) findViewById(R.id.info_cliente);
        pagamento = (RadioGroup) findViewById(R.id.pagamento);
        credito = (RadioButton) findViewById(R.id.credito);
        debito = (RadioButton) findViewById(R.id.debito);
        modelo = (EditText) findViewById(R.id.info_modelo);
        cor = (EditText) findViewById(R.id.info_cor);
        tamanho = (EditText) findViewById(R.id.info_tamanho);
        botao = (Button) findViewById(R.id.venda_analise);
        botao.setOnClickListener(new View.OnClickListener() {
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
                    Intent intent = new Intent(TelaVenda.this, TelaVendaAnalise.class);
                    intent.putExtra("sapato", novoSapato);
                    intent.putExtra("cliente", nomeCliente.getText().toString());
                    int opcaoSelecionada = pagamento.getCheckedRadioButtonId();
                    if (opcaoSelecionada == R.id.credito) {
                        intent.putExtra("pagamento", "Crédito");
                    } else {
                        intent.putExtra("pagamento", "Débito");
                    }

                    startActivity(intent);
                }
            }
        });

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
        if (nomeCliente == null || nomeCliente.getText().toString().isEmpty()) {
            contrutorString.append("Favor preencher nome do cliente\n");
        }
        if (pagamento.getCheckedRadioButtonId() <= 0) {
            contrutorString.append("Favor preencher forma de pagamento\n");
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
