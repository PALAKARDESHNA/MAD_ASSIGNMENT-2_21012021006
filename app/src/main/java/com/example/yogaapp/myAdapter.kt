package com.example.yogaapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text
import java.util.zip.Inflater

class myAdapter(private  val context:Context ,private val arrayList: ArrayList<Items>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val convertView: View? = LayoutInflater.from(context).inflate(R.layout.custom_listview,parent,false)


        val imageview : ImageView =  convertView!!.findViewById(R.id.list_yoga_img)
        val yoga_type:TextView = convertView.findViewById(R.id.list_yoga_type)
        val yoga_time:TextView = convertView.findViewById(R.id.list_yoga_time)
        val yoga_title:TextView = convertView.findViewById(R.id.list_yoga_title)

        imageview.setImageResource(arrayList[position].imgid)

        yoga_type.text = arrayList[position].yogatype
        yoga_time.text = arrayList[position].yogatime
        yoga_title.text = arrayList[position].yoganame

        return convertView
    }
}