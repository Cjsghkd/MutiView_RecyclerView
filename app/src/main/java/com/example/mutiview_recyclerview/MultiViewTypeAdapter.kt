package com.example.mutiview_recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.RuntimeException

class MultiViewTypeAdapter(private val list : List<Model>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View?
        return when (viewType) {
            Model.TEXT_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.text_type, parent, false)
                TextTypeViewHolder(view)
            }
            Model.IMAGE_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.image_type, parent, false)
                ImageTypeViewHolder(view)
            }
            Model.IMAGE_TYPE_2 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.image_type2, parent, false)
                ImageTypeView2Holder(view)
            }
            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("MultiViewTypeAdapter", "Hi, onBindViewHolder")
        val obj = list[position]
        when (obj.type) {
            Model.TEXT_TYPE -> (holder as TextTypeViewHolder).txtType.text = obj.text
            Model.IMAGE_TYPE -> {
                (holder as ImageTypeViewHolder).title.text = obj.text
                holder.image.setImageResource(obj.data)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        Log.d("MultiViewTypeAdapter", "Hi, getItemViewType")
        return list[position].type
    }

    inner class TextTypeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val txtType : TextView = itemView.findViewById(R.id.text_type_title)
    }

    inner class ImageTypeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.image_view_title)
        val image : ImageView = itemView.findViewById(R.id.background)
    }

    inner class ImageTypeView2Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.titleView)
        val content : TextView = itemView.findViewById(R.id.contentView)
        val image : ImageView = itemView.findViewById(R.id.imageView2)
    }
}