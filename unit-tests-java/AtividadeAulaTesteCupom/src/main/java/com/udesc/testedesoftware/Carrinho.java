package com.udesc.testedesoftware;

import java.time.LocalDate;

class Carrinho {
    public static double aplicarCupom(Cupom cupom, double valorCompra, LocalDate dataAtual) {
        if (valorCompra <= 0) {
            return valorCompra = 0;
        }
        if (cupom.isValido(dataAtual) && cupom.getUsosRestantes() > 0) {
            if (cupom.getValorDesconto() >= valorCompra) {
                return 0;
            } else {
                cupom.setUsosRestantes(cupom.getUsosRestantes() - 1);
                return valorCompra - cupom.getValorDesconto();
            }
        } else {
            return valorCompra;
        }
    }
}