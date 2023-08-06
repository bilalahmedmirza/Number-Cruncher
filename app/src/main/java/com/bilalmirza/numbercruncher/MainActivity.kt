package com.bilalmirza.numbercruncher

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bilalmirza.numbercruncher.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            //  ALL CLEAR BUTTON
            btnAc.setOnClickListener {
                inputTxt.text = ""
                outPuttxt.text = ""
            }
            //  NUMBERS ADDING TO TEXT
            btn0.setOnClickListener {
                inputTxt.append("0")
            }
            btn1.setOnClickListener {
                inputTxt.append("1")
            }
            btn2.setOnClickListener {
                inputTxt.append("2")
            }
            btn3.setOnClickListener {
                inputTxt.append("3")
            }
            btn4.setOnClickListener {
                inputTxt.append("4")
            }
            btn5.setOnClickListener {
                inputTxt.append("5")
            }
            btn6.setOnClickListener {
                inputTxt.append("6")
            }
            btn7.setOnClickListener {
                inputTxt.append("7")
            }
            btn8.setOnClickListener {
                inputTxt.append("8")
            }
            btn9.setOnClickListener {
                inputTxt.append("9")
            }
            //  APPENDING OPERATORS TO TEXT
            btnPlus.setOnClickListener {
                inputTxt.append("+")
            }
            btnMinus.setOnClickListener {
                inputTxt.append("-")
            }
            btnMultiplication.setOnClickListener {
                inputTxt.append("×")
            }
            btnBracketOpen.setOnClickListener {
                inputTxt.append("(")
            }
            btnBracketClose.setOnClickListener {
                inputTxt.append(")")
            }
            btnDiv.setOnClickListener {
                inputTxt.append("÷")
            }
            btnDot.setOnClickListener {
                inputTxt.append(".")
            }
            //  EQUALS BUTTON
            btnEqual.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(getInputExpression()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if (result == longResult.toDouble()) {
                        outPuttxt.text = "= " + longResult.toString()
                    } else {
                        outPuttxt.text = "= " + result.toString()
                        outPuttxt.text = "= " + DecimalFormat("0.#####").format(result).toString()
                    }
                } catch (exception: Exception) {
                    Toast.makeText(this@MainActivity, "Please enter the correct expression.",
                        Toast.LENGTH_SHORT).show()
                    inputTxt.text = ""
                    outPuttxt.text = ""
                }
            }
            //  BACKSPACE BUTTON
            btnBackspace.setOnClickListener {
                val length = inputTxt.length()
                if (length > 0){
                    inputTxt.text = inputTxt.text.subSequence(0, length - 1)
                }
            }
        }
    }
    //  FUNCTION TO REPLACE '×' WITH '*' AND TO REPLACE '÷' WITH '/'
    private fun getInputExpression(): String {
        var expression = binding.inputTxt.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }
}