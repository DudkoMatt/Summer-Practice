package com.project.dudko.thebeastofthelabyrinth

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import com.project.dudko.thebeastofthelabyrinth.R.array.map_1
import kotlinx.android.synthetic.main.activity_main_game.*
import java.util.*
import kotlin.math.max
import kotlin.math.min

class MainGameActivity : AppCompatActivity() {

    class MapOfLabyrinth(var id: Int? = null, context: Context, var buttons: Array<Array<Button>>){
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

            //+ игрок
            400
            401
            402
            403
            404
            405
            406
            407
            408
            409
            410
            411
            412
            413
            414
            415
         */

        fun update(x: Int = 0, y: Int = 0): Boolean{

            //ToDO: переходить на заключительный экран, в случае true. Или добавлять кнопку exit?

            if(PlayerPosition[0] == ExitPosition[0] && PlayerPosition[1] == ExitPosition[1]){
                return true
            }
            if ((PlayerPosition[0] == x-1 && PlayerPosition[1] == y) ||
                    (PlayerPosition[0] == x && PlayerPosition[1] == y-1) ||
                    (PlayerPosition[0] == x && PlayerPosition[1] == y+1) ||
                    (PlayerPosition[0] == x+1 && PlayerPosition[1] == y)) { //ToDo: Стены
                PlayerPosition[0] = x
                PlayerPosition[1] = y
                redraw()
            }
            return false
        }

        fun redraw(){
            buttons[PlayerPosition[0]][PlayerPosition[1]].setBackgroundColor(Color.GREEN)
            buttons[min(max(PlayerPosition[0]+1, 0), 7)][PlayerPosition[1]].setBackgroundColor(Color.GREEN)
            buttons[PlayerPosition[0]][min(max(PlayerPosition[1]+1,0), 7)].setBackgroundColor(Color.GREEN)
            buttons[min(max(PlayerPosition[0]-1, 0), 7)][PlayerPosition[1]].setBackgroundColor(Color.GREEN)
            buttons[PlayerPosition[0]][min(max(PlayerPosition[0]-1, 0), 7)].setBackgroundColor(Color.GREEN)
            val noChange = Array(5){i -> Array(2){i -> 0}}
            noChange[0] = arrayOf(PlayerPosition[0], PlayerPosition[1])
            noChange[1] = arrayOf(min(max(PlayerPosition[0]+1, 0), 7), PlayerPosition[1])
            noChange[2] = arrayOf(PlayerPosition[0], min(max(PlayerPosition[1]+1,0), 7))
            noChange[3] = arrayOf(min(max(PlayerPosition[0]-1, 0), 7), PlayerPosition[1])
            noChange[4] = arrayOf(PlayerPosition[0], min(max(PlayerPosition[0]-1, 0), 7))
            for(i in 0..7)
                for(j in 0..7)
                    if(arrayOf(i, j) !in noChange){
                        buttons[i][j].setBackgroundColor(Color.BLACK)
                    }
        }

        fun isCoinCollected(): Boolean{
            if(PlayerPosition in CoinsPosition && PlayerPosition !in CollectedCoins){
                CollectedCoins.add(PlayerPosition)
                NumberOfCollectedCoins++
                redraw()
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


            if(id == null) {
                //ToDO: Поменять местами
                //ToDO: Задать объявление из файлов
                Log.d("Map", context.resources.getStringArray(R.array.map_1)[0])

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

    val REQUEST_EXIT = 1
    //0 - продолжить
    //1 - выйти


    val Buttons = Array(8){i -> Array(8){i -> -1}}



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 1) finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)

        /*val map: MapOfLabyrinth = if(intent.hasExtra("Id_Of_Level")) {
            Log.d("Map", "It has extra")
            MapOfLabyrinth(intent.getStringExtra("Id_Of_Level").toInt(), this)
        }
        else {
            MapOfLabyrinth(null, this)
        }
        map.redraw(map.PlayerPosition)*/


        Log.d("Tag", "Create")



        //ToDo


        /*val tr = TableRow(this)

    tr.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)


    table.addView(tr)*/

        val n = 64
        for (i in 0..7) {
            for (j in 0..7)
            {
                //Log.d("Cre", "base_width: ${baselayout.width}\nbase_heigth: ${baselayout.height}")
                val button = ImageButton(this)
                button.layoutParams = TableRow.LayoutParams(0, 175, 1f)//baselayout.width/8, (baselayout.height*0.7/8).toInt(), 1f)
                button.setBackgroundResource(R.drawable.img_000)



                //button.text = "123"   <- Button


                //button.width = LinearLayout.LayoutParams.WRAP_CONTENT
                //button.height = LinearLayout.LayoutParams.WRAP_CONTENT


                button.id = (i.toString() + j.toString()).toInt()

                Buttons[i][j] = (i.toString() + j.toString()).toInt()

//                    val lp = LinearLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.toFloat())
//                    button.layoutParams = lp

                when (i) {
                    0 -> tablerow1.addView(button)
                    1 -> tablerow2.addView(button)
                    2 -> tablerow3.addView(button)
                    3 -> tablerow4.addView(button)
                    4 -> tablerow5.addView(button)
                    5 -> tablerow6.addView(button)
                    6 -> tablerow7.addView(button)
                    7 -> tablerow8.addView(button)
                }
            }
        }


        /*for(i in 0 until n) {
            val button = findViewById<ImageButton>(Buttons[i / 8][i % 8])
            Log.d("Err", "\nid: ${Buttons[i / 8][i % 8]}\nbutton: $button")
            when (i / 8) {
                0 -> tablerow1.addView(button)
                1 -> tablerow2.addView(button)
                2 -> tablerow3.addView(button)
                3 -> tablerow4.addView(button)
                4 -> tablerow5.addView(button)
                5 -> tablerow6.addView(button)
                6 -> tablerow7.addView(button)
                7 -> tablerow8.addView(button)
            }
        }*/



        button_pause.setOnClickListener {
            val intent = Intent(this, PauseActivity::class.java)
            startActivityForResult(intent, REQUEST_EXIT)
        }




        /*button00.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(0, 0)
        }
        button01.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(0, 1)
        }
        button02.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(0, 2)
        }
        button03.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(0, 3)
        }
        button04.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(0, 4)
        }
        button05.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(0, 5)
        }
        button06.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(0, 6)
        }
        button07.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(0, 7)
        }
        button10.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(1, 0)
        }
        button11.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(1, 1)
        }
        button12.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(1, 2)
        }
        button13.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(1, 3)
        }
        button14.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(1, 4)
        }
        button15.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(1, 5)
        }
        button16.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(1, 6)
        }
        button17.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(1, 7)
        }
        button20.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(2, 0)
        }
        button21.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(2, 1)
        }
        button22.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(2, 2)
        }
        button23.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(2, 3)
        }
        button24.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(2, 4)
        }
        button25.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(2, 5)
        }
        button26.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(2, 6)
        }
        button27.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(2, 7)
        }
        button30.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(3, 0)
        }
        button31.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(3, 1)
        }
        button32.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(3, 2)
        }
        button33.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(3, 3)
        }
        button34.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(3, 4)
        }
        button35.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(3, 5)
        }
        button36.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(3, 6)
        }
        button37.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(3, 7)
        }
        button40.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(4, 0)
        }
        button41.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(4, 1)
        }
        button42.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(4, 2)
        }
        button43.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(4, 3)
        }
        button44.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(4, 4)
        }
        button45.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(4, 5)
        }
        button46.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(4, 6)
        }
        button47.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(4, 7)
        }
        button50.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(5, 0)
        }
        button51.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(5, 1)
        }
        button52.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(5, 2)
        }
        button53.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(5, 3)
        }
        button54.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(5, 4)
        }
        button55.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(5, 5)
        }
        button56.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(5, 6)
        }
        button57.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(5, 7)
        }
        button60.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(6, 0)
        }
        button61.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(6, 1)
        }
        button62.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(6, 2)
        }
        button63.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(6, 3)
        }
        button64.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(6, 4)
        }
        button65.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(6, 5)
        }
        button66.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(6, 6)
        }
        button67.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(6, 7)
        }
        button70.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(7, 0)
        }
        button71.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(7, 1)
        }
        button72.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(7, 2)
        }
        button73.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(7, 3)
        }
        button74.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(7, 4)
        }
        button75.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(7, 5)
        }
        button76.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(7, 6)
        }
        button77.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
            map.update(7, 7)
        }
        */
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
