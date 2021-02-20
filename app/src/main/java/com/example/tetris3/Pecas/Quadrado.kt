package com.example.tetris3.Pecas

import Peca


class Quadrado(linha:Int, coluna:Int, ):Peca(
        Ponto(linha,coluna),
        Ponto(linha,coluna+1),
        Ponto(linha-1,coluna),
        Ponto(linha-1,coluna+1)
){

  override fun setOrietacaPeca(o:Int){

  }
}