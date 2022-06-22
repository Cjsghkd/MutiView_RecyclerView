package com.example.mutiview_recyclerview

data class Model(val type : Int, val text : String, val data : Int, val contentString : String?) {
    companion object {
        const val TEXT_TYPE = 0
        const val IMAGE_TYPE = 1
        const val IMAGE_TYPE_2 = 2
    }
}
