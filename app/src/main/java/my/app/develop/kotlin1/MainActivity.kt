package my.app.develop.kotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buclick(view: View) {

        val buChoise = view as Button
        var callId = 0
        when(buChoise.id){
            R.id.bu1 -> callId=1
            R.id.bu2 -> callId=2
            R.id.bu3 -> callId=3
            R.id.bu4 -> callId=4
            R.id.bu5 -> callId=5
            R.id.bu6 -> callId=6
            R.id.bu7 -> callId=7
            R.id.bu8 -> callId=8
            R.id.bu9 -> callId=9
        }

        playGame(callId,buChoise)
//        buChoise.setBackgroundResource(R.color.red)
//        Toast.makeText(this,"callId: " +CallId.toString(),Toast.LENGTH_LONG).show()

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activeplayer = 1

    fun playGame ( CallId : Int , buChoise : Button ){

        if (activeplayer==1){
            buChoise.text="x"
            buChoise.setBackgroundResource(R.color.red)
            player1.add(CallId)
            activeplayer=2
        }else{
            buChoise.text="0"
            buChoise.setBackgroundResource(R.color.green)
            player2.add(CallId)
            activeplayer=1
        }
        buChoise.isEnabled=false
    }

}
