package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val tag:String ="LIFE_CYCLE"

   lateinit var recyclerView: RecyclerView
   lateinit var buttonF1:Button
   lateinit var buttonF2:Button
   lateinit var edName:EditText

   lateinit var tabLayout:TabLayout
   lateinit var viewPager2:ViewPager2

   lateinit var bottomNavigationView: BottomNavigationView
   lateinit var frameLayout:FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(tag,"onCreate")
        Log.v(tag,"onCreate")
        Log.v(tag,"onCreate")
        Log.v(tag,"onCreate")
        Log.v(tag,"onCreate")

        connectViews()
        whenBottomNavClicked()
        chooseFragment(HomeFragment(),"HOME")



        //prepareTabs()
        //openF1()
        //openF2()
        //prepareRecycleView()
        // navigation()
        //openApp()

    }

    private fun connectViews(){

        bottomNavigationView = findViewById(R.id.bottomNav)
        frameLayout = findViewById(R.id.Fl)

//        tabLayout= findViewById(R.id.Tl)
//        viewPager2=findViewById(R.id.Vp)
//        recyclerView=findViewById(R.id.Rv)
//        buttonF1= findViewById(R.id.BtF1)
//        buttonF2= findViewById(R.id.BtF2)
//        frameLayout= findViewById(R.id.Fl)
//        edName= findViewById(R.id.EdName)
    }

    private fun whenBottomNavClicked(){
     bottomNavigationView.setOnItemSelectedListener{
         when(it.itemId){
             R.id.home->{
                 chooseFragment(HomeFragment(),"HOME")
             }
             R.id.settings->{
                 chooseFragment(SettingsFragment(),"SETTINGS")
             }
             R.id.profile->{
                 chooseFragment(ProfileFragment(),"PROFILE")
             }
         }
         true
     }
    }

    private fun chooseFragment(fragment: Fragment ,tag:String){
        val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.Fl,fragment,tag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.commit()
    }



    private fun prepareTabs(){
        val fragmentAdapter = FragmentAdapter(supportFragmentManager,lifecycle)

        fragmentAdapter.addFragment(FirstFragment(),"tab 1")
        fragmentAdapter.addFragment(SecondFragment(),"tab 2")
        fragmentAdapter.addFragment(ThirdFragment(),"tab 3")

        viewPager2.adapter = fragmentAdapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position ->

            tab.text = fragmentAdapter.fragmentTitles[position]

        }.attach()


    }

//    private fun openF1(){
//        buttonF1.setOnClickListener {
//            val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.Fl,FirstFragment(),"First_Fragment")
//            fragmentTransaction.addToBackStack("First_Fragment")
//            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//
//            fragmentTransaction.commit()
//        }
//    }

//    private fun openF2(){
//        buttonF2.setOnClickListener {
//            val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.Fl,SecondFragment(),"Second_Fragment")
//            fragmentTransaction.addToBackStack("Second_Fragment")
//            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//
//            fragmentTransaction.commit()
//        }
//    }


//    private fun navigation(){
//        button.setOnClickListener {
//            val intent:Intent=Intent(this,SecondActivity::class.java)
//            intent.putExtra("Name",edName.text.toString())
//            startActivity(intent)
//
//        }
//    }

//    private fun openApp(){
//        buttonApp.setOnClickListener {
//            val i:Intent=Intent(Intent.ACTION_DIAL)
//            i.data= Uri.parse("tel:01234567899")
//            startActivity(i)
//
//        }
//    }

    private fun prepareRecycleView(){

        var array:ArrayList<Person> = ArrayList()

        array.add(Person("Ali","M",R.drawable.profile))
        array.add(Person("Ali","M",R.drawable.profile))
        array.add(Person("Ali","M",R.drawable.profile))
        array.add(Person("Ali","s",R.drawable.profile))
        array.add(Person("Ali","sM",R.drawable.profile))
        array.add(Person("Ali","v",R.drawable.profile))
        array.add(Person("Ali","f",R.drawable.profile))
        array.add(Person("Ali","e",R.drawable.profile))
        array.add(Person("Ali","Ms",R.drawable.profile))
        array.add(Person("Ali","a",R.drawable.profile))
        array.add(Person("Ali","M",R.drawable.profile))

        var customAdapter:CustomAdapter= CustomAdapter(array)

       recyclerView.adapter=customAdapter
    }



    override fun onStart() {
        super.onStart()
        Log.v(tag,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(tag,"onResum")
    }

    override fun onPause() {
        super.onPause()
        Log.v(tag,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag,"onDestroy")

    }

}