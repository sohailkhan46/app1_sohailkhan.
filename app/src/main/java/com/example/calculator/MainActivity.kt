package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.buttonsheet_fragment.*

class MainActivity : AppCompatActivity() {


    //creating arrays for the spinners options
    val dropdownlist1= arrayOf("Water", "Citrus Fruits")
    val dropdownlist2= arrayOf("Coffee beans", "Milk")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetfragment = BottomSheetfragment()
        button.setOnClickListener {

        }
        toast_button.setOnClickListener {
            Toast.makeText(applicationContext,"In this app the selections select two items to get the" +
                    " food combination result",Toast.LENGTH_LONG).show()
        }
//In
        //creating adapters value for the view purposes
        val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist1)
        val adapter2=ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist2)

        //creating a variable name b1 for button

        var b1=findViewById(R.id.button) as Button


        //setting the adapters for the view purpose
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)


//setting the 1st spinner
        elements1.adapter=adapter
        elements1.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position: Int,id: Long)
            {
                if(elements1.selectedItemPosition==0)
                {
                    textView.setText(" " + elements1.selectedItem)

                }
                if(elements1.selectedItemPosition==1)
                {
                    textView.setText(" " + elements1.selectedItem)

                }
            }
        }

        //setting the 2nd spinner
        elements2.adapter=adapter2
        elements2.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position: Int,id: Long)
            {
                if(elements2.selectedItemPosition==0)
                {
                    textView2.setText(" " + elements2.selectedItem)

                }
                if(elements2.selectedItemPosition==1)
                {
                    textView2.setText(" " + elements2.selectedItem)

                }
            }
        }

        //Once the user clicks the button, following text should be displayed based on the selected //items position in relevant array
        b1.setOnClickListener{
            if(elements1.selectedItemPosition==0 && elements2.selectedItemPosition==0)
            {
                textView3.setText("The answer is: Enjoy the Coffee")
            }
            if(elements1.selectedItemPosition==0 && elements2.selectedItemPosition==1)
            { textView3.setText("The answer is:  It provides calcium in the body.")}

            if(elements1.selectedItemPosition==1 && elements2.selectedItemPosition==0)
            {
                textView3.setText("The answer is: It can lead to caffeine addiction ")
            }

            if(elements1.selectedItemPosition==1 && elements2.selectedItemPosition==1)
            {
                textView3.setText("The answer is: It can lead to gas and heat burn")
            }

        }
    }
}

