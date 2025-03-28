package com.udesc.testedesoftware;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        LocalDate dataAtual = LocalDate.now();

        // Cenário 1: com.udesc.testedesoftware.Cupom válido
        Cupom cupomValido = new Cupom("DESC10", 10.0, dataAtual.plusDays(7), 3);
        double valorFinalValido1 = carrinho.aplicarCupom(cupomValido, 100.0, dataAtual);
        double valorFinalValido2 = carrinho.aplicarCupom(cupomValido, 100.0, dataAtual);
        double valorFinalValido3 = carrinho.aplicarCupom(cupomValido, 100.0, dataAtual);
        double valorFinalValido4 = carrinho.aplicarCupom(cupomValido, 100.0, dataAtual);
        System.out.println("com.udesc.testedesoftware.Cupom válido (DESC10): Valor final 1 = " + valorFinalValido1);
        System.out.println("com.udesc.testedesoftware.Cupom válido (DESC10): Valor final 2 = " + valorFinalValido2);
        System.out.println("com.udesc.testedesoftware.Cupom válido (DESC10): Valor final 3 = " + valorFinalValido3);
        System.out.println("com.udesc.testedesoftware.Cupom válido (DESC10): Valor final 4 = " + valorFinalValido4);

        // Cenário 2: com.udesc.testedesoftware.Cupom expirado
        Cupom cupomExpirado = new Cupom("DESC20", 20.0, dataAtual.minusDays(1), 1);
        double valorFinalExpirado = carrinho.aplicarCupom(cupomExpirado, 100.0, dataAtual);
        System.out.println("com.udesc.testedesoftware.Cupom expirado (DESC20): Valor final = " + valorFinalExpirado);

        // Cenário 3: com.udesc.testedesoftware.Cupom nulo
        double valorFinalNulo = carrinho.aplicarCupom(null, 100.0, dataAtual);
        System.out.println("com.udesc.testedesoftware.Cupom nulo: Valor final = " + valorFinalNulo);

        // Cenário 4: com.udesc.testedesoftware.Cupom com código vazio
        Cupom cupomCodigoVazio = new Cupom("", 15.0, dataAtual.plusDays(1), 1);
        double valorFinalVazio = carrinho.aplicarCupom(cupomCodigoVazio, 100, dataAtual);
        System.out.println("com.udesc.testedesoftware.Cupom com código vazio: Valor final = " + valorFinalVazio);

        // Cenário 5: com.udesc.testedesoftware.Cupom com valor de desconto maior que compra
        Cupom cupomDescontoMaior = new Cupom("DESC110", 110.0, dataAtual.plusDays(1), 1);
        double valorFinalDescontoMaior = carrinho.aplicarCupom(cupomDescontoMaior, 100.0, dataAtual);
        System.out.println("com.udesc.testedesoftware.Cupom com desconto maior que compra: Valor final = " + valorFinalDescontoMaior);

        //Cenário 6: com.udesc.testedesoftware.Cupom com desconto decimal
        Cupom cupomDecimal = new Cupom("DESC10.5", 10.5, dataAtual.plusDays(1), 1);
        double valorFinalDecimal = carrinho.aplicarCupom(cupomDecimal, 100.0, dataAtual);
        System.out.println("com.udesc.testedesoftware.Cupom com desconto decimal: Valor final = " + valorFinalDecimal);

        //Cenário 7: com.udesc.testedesoftware.Cupom com desconto igual a zero.
        Cupom cupomZero = new Cupom("DESC0", 0.0, dataAtual.plusDays(1), 1);
        double valorFinalZero = carrinho.aplicarCupom(cupomZero, 100.0, dataAtual);
        System.out.println("com.udesc.testedesoftware.Cupom com desconto zero: Valor final = " + valorFinalZero);

        //Cenário 8: com.udesc.testedesoftware.Cupom com valor de compra negativo
        Cupom cupomNegativo = new Cupom("DESC10", 10.0, dataAtual.plusDays(1), 1);
        double valorFinalNegativo = carrinho.aplicarCupom(cupomNegativo, -100.0, dataAtual);
        System.out.println("com.udesc.testedesoftware.Cupom com valor de compra negativo: Valor final = " + valorFinalNegativo);
    }
}