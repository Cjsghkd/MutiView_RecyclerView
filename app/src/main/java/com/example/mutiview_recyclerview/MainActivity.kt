package com.example.mutiview_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)

        val list = listOf(
            Model(Model.TEXT_TYPE, "카테고리 1번!", 0, null),
            Model(Model.IMAGE_TYPE, "텍스트뷰 아래에 이미지가 있는 뷰 타입", R.drawable.snow, null),
            Model(Model.IMAGE_TYPE_2, "안녕, 제목부분이 될거야", R.drawable.snow, "내용부분!"),
            Model(Model.IMAGE_TYPE, "다시 한 번 텍스트 옆에 이미지가 있는 뷰타입", R.drawable.snow, null),
            Model(Model.IMAGE_TYPE_2, "제목2!!", R.drawable.snow, "사진에 대한 설명?"),

            Model(Model.TEXT_TYPE, "카테고리 2번!", 0, null),
            Model(Model.IMAGE_TYPE, "새로운 카테고리 시작!.", R.drawable.snow, null),
            Model(Model.IMAGE_TYPE, "다음생엔 울창한 숲의 이름모를 나무로 태어나 평화로이 살다가 누군가의 유서가 되고 싶다.", R.drawable.snow, null),
            Model(Model.IMAGE_TYPE_2, "제목부분", R.drawable.snow, "내용부분")
        )

        val adapter = MultiViewTypeAdapter(list)
        recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_view.adapter = adapter
    }
}