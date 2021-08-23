package com.example.listviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()

        for (i in 0 until 100) {
            if (i % 5 == 0 ) {
                var menu = mutableMapOf("name" to "から揚げ弁当", "price" to "800円")
                menuList.add(menu)
            }
            if(i % 5 == 1){
                var menu = mutableMapOf("name" to "チーズバーガーセット", "price" to "900円")
                menuList.add(menu)
            }
            if(i % 5 == 2){
                var menu = mutableMapOf("name" to "ミックスピザ", "price" to "1,000円")
                menuList.add(menu)
            }
            if(i % 5 == 3){
                var menu = mutableMapOf("name" to "海鮮丼", "price" to "1,100円")
                menuList.add(menu)
            }
            if(i % 5 == 4){
                var menu = mutableMapOf("name" to "焼肉弁当", "price" to "1,200円")
                menuList.add(menu)
            }
        }

        val from = arrayOf("name", "price")

        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(this@MainActivity, menuList, android.R.layout.simple_list_item_2, from, to)

        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListner()
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

            val item = parent.getItemAtPosition(position) as MutableMap<String, String>

            val menuName = item["name"]
            val menuPrice = item["price"]

            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)

            intent2MenuThanks.putExtra("menuName", menuName)
            intent2MenuThanks.putExtra("menuPrice", menuPrice)
            startActivity(intent2MenuThanks)
        }
    }
}
