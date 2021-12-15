package com.example.yogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.yogaapp.databinding.ActivityHomeBinding
import com.example.yogaapp.databinding.ActivityMainBinding

class Yoga_List_View : AppCompatActivity() {
    private lateinit var listView : ListView
     val userArrayList: ArrayList<Items> = ArrayList()
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_yoga_list_view)

         listView = findViewById(R.id.yogaListView)
supportActionBar?.hide()
         val imageid = intArrayOf(
             R.drawable.yoga1,
             R.drawable.yoga2,
             R.drawable.yoga3,
             R.drawable.yoga4,
             R.drawable.yoga5,
             R.drawable.yoga6,
             R.drawable.yoga7,
             R.drawable.yoga8,
             )

         val yoga_title = arrayOf(
             "INNER PEACE",
             "SLOW STRETCH",
             "TWIST DETOX",
             "FLEXIBLE FLOW",
             "POWER FLOW",
             "ENERGY BOOSTER",
             "SLOW FLOW",
         "YOGA FOR BACK",
         )

         val yoga_type = arrayOf(
             "BEGINNER",
             "BEGINNER",
             "INTERMEDIATE",
             "BEGINNER",
             "INTERMEDIATE",
             "BEGINNER",
             "INTERMEDIATE",
             "INTERMEDIATE",
         )

         val yoga_time = arrayOf(
             "7 min ~ 18 calries",
             "7 min ~ 19 calries",
             "8 min ~ 26 calries",
             "6 min ~ 15 calries",
             "8 min ~ 24 calries",
             "10 min ~ 33 calries",
             "8 min ~ 20 calries",
             "7 min ~ 28 calries",

             )

         for( i in yoga_title.indices) {
             val item = Items(yoga_title[i], yoga_time[i], yoga_type[i], imageid[i])
             userArrayList.add(item)
         }


         val adapter = myAdapter(this,userArrayList)
         listView.adapter = adapter

      listView.isClickable = true
         listView.setOnItemClickListener { parent, view, position, id ->
             val name = yoga_title[position]
             val type = yoga_type[position]
             val time = yoga_time[position]
             val img = imageid[position]

            val i = Intent(this,detail_yoga_pose::class.java)
             i.putExtra("name",name)
             i.putExtra("type",type)
             i.putExtra("time",time)
             i.putExtra("img",img)
             startActivity(i)
         }

    }
}