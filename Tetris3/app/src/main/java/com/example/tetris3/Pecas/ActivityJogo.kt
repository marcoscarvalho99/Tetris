package com.example.tetris3.Pecas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tetris3.R
import android.app.Application
import android.widget.ImageView
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.example.tetris3.Peca
import com.example.tetris3.databinding.ActivityJogoBinding
import kotlin.random.Random


class ActivityJogo : AppCompatActivity() {

    val LINHA = 36
    val COLUNA = 26
    var cordX=1;
    var cordY=13;
    var running = true
    var speed:Long = 300

    lateinit var binding : ActivityJogoBinding


    var board = Array(LINHA) {
        Array(COLUNA){0}
    }

    var boardView = Array(LINHA){
        arrayOfNulls<ImageView>(COLUNA)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_jogo)
        binding.gridboard.rowCount = LINHA
        binding.gridboard.columnCount = COLUNA
        //inflador
        val inflater = LayoutInflater.from( applicationContext)


        for (i in 0 until LINHA) {
            for (j in 0 until COLUNA) {
                boardView[i][j] = inflater.inflate(R.layout.inflate_image_view, binding.gridboard, false) as ImageView
                binding.gridboard.addView( boardView[i][j])
            }
        }
        for (i in 0 until LINHA) {
            for (j in 0 until COLUNA) {

                boardView[i][j]!!.setImageResource(R.drawable.gray);
            }
        }

        gameRun()
    }



    fun escolherPeca(tipo:Int): Peca {
        when(tipo){
            0 -> {
                return Quadrado(cordX, cordY)
            }
            1 ->{
                return Triangulo(cordX,cordY)
            }
            else ->{

            }


        }
        return Quadrado(cordX,cordY)
    }





    fun gameRun(){
        Thread{



            var p = escolherPeca(1)

            while(running){

                Thread.sleep(speed)
                runOnUiThread{
                    //limpa tela
                    for (i in 1 until LINHA-1) {
                        for (j in 1 until COLUNA-1) {
                            if(board[i][j]==1){
                                boardView[i][j]!!.setImageResource(R.drawable.white)
                            }else{
                                boardView[i][j]!!.setImageResource(R.drawable.black)
                            }

                        }
                    }
                    //move peça atual
                    if(p.x < LINHA -2){
                        p.moverBaixo()

                    }
                    else{

                        board[p.x][p.y]=1;
                        //pt = Ponto(1,15);

                        speed=300;
                    }
                    if(board[1][14]==1){
                        running = false
                    }

                    //print peça
                    try {

                        for (i in 0 until 4){
                            p as Triangulo
                            boardView[p.pts.get(i).x][p.pts.get(i).y]!!.setImageResource(R.drawable.white)
                        }


                    }catch (e:ArrayIndexOutOfBoundsException ) {
                        //se a peça passou das bordas eu vou parar o jogo
                        running = false
                    }

                }
            }
        }.start()
    }

}
