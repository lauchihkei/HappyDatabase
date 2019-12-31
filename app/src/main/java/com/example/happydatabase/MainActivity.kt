package com.example.happydatabase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var feelingViewModel: FeelingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = FeelingAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //initialize viewModel
        feelingViewModel = ViewModelProvider(this).get(FeelingViewModel::class.java)

        //initialize life data
        feelingViewModel.allFeelings.observe(this,
            Observer { feelingList ->
                feelingList?.let {
                    if (it.isNotEmpty()) {
                        adapter.setFeeling(it)
                        Toast.makeText(applicationContext, "Num:" + it.size, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })




        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        fab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)

            startActivityForResult(intent, REQUEST_CODE)
        }
    }




        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            return when (item.itemId) {
                R.id.action_settings -> true
                else -> super.onOptionsItemSelected(item)
            }
        }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            val _mode = data?.getIntExtra(
                AddActivity.EXTRA_MODE, 0
            )

            val _remark =data?.getStringExtra(
                AddActivity.EXTRA_REMARK
            )

            val feeling = Feeling(
                id = 0,
                mode = _mode!!,
                remarks = _remark!!

            )

            feelingViewModel.insertFeeling(feeling)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    companion object {
            const val REQUEST_CODE = 1
        }

    }









