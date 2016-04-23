package com.example.android.lojadesapatos;

import java.io.Serializable;

/**
 * Created by leona on 23/04/2016.
 */
public class InfoSapato implements Serializable {
    int modelo;
    String cor;
    int tamanho;


    public int getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (null != modelo && !modelo.isEmpty()) {
            this.modelo = Integer.parseInt(modelo);
        }
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        if (null != tamanho && !tamanho.isEmpty()) {
            this.tamanho = Integer.parseInt(tamanho);
        }
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
