package com.example.realprojectandroidpertama

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Game>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "List"
        recyclerView = findViewById(R.id.recycleview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<Game>()
        getData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.about_page -> {
                val intent = Intent(this, ProfilePageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getData(){
        val titleList = resources.getStringArray(R.array.game_judul)
        val sinopsisList = resources.getStringArray(R.array.game_sinopsis)
        val scrolltextList = resources.getStringArray(R.array.game_scrolltext)
        val logo = resources.obtainTypedArray(R.array.game_logo)
        val background = resources.obtainTypedArray(R.array.game_background)
        val sharelinkList = resources.getStringArray(R.array.link)
        for (i in titleList.indices){
            val game = Game(logo.getResourceId(i,0), background.getResourceId(i,0),titleList[i],
                sinopsisList[i], scrolltextList[i], sharelinkList[i])
            dataList.add(game)
        }
        logo.recycle()
        background.recycle()
        recyclerView.adapter = Adapter(dataList)
    }

}