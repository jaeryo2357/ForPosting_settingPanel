package com.mut_jaeryo.settingpanel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("InlinedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //4개의 버튼 OnClickListener 를 깔끔하게 묶어서 정의
        val onClickListener : View.OnClickListener = View.OnClickListener { p0 ->
            var type : String = when(p0!!.id) {
                R.id.panel_network -> Settings.Panel.ACTION_INTERNET_CONNECTIVITY

                R.id.panel_audio -> Settings.Panel.ACTION_VOLUME

                R.id.panel_wifi -> Settings.Panel.ACTION_WIFI

                else -> Settings.Panel.ACTION_NFC
            }

            val panelIntent = Intent(type)
            startActivityForResult(panelIntent,1)
        }
        panel_network.setOnClickListener(onClickListener)
        panel_audio.setOnClickListener(onClickListener)
        panel_nfc.setOnClickListener(onClickListener)
        panel_wifi.setOnClickListener(onClickListener)
    }
}
