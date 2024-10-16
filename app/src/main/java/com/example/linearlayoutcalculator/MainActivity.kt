package com.example.linearlayoutcalculator

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textReuslt: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textReuslt = findViewById(R.id.display_text_view)

        findViewById<Button>(R.id.button0).setOnClickListener(this)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
        findViewById<Button>(R.id.button_add).setOnClickListener(this)
        findViewById<Button>(R.id.button_sub).setOnClickListener(this)
        findViewById<Button>(R.id.button_mul).setOnClickListener(this)
        findViewById<Button>(R.id.button_div).setOnClickListener(this)
        findViewById<Button>(R.id.button_special3).setOnClickListener(this)
        findViewById<Button>(R.id.buttonCE).setOnClickListener(this)
        findViewById<Button>(R.id.buttonC).setOnClickListener(this)
        findViewById<Button>(R.id.buttonBS).setOnClickListener(this)
        findViewById<Button>(R.id.button_special1).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.button0) {
            addDigit(0)
        } else if (id == R.id.button1) {
            addDigit(1)
        } else if (id == R.id.button2) {
            addDigit(2)
        } else if (id == R.id.button3) {
            addDigit(3)
        } else if (id == R.id.button4) {
            addDigit(4)
        } else if (id == R.id.button5) {
            addDigit(5)
        } else if (id == R.id.button6) {
            addDigit(6)
        } else if (id == R.id.button7) {
            addDigit(7)
        } else if (id == R.id.button8) {
            addDigit(8)
        } else if (id == R.id.button9) {
            addDigit(9)
        } else if (id == R.id.button_add) {
            op = 1
            state = 2
        } else if (id == R.id.button_sub) {
            op = 2
            state = 2
        } else if (id == R.id.button_mul) {
            op = 3
            state = 2
        } else if (id == R.id.button_div) {
            op = 4
            state = 2
        } else if (id == R.id.button_special3) {
            var result = 0
            if (op == 1) {
                result = op1 + op2
            }
            if (op == 2) {
                result = op1 - op2
            }
            if (op == 3) {
                result = op1 * op2
            }
            if (op == 4) {
                if (op2 != 0) {
                    result = op1 / op2
                } else {
                    textReuslt.text = "ERROR"
                    return
                }
            }
            textReuslt.text = "$result"
            state = 1
            op1 = 0
            op2 = 0
            op = 0
        } else if (id == R.id.buttonCE){
            if (state == 1) {
                op1 = 0
                textReuslt.text = "0"
            } else {
                op2 = 0
                textReuslt.text = "0"
            }
        } else if (id == R.id.buttonC){
            op = 0
            op1 = 0
            op2 = 0
            state = 1
            textReuslt.text = "0"
        } else if (id == R.id.buttonBS) {
            if (state == 1) {
                op1 = op1 / 10
                textReuslt.text = "$op1"
            } else {
                op2 = op2 / 10
                textReuslt.text = "$op2"
            }
        } else if (id == R.id.button_special1) {
            if (state == 1) {
                op1 = -op1
                textReuslt.text = "$op1"
            } else {
                op2 = -op2
                textReuslt.text = "$op2"
            }
        }
    }

    fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            textReuslt.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            textReuslt.text = "$op2"
        }
    }
}

