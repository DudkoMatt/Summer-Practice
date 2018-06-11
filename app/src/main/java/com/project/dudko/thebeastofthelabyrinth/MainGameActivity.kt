package com.project.dudko.thebeastofthelabyrinth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import com.project.dudko.thebeastofthelabyrinth.R.array.map_1
import kotlinx.android.synthetic.main.activity_main_game.*
import org.w3c.dom.Text
import java.util.*
import kotlin.math.max
import kotlin.math.min

class MainGameActivity : AppCompatActivity() {

    class MapOfLabyrinth(var id: Int? = null, var context: Activity, var buttons: Array<Array<ImageButton>>){


        //Ввод ID стен (без указания того, что есть в клетке)
        //Вывод: строка, содержащая 4 символа: LURD
        //Если на месте стоит -, значит ход в данную сторону невожможен
        val avaliable_turns = hashMapOf(
                0 to "LURD",
                1 to "LRD",
                2 to "LUD",
                3 to "LUR",
                4 to "URD",
                5 to "LD",
                6 to "LR",
                7 to "RD",
                8 to "LU",
                9 to "UD",
                10 to "UR",
                11 to "D",
                12 to "L",
                13 to "U",
                14 to "R")

        fun isTrunAvaliable(to_x: Int, to_y: Int): Boolean{
            if(to_x - PlayerPosition[0] == -1){  //U
                if(avaliable_turns[map[PlayerPosition[0]][PlayerPosition[1]] % 100]!!.contains("U"))
                    return true
                return false
            }
            if(to_x - PlayerPosition[0] == 1){   //D
                if(avaliable_turns[map[PlayerPosition[0]][PlayerPosition[1]] % 100]!!.contains("D"))
                    return true
                return false
            }
            if(to_y - PlayerPosition[1] == -1){  //L
                if(avaliable_turns[map[PlayerPosition[0]][PlayerPosition[1]] % 100]!!.contains("L"))
                    return true
                return false
            }
            if(to_y - PlayerPosition[1] == 1){   //R
                if(avaliable_turns[map[PlayerPosition[0]][PlayerPosition[1]] % 100]!!.contains("R"))
                    return true
                return false
            }
            return false
        }

        fun debug(){ //ToDO: remove in final version
            for(i in 0..7){
                var s = ""
                for(j in 0..7){
                    s += "${i};${j}: ${map[i][j]}   "
                }
                Log.d("Map", s+"\n")
            }

        }

        fun update(x: Int = 0, y: Int = 0, first: Boolean = false, darkMode: Boolean = false){
            Log.d("Msg", "In update")

            if(first) {
                if (!darkMode){
                    redraw()
                }
                if (darkMode){
                    // Отрисовали все поле черным
                    redrawWithBlack()
                    // Отрисовали игрока
                    drawPers(PlayerPosition[0], PlayerPosition[1])
                }
            }

            Log.d("Msg", "Before if: x=$x; y=$y")


            //ToDO: redraw для монстра

            if (((PlayerPosition[0] == x-1 && PlayerPosition[1] == y) ||
                    (PlayerPosition[0] == x && PlayerPosition[1] == y-1) ||
                    (PlayerPosition[0] == x && PlayerPosition[1] == y+1) ||
                    (PlayerPosition[0] == x+1 && PlayerPosition[1] == y)) &&
                    isTrunAvaliable(x, y)) { //ToDo: Стены
                Log.d("Msg", "In if")
                map[PlayerPosition[0]][PlayerPosition[1]] -= 400
                // обновил, откуда ушел
                fast_redraw(PlayerPosition[0], PlayerPosition[1])
                val oldX = PlayerPosition[0]
                val oldY = PlayerPosition[1]
                PlayerPosition[0] = x
                PlayerPosition[1] = y
                if (isCoinCollected()){
                    map[x][y] += 300
                } else {
                    map[x][y] += 400
                }
                // обновил, куда пришел
                if (!darkMode){
                    fast_redraw(PlayerPosition[0], PlayerPosition[1])
                }
                if(darkMode){
                    redrawWithBlack(oldX, oldY, PlayerPosition[0], PlayerPosition[1])
                }

                //redraw()
            }
            Log.d("Msg", "After if")

            //ToDO: переходить на заключительный экран, в случае true. Или добавлять кнопку exit?

            if(PlayerPosition[0] == ExitPosition[0] && PlayerPosition[1] == ExitPosition[1] && NumberOfCollectedCoins == CoinNumber){
                val intent = Intent(context, SuccessEndScreenActivity::class.java)
                context.startActivityForResult(intent, 1)
            }
        }

        /*fun redraw(){  //Для демонстрации работы "lock"
            buttons[PlayerPosition[0]][PlayerPosition[1]].setBackgroundColor(Color.GREEN)
            buttons[min(max(PlayerPosition[0]+1, 0), 7)][PlayerPosition[1]].setBackgroundColor(Color.GREEN)
            buttons[PlayerPosition[0]][min(max(PlayerPosition[1]+1,0), 7)].setBackgroundColor(Color.GREEN)
            buttons[min(max(PlayerPosition[0]-1, 0), 7)][PlayerPosition[1]].setBackgroundColor(Color.GREEN)
            buttons[PlayerPosition[0]][min(max(PlayerPosition[1]-1, 0), 7)].setBackgroundColor(Color.GREEN)
            val noChange = Array(5){i -> Array(2){i -> 0}}
            noChange[0] = arrayOf(PlayerPosition[0], PlayerPosition[1])
            noChange[1] = arrayOf(min(max(PlayerPosition[0]+1, 0), 7), PlayerPosition[1])
            noChange[2] = arrayOf(PlayerPosition[0], min(max(PlayerPosition[1]+1,0), 7))
            noChange[3] = arrayOf(min(max(PlayerPosition[0]-1, 0), 7), PlayerPosition[1])
            noChange[4] = arrayOf(PlayerPosition[0], min(max(PlayerPosition[1]-1, 0), 7))

            Log.d("Msg", "\n\n\n\n\n\n  noChange:\n0x=:${noChange[0][0]}; y=:${noChange[0][1]}\n  " +
                    "noChange:\n" +
                    "1:x=${noChange[1][0]}; y=${noChange[1][1]}\nnoChange:\n" +
                    "2:x=${noChange[2][0]}; y=${noChange[2][1]}\nnoChange:\n" +

                    "3:x=${noChange[3][0]}; y=${noChange[3][1]}\nnoChange:\n" +
                    "4:x=${noChange[4][0]}; y=${noChange[4][1]}\n  \n\n\n\n\n\n")

            for(i in 0..7)
                for(j in 0..7)
                    if(!checkXinY(arrayOf(i, j), noChange)){
                        buttons[i][j].setBackgroundColor(Color.GRAY)
                    }
        }


        fun checkXinY(x:Array<Int>, y:Array<Array<Int>>) : Boolean{
            Log.d("Msg", "x:(${x[0]};${x[1]})\ny:(${y[0][0]};${y[0][1]})    (${y[1][0]};${y[1][1]})    (${y[2][0]};${y[2][1]})    (${y[3][0]};${y[3][1]})    (${y[4][0]};${y[4][1]})")
            for(i in 0 until y.size){
                if(x[0] == y[i][0] && x[1] == y[i][1])
                    return true
            }
            return false
        }*/


        fun fill_with_zeros(x: Int): String = when(x){
                in 0..9 -> "00$x"
                in 10..99 -> "0$x"
                else -> x.toString()
            }

        fun redraw(){
            for(i in 0..7){
                for(j in 0..7){
                    val a = context.resources.getIdentifier("img_${fill_with_zeros(map[i][j])}", "drawable", context.packageName)
                    context.findViewById<ImageButton>(i*10+j).setBackgroundResource(a)
                }
            }
        }

        fun fast_redraw(x: Int, y: Int){
            if (x in 0..7 && y in 0..7) {
                val a = context.resources.getIdentifier("img_${fill_with_zeros(map[x][y])}", "drawable", context.packageName)
                context.findViewById<ImageButton>(x * 10 + y).setBackgroundResource(a)
            }
        }

        // все отрисовываем черным
        fun redrawWithBlack(){
            for(i in 0..7){
                for(j in 0..7){
                    val black = ContextCompat.getColor(context, R.color.black)
                    context.findViewById<ImageButton>(i*10+j).setBackgroundColor(black)
                }
            }
        }

        // дали позицию, рисуем норм фон в радиусе
        fun drawPers(x:Int, y:Int){
            for(i in 0..1){
                for (j in 0..1){
                    // чтобы 4 раза одна клетка не обновлялась
                    if (i == 0 && j == 0){
                        fast_redraw(x, y)
                    }
                    else{
                        if ((x - i) >= 0 && (y-j) >= 0)
                            fast_redraw(x-i, y-j)

                        if ((x - i) >= 0 && (y+j) <= 7)
                            fast_redraw(x-i, y+j)

                        if ((x + i) <= 7 && (y+j) <= 7)
                            fast_redraw(x+i, y+j)

                        if ((x + i) <= 7 && (y-j) >= 0)
                            fast_redraw(x+i, y-j)
                    }
                }
            }
        }

        fun redrawWithBlack(oldX:Int, oldY:Int, newX:Int, newY:Int){
            fast_redraw(newX, newY)
            // x вертикаль; y горизонталь
            // сходили по вертикали
            if (oldY == newY){
                // Ходили вверх
                if (newX < oldX){
                    // черним всю линию на oldX + 1
                    fastRedrawWithBlack(oldX+1, newY-1)
                    fastRedrawWithBlack(oldX+1, newY)
                    fastRedrawWithBlack(oldX+1, newY+1)
                    // прорисовывем линию на newX - 1
                    fast_redraw(newX-1, newY-1)
                    fast_redraw(newX-1, newY)
                    fast_redraw(newX-1, newY+1)
                }
                // ходили вниз
                else{
                    // черним всю линию на oldX - 1
                    fastRedrawWithBlack(oldX-1, newY-1)
                    fastRedrawWithBlack(oldX-1, newY)
                    fastRedrawWithBlack(oldX-1, newY+1)
                    // прорисовывем линию на newX + 1
                    fast_redraw(newX+1, newY-1)
                    fast_redraw(newX+1, newY)
                    fast_redraw(newX+1, newY+1)
                }
            }
            // сходили по горизонтали
            if(oldX == newX){
                // ходили вправо
                if (newY > oldY){
                    // черним всю линию по oldY-1
                    fastRedrawWithBlack(oldX-1, oldY-1)
                    fastRedrawWithBlack(oldX, oldY-1)
                    fastRedrawWithBlack(oldX+1, oldY-1)
                    // прорисовывем всю линию по newY + 1
                    fast_redraw(newX-1, newY+1)
                    fast_redraw(newX, newY+1)
                    fast_redraw(newX+1, newY+1)
                }
                // ходили влево
                else{
                    // черним всю линию по oldY + 1
                    fastRedrawWithBlack(oldX-1, oldY+1)
                    fastRedrawWithBlack(oldX, oldY+1)
                    fastRedrawWithBlack(oldX+1, oldY+1)
                    // отрисовываем линию по newY-1
                    fast_redraw(newX-1, newY-1)
                    fast_redraw(newX, newY-1)
                    fast_redraw(newX+1, newY-1)
                }
            }
        }

        // одну кнопку отрисовываем черным
        fun fastRedrawWithBlack(x: Int, y: Int){
            if (x in 0..7 && y in 0..7){
                val black = ContextCompat.getColor(context, R.color.black)
                context.findViewById<ImageButton>(x*10+y).setBackgroundColor(black)
            }
        }



        fun isCoinCollected(): Boolean{  //ToDO: вставить в update
            if(check_in_coins_position() && !check_in_collected_coins()){
                CollectedCoins.add(PlayerPosition.toList())
                NumberOfCollectedCoins++
                context.findViewById<TextView>(R.id.number_of_collected_coins).text = "#collected / #whole_number".replace("#collected", NumberOfCollectedCoins.toString()).replace("#whole_number", CoinNumber.toString())
                return true
            }
            return false
        }

        fun check_in_coins_position(): Boolean{
            for(i in CoinsPosition){
                if(PlayerPosition[0] == i[0] && PlayerPosition[1] == i[1]){
                    return true
                }
            }
            return false
        }

        fun check_in_collected_coins(): Boolean{
            for(i in CollectedCoins){
                if(PlayerPosition[0] == i[0] && PlayerPosition[1] == i[1]){
                    return true
                }
            }
            return false
        }

        var EnemyPosition = Array(2){i -> 0}
        var PlayerPosition = Array(2){i -> 0}
        var CoinNumber = 0
        var CoinsPosition = MutableList(CoinNumber){i -> List(2){i -> 0}}

        var CollectedCoins = MutableList(CoinNumber){i -> List(2){i -> 0}}
        var NumberOfCollectedCoins = 0

        var ExitPosition = Array(2){i -> 0} //Учитывать, что выход не сдвинут вне карты на одну клетку

        //ToDo: создать ID выхода -> 900

        var map = MutableList(0){i -> MutableList(2){0} }

        init{


            if(id != null) {
                //Log.d("Map", context.resources.getStringArray(R.array.map_1)[0])

                context.findViewById<TextView>(R.id.level_text).text = "Level: ${id}"

                val num_x = context.resources.getStringArray(context.resources.getIdentifier("map_${id}", "array", context.packageName))[0].split(" ")[0].toInt()
                val num_y =context.resources.getStringArray(context.resources.getIdentifier("map_${id}", "array", context.packageName))[0].split(" ")[1].toInt()
                ExitPosition[0] = context.resources.getStringArray(context.resources.getIdentifier("map_${id}", "array", context.packageName))[1].split(" ")[0].toInt()
                ExitPosition[1] = context.resources.getStringArray(context.resources.getIdentifier("map_${id}", "array", context.packageName))[1].split(" ")[1].toInt()



                CoinNumber = 0
                for(i in 2 until num_x+2){
                    var tmp = MutableList(num_y){0}
                    for(j in 0 until num_y){
                        tmp[j] = context.resources.getStringArray(context.resources.getIdentifier("map_${id}", "array", context.packageName))[i].split(" ")[j].toInt()
                        if(tmp[j] >= 400){
                            PlayerPosition[0] = i-2
                            PlayerPosition[1] = j
                        }
                        if(tmp[j] in 200..299){
                            EnemyPosition[0] = i-2
                            EnemyPosition[1] = j
                        }
                        if(tmp[j] in 100..199){
                            CoinsPosition.add(listOf(i-2, j))
                            CoinNumber++
                        }
                        if(tmp[j] in 300..399){
                            EnemyPosition[0] = i-2
                            EnemyPosition[1] = j
                            CoinsPosition.add(listOf(i-2, j))
                            CoinNumber++
                        }
                    }
                    map.add(tmp)
                }
                context.findViewById<TextView>(R.id.number_of_collected_coins).text = "#collected / #whole_number".replace("#collected", NumberOfCollectedCoins.toString()).replace("#whole_number", CoinNumber.toString())


            } else {
                map[0][0] = 407
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

        Log.d("Debug", resources.getIdentifier("img_000.jpg", "type/image", packageName).toString())

        Log.d("Tag", "Create")


        /*val tr = TableRow(this)

    tr.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)


    table.addView(tr)*/

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getRealSize(size)


        val num_x = resources.getStringArray(resources.getIdentifier("map_${intent.getStringExtra("Id_Of_Level").toInt()}", "array", packageName))[0].split(" ")[0].toInt()
        val num_y = resources.getStringArray(resources.getIdentifier("map_${intent.getStringExtra("Id_Of_Level").toInt()}", "array", packageName))[0].split(" ")[1].toInt()

        val n = 64
        for (i in 0..7) {
            for (j in 0..7)
            {
                //Log.d("Cre", "base_width: ${baselayout.width}\nbase_heigth: ${baselayout.height}")
                val button = ImageButton(this)
                button.layoutParams = TableRow.LayoutParams(size.y / num_y, (size.x / num_x).toInt(), 1f)//baselayout.width/8, (baselayout.height*0.7/8).toInt(), 1f)
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


        val ButtonsView = Array(8){i -> Array(8){j -> findViewById<ImageButton>(Buttons[i][j]) }}


        val map: MapOfLabyrinth = if(intent.hasExtra("Id_Of_Level")) {
            Log.d("Map", "It has extra")
            MapOfLabyrinth(intent.getStringExtra("Id_Of_Level").toInt(), this, ButtonsView)
        }
        else {
            MapOfLabyrinth(null, this, ButtonsView)
        }

        val sPref = getSharedPreferences("System", Context.MODE_PRIVATE)
        val darkMode = sPref.getBoolean("darkMode", false)

        map.update(map.PlayerPosition[0], map.PlayerPosition[1], first = true, darkMode = darkMode)

        map.debug()

        for(i in 0..7)
            for(j in 0..7)
                findViewById<ImageButton>(Buttons[i][j]).setOnClickListener {
                    map.debug()
                    map.update(i, j, darkMode = darkMode)
                    //Log.d("Msg", "Clicked on a button: i=$i; j=$j;                        Player's Position: x=${map.PlayerPosition[0]}; y=${map.PlayerPosition[1]}")
                }


    }

}
