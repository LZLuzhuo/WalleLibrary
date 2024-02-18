package me.luzhuo.walledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import me.luzhuo.lib_walle.WalleChannelReader
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvChannel = findViewById<TextView>(R.id.tv_channel)
        // 读取渠道信息
        val cancel = WalleChannelReader.getChannel(this.applicationContext) ?: "official"
        tvChannel.text = cancel

        val sb = StringBuilder()
        // 读取所有信息(含渠道信息)
        WalleChannelReader.getChannelInfoMap(this)?.forEach {
            sb.append("${it.key} - ${it.value}\r\n")
        }
        val cancels = sb.toString()
        //tvChannel.text = cancels
    }
}