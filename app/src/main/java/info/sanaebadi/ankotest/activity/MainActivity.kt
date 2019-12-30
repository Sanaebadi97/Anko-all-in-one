package info.sanaebadi.ankotest.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import info.sanaebadi.ankotest.ui.MainActivityUI
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

    }
}
