package info.sanaebadi.ankotest.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.view.Gravity
import info.sanaebadi.ankotest.activity.MainActivity
import info.sanaebadi.ankotest.R
import info.sanaebadi.ankotest.activity.SecondActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        frameLayout {
            val textField = editText {
                hint = "Toast for toasts and snakebars"
            }.lparams(width = matchParent) {
                margin = dip(12)
                topMargin = dip(30)
            }

            imageView(R.drawable.ic_android_black_24dp) {
                onClick {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        this@imageView.imageTintList =
                            ColorStateList.valueOf(Color.parseColor("#4caf50"))
                    }
                }
            }.lparams(dip(72), dip(72)) {
                gravity = Gravity.CENTER
            }

            linearLayout {
                button("Show Toast") {
                    onClick {
                        toast(textField.text)
                    }
                }

                button("Show Snackbar") {
                    onClick {
                        longSnackbar(this@frameLayout, textField.text.toString())
                    }
                }

            }.lparams {
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(72)
            }

            button("Go to Next Page") {
                textSize=13f
                textColor=Color.parseColor("#992255")
                backgroundColor=Color.parseColor("#ffffff")
                padding=dip(10)
                onClick {
                    startActivity<SecondActivity>()
                }
            }.lparams(
                dip(120),
                dip(50),
                gravity = Gravity.BOTTOM or Gravity.CENTER
            ){
                margin=dip(10)
            }
        }
    }

}