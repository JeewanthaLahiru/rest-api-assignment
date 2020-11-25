package com.example.rest_api_fundamental

import android.content.IntentFilter.create
import android.net.DnsResolver
import android.os.Bundle
import android.renderscript.ScriptIntrinsicBLAS.create
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rest_api_fundamental.posts.api.PostApi
import com.example.rest_api_fundamental.posts.model.Post
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.create
import java.net.URI.create


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment




        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val gson = GsonBuilder()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        var postApi = retrofit.create(PostApi::class.java)
        var postCall = postApi.post
        postCall.enqueue(object : Callback<Post>{
            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var title = response.body()!!.title
                Log.d("SecondFragment", "tittle is : " + title)
                view.findViewById<TextView>(R.id.textview_second).text = title
            }

        })
    }
}
