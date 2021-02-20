package com.example.tetris3.Pecas

import Peca


  class Quadrado(var linha:Int,var coluna:Int):Peca(
      Ponto(linha,coluna),
      Ponto(linha+1,coluna),
      Ponto(linha,coluna+1),
      Ponto(linha+1,coluna+1)) {


}