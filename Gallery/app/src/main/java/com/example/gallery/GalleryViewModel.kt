package com.example.gallery

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    private val _photoListLive = MutableLiveData<List<PhotoItem>>()
    val photoListLive: LiveData<List<PhotoItem>>
        get() = _photoListLive

    var text: MutableLiveData<String> = MutableLiveData<String>()
    var url: MutableLiveData<String> = MutableLiveData<String>()
    var pageNumber: MutableLiveData<Int> = MutableLiveData<Int>()
    lateinit var titleName: String
    lateinit var keyWordsArray: List<String>
    lateinit var keyWords: String
    lateinit var urlString: String

    fun fetchData() {
        val stringRequest = StringRequest(
            Request.Method.GET,
            getUrl(),
            Response.Listener {
                _photoListLive.value = Gson().fromJson(it, Pixabay::class.java).hits.toList()
            },
            Response.ErrorListener {
                Log.d("hello", it.toString())
            },
        )
        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
    }


    private fun getUrl(): String {
        keyWordsArray = text.value?.split(" ")!!
        keyWords = keyWordsArray?.joinToString("+")
        titleName = text.value!!.split(" ").joinToString(",")
        urlString =
            "https://pixabay.com/api/?key=23944393-79dd848424c93dabfed9f8dda&q=${keyWords}&per_page=100&page=${pageNumber.value.toString()}"
        //println(urlString)
        url.value = urlString
        //println("url is: " + url.value)
        //println("text_value is: " + text.value)
        //println("keyWords_array is: " + keyWords_array)
        //println("keyWords is: " + keyWords)

        return urlString
    }

}