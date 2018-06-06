package com.project.dudko.thebeastofthelabyrinth

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main_game.*
import java.util.*
import kotlin.math.max
import kotlin.math.min

class MainGameActivity : AppCompatActivity() {

    class MapOfLabyrinth(var id: Int? = null){
        /*
            Сопоставить картинки и id:

            //только стены
            000
            001
            002
            003
            004
            005
            006
            007
            008
            009
            010
            011
            012
            013
            014
            015

            //+ монета
            100
            101
            102
            103
            104
            105
            106
            107
            108
            109
            110
            111
            112
            113
            114
            115

            //+ кентавр
            200
            201
            202
            203
            204
            205
            206
            207
            208
            209
            210
            211
            212
            213
            214
            215

            //+ кентавр / монета
            300
            301
            302
            303
            304
            305
            306
            307
            308
            309
            310
            311
            312
            313
            314
            315
         */

        fun Update(x: Int = 0, y: Int = 0): Boolean{

            //ToDO: переходить на заключительный экран, в случае true

            if(PlayerPosition[0] == ExitPosition[0] && PlayerPosition[1] == ExitPosition[1]){
                return true
            }
            PlayerPosition[0] = max(min(PlayerPosition[0] + x, 7), 0)
            PlayerPosition[1] = max(min(PlayerPosition[1] + y, 7), 0)
            return false
        }

        fun redraw(pos: Array<Int>){
            //ToDO: заменить картинку на кнопке, где стоит игрок
        }

        fun isCoinCollected(): Boolean{
            if(PlayerPosition in CoinsPosition && PlayerPosition !in CollectedCoins){
                CollectedCoins.add(PlayerPosition)
                NumberOfCollectedCoins++
                redraw(PlayerPosition)
                return true
            }
            return false
        }

        var EnemyPosition = Array(2){i -> 0}
        var PlayerPosition = Array(2){i -> 0}
        var CoinNumber = 5
        var CoinsPosition = Array(CoinNumber){i -> Array(2){i -> 0}}

        var CollectedCoins = MutableList(0){i -> Array(2){i -> 0}}
        var NumberOfCollectedCoins = 0

        var ExitPosition = Array(2){i -> 0} //Учитывать, что выход сдвинут вне каоты на одну клетку

        var map = Array(8){i -> Array(8){0}}
        init{

            if(id != null) {
                //ToDO: Задать объявление из файлов
            } else {
                map[0][0] = 7
                map[0][7] = 5
                map[7][0] = 10
                map[7][7] = 8

                for(i in 1..6) map[0][i] = 1
                for(i in 1..6) map[7][i] = 3
                for(i in 1..6) map[i][0] = 4
                for(i in 1..6) map[i][7] = 2
            }
        }
    }

    init {
        val map: MapOfLabyrinth = if(intent.hasExtra("Id_Of_Level")) {
                    MapOfLabyrinth(intent.getStringExtra("Id_Of_Level").toInt())
        }
                else {
                    MapOfLabyrinth()
                }
        map.redraw(map.PlayerPosition)
    }

    val REQUEST_EXIT = 1
    //0 - продолжить
    //1 - выйти

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 1) finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Tag", "Create")


        setContentView(R.layout.activity_main_game)


        button_pause.setOnClickListener {
            val intent = Intent(this, PauseActivity::class.java)
            startActivityForResult(intent, REQUEST_EXIT)
        }


        button00.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button01.setOnClickListener{
            button01.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button02.setOnClickListener{
            button02.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button03.setOnClickListener{
            button03.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button04.setOnClickListener{
            button04.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button05.setOnClickListener{
            button05.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button06.setOnClickListener{
            button06.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button07.setOnClickListener{
            button07.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button10.setOnClickListener{
            button10.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button11.setOnClickListener{
            button11.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button12.setOnClickListener{
            button12.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button13.setOnClickListener{
            button13.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button14.setOnClickListener{
            button14.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button15.setOnClickListener{
            button15.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button16.setOnClickListener{
            button16.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button17.setOnClickListener{
            button17.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button20.setOnClickListener{
            button20.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button21.setOnClickListener{
            button21.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button22.setOnClickListener{
            button22.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button23.setOnClickListener{
            button23.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button24.setOnClickListener{
            button24.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button25.setOnClickListener{
            button25.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button26.setOnClickListener{
            button26.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button27.setOnClickListener{
            button27.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button30.setOnClickListener{
            button30.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button31.setOnClickListener{
            button31.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button32.setOnClickListener{
            button32.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button33.setOnClickListener{
            button33.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button34.setOnClickListener{
            button34.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button35.setOnClickListener{
            button35.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button36.setOnClickListener{
            button36.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button37.setOnClickListener{
            button37.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button40.setOnClickListener{
            button40.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button41.setOnClickListener{
            button41.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button42.setOnClickListener{
            button42.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button43.setOnClickListener{
            button43.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button44.setOnClickListener{
            button44.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button45.setOnClickListener{
            button45.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button46.setOnClickListener{
            button46.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button47.setOnClickListener{
            button47.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button50.setOnClickListener{
            button50.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button51.setOnClickListener{
            button51.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button52.setOnClickListener{
            button52.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button53.setOnClickListener{
            button53.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button54.setOnClickListener{
            button54.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button55.setOnClickListener{
            button55.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button56.setOnClickListener{
            button56.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button57.setOnClickListener{
            button57.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button60.setOnClickListener{
            button60.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button61.setOnClickListener{
            button61.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button62.setOnClickListener{
            button62.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button63.setOnClickListener{
            button63.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button64.setOnClickListener{
            button64.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button65.setOnClickListener{
            button65.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button66.setOnClickListener{
            button66.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button67.setOnClickListener{
            button67.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button70.setOnClickListener{
            button70.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button71.setOnClickListener{
            button71.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button72.setOnClickListener{
            button72.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button73.setOnClickListener{
            button73.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button74.setOnClickListener{
            button74.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button75.setOnClickListener{
            button75.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button76.setOnClickListener{
            button76.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button77.setOnClickListener{
            button77.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }
        
    }

    /*override fun onStart() {
        super.onStart()
        Log.d("Tag", "Start")
    }*/

    /*override fun onResume() {
        super.onResume()
        Log.d("Tag", "Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Tag", "Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Tag", "Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Tag", "Destroy")
    }*/
}
