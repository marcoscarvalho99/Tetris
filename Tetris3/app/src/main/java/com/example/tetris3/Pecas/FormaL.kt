package com.example.tetris3.Pecas

import com.example.tetris3.Peca

class FormaL(var linha:Int,var coluna:Int): Peca(linha,coluna) {

    var pts =  arrayListOf<Peca>(

        Peca(linha,coluna),
        Peca(linha+1,coluna),
        Peca(linha+1,coluna-1),
        Peca(linha+1,coluna-2)

    )

    override fun moverDireita() {
        pts.forEach{
            it.y++
        }
    }

    override fun moverEsquerda() {
        pts.forEach{
            it.y--
        }

    }

    override fun moverBaixo() {
        pts.forEach{
            it.x++ }

    }

}