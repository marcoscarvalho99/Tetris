package com.example.tetris3.Pecas

import com.example.tetris3.Peca

class Coluna(var linha:Int,var coluna:Int): Peca(linha,coluna) {

    var pts =  arrayListOf<Peca>(

        Peca(linha,coluna),
        Peca(linha+1,coluna),
        Peca(linha+2,coluna),
        Peca(linha+3,coluna)

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

