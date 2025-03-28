package com.udesc.testedesoftware;

import java.time.LocalDate;
import java.util.Objects;

class Cupom {
    private String codigo;
    private double valorDesconto;
    private LocalDate dataValidade;
    private int maxUsos;
    private int usosRestantes;

    public Cupom(String codigo, double valorDesconto, LocalDate dataValidade, int maxUsos) {
        this.codigo = codigo;
        this.valorDesconto = valorDesconto;
        this.dataValidade = dataValidade;
        this.maxUsos = maxUsos;
        this.usosRestantes = maxUsos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setUsosRestantes(int usosRestantes) {
        if (usosRestantes >= 0) {
            this.usosRestantes = usosRestantes;
        }
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public int getMaxUsos() {
        return maxUsos;
    }

    public int getUsosRestantes() {
        return usosRestantes;
    }

    public boolean isValido(LocalDate dataAtual) {
        if (Objects.isNull(getCodigo()) || getCodigo().isBlank()) {
            return false;
        }
        if (getCodigo().isBlank()) {
            return false;
        }

        if (LocalDate.now().isAfter(dataAtual)) {
            return false;
        } else
            if (dataAtual.isBefore(dataValidade) || LocalDate.now().isEqual(dataValidade)){
                return true;
            }
            return false;
//        boolean armazena = false;
//        if (dataAtual.isEqual(dataAtual) || dataAtual.isBefore(dataAtual)) {
//            armazena = true;
//        }
//        return armazena;

    }

    public void usar() {
    }
}