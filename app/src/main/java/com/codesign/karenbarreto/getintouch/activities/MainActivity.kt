package com.codesign.karenbarreto.getintouch.activities

import android.content.Context
import android.content.Intent
import com.codesign.karenbarreto.getintouch.base.BaseActivity
import com.codesign.karenbarreto.getintouch.fragments.HomeFragment

class MainActivity : BaseActivity(){

    companion object {
        fun callingIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun fragment() = HomeFragment()
}
