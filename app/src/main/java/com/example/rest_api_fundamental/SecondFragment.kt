package com.example.rest_api_fundamental

import android.content.IntentFilter.create
import android.net.DnsResolver
import android.os.Bundle
import android.renderscript.ScriptIntrinsicBLAS.create
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rest_api_fundamental.posts.ListAdapter
import com.example.rest_api_fundamental.posts.api.PostApi
import com.example.rest_api_fundamental.posts.model.Post
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.create
import java.net.URI.create
import android.widget.ListAdapter as ListAdapter1


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val data = listOf(
        Post(1,1,"title1","body1"),
        Post(2,2,"title2","body2"),
        Post(3,3,"title3","body3"),
        Post(4,4,"title4","body4"),
        Post(5,5,"title5","body5"),
        Post(6,6,"title6","body6"),
        Post(7,7,"title7","body7")
    )

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

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(PostApi::class.java)
        api.fetchAllData().enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                showData(response.body()!!)
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                d("failure","on Failure")
            }


        })


        /*var recyclerViewList: RecyclerView
        recyclerViewList = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerViewList.adapter = ListAdapter(data)
        recyclerViewList.layoutManager = LinearLayoutManager(context)
        recyclerViewList.setHasFixedSize(true)




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
                Log.v("Retrofit","Call failed")
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var title = response.body()!!.title
                Log.d("SecondFragment", "tittle is : " + title)
                //view.findViewById<TextView>(R.id.textview_second).text = title
            }

        })*/
    }

    private fun showData(users:List<Post>){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ListAdapter(users)
        }
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<Post>) {

}
