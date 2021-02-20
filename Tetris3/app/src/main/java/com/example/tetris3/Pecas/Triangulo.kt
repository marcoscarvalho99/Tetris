package com.example.tetris3.Pecas

import Peca

class Triangulo(var linha:Int,var coluna:Int): Peca(Ponto(linha,coluna),
    Ponto(linha+1,coluna),
    Ponto(linha+1,coluna+1),
    Ponto(linha+1,coluna-1)) {


    override fun rotacionar(){



    }
}
