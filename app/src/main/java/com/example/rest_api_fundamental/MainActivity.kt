package com.example.rest_api_fundamental

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "This is an RESTAPI assignment", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        var view:View
        return when (item.itemId) {
            R.id.action_name -> {
                Snackbar.make(window.decorView.findViewById(android.R.id.content),"D.M.J.L.Maduranga Bandara",Snackbar.LENGTH_LONG).setAction("Action",null).show()
                true
            }
            R.id.action_stnumber -> {
                Snackbar.make(window.decorView.findViewById(android.R.id.content),"SE/2017/001",Snackbar.LENGTH_LONG).setAction("Action",null).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
