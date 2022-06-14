package com.example.simplemvvm.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplemvvm.R
import com.example.simplemvvm.util.addFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = FragmentList.newInstance()
        this.addFragment(
            R.id.container_id,
            this,
            fragment,
            FragmentList.newInstance().tag.toString(),
            true
        )
    }

    override fun onBackPressed() {
        val fragments = supportFragmentManager.backStackEntryCount
        if (fragments == 1) {
            finish()
        } else {
            if (supportFragmentManager.backStackEntryCount > 1) {
                supportFragmentManager.popBackStack()
            } else {
                super.onBackPressed()
            }
        }
    }

}