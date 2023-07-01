package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


class ThirdFragment : Fragment() {

    lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectView(view)
        prepareListView()

    }

   private fun connectView(view:View){
        listView=view.findViewById(R.id.listView)
    }

    private fun prepareListView(){
        val array:ArrayList<String> = ArrayList()

     for(i in 1..100){
            array.add("A")
     }

        Log.v("Test","Array ${array.size}")

        val  arrayAdapter:ArrayAdapter<String> = ArrayAdapter(requireContext(),
           android.R.layout.simple_spinner_dropdown_item,array)

        listView.adapter = arrayAdapter
    }
}