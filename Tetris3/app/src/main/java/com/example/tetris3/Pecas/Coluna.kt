package com.example.tetris3.Pecas

import Peca
class Coluna(var linha:Int,var coluna:Int): Peca(

    Ponto(linha,coluna),
    Ponto(linha+1,coluna),
    Ponto(linha+2,coluna),
    Ponto(linha+3,coluna)
) {


}

