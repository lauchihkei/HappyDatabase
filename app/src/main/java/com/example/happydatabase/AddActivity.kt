package com.example.happydatabase

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.QuickContact.EXTRA_MODE
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    private var mode:Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        button_save.setOnClickListener {
            if(mode == 0){
                Toast.makeText(applicationContext , "Please select a mode", Toast.LENGTH_SHORT).show()
            }

            val remark = editTextRemark.text.toString()
            val intent = Intent()

            intent.putExtra(EXTRA_MODE , mode)
            intent.putExtra(EXTRA_REMARK , remark)

            setResult(Activity.RESULT_OK , intent)
            finish()

        }
        imageViewHappy.setOnClickListener{
            mode = 3
            it.setBackgroundColor(Color.GREEN)
        }

        imageViewNeutral.setOnClickListener{
            mode = 2
            it.setBackgroundColor(Color.YELLOW)
        }

        imageViewSad.setOnClickListener {
            mode = 1
            it.setBackgroundColor(Color.RED)
        }



        }

    companion object {
        const val EXTRA_MODE = "com.example.happydb.MODE"
        const val EXTRA_REMARK = "com.example.happydb.REMARK"
    }
}
