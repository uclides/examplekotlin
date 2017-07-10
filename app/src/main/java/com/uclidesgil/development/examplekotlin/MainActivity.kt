package com.uclidesgil.development.examplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.txtTimer
import kotlinx.android.synthetic.main.activity_main.txttimerElapsed
import kotlinx.android.synthetic.main.activity_main.button
import com.uclidesgil.development.examplekotlin.MainActivity.MalibuCountDownTimer



class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val countDownTimer: MalibuCountDownTimer? = null
    private var timeElapsed: Long = 0
    private var timerHasStarted: Boolean = false

    private final val startTime = (50 * 1000).toLong()
    private final val interval = (1 * 1000).toLong()

    //call when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onClick(p0: View?) {
     when(p0){
         button -> {
             timerHasStarted = true
             button?.setText("start")
         }
         else -> {
             timerHasStarted = false
             button?.setText("reset")
         }
     }
    }


    //CountDownTimer class
    inner class MalibuCountDownTimer(millisInFuture: Long,
                                      countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

        fun MalibuCountDownTimer(millisInFuture: Long, countDownInterval: Long){
            super.start()
        }
        override fun onFinish() {
            txtTimer.setText("Time's up")
            txttimerElapsed.setText("Time Elapsed: " + startTime.toString())
        }

        override fun onTick(p0: Long) {
            txtTimer.setText("Time remain: " + p0)
            timeElapsed = startTime - p0
            txttimerElapsed.setText("Time Elapsed: " + timeElapsed.toString())
        }

    }
}
