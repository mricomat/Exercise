package com.example.exercise.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.exercise.R
import com.example.exercise.ui.list.ListViewFragment

class MainActivity : AppCompatActivity() {

    private var mFragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        this.mFragmentManager = supportFragmentManager
        val fragment: Fragment = ListViewFragment.getInstance()
        if (mFragmentManager != null && mFragmentManager!!.fragments.size == 0) {
            mFragmentManager!!.beginTransaction()
                .replace(R.id.screen_container, fragment)
                .commit()
        }
    }
}
