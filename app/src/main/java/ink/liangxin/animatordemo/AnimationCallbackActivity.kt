package ink.liangxin.animatordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation

private const val DEFAULT_DURATION = 3000L

/**
 * 演示补间动画的监听器
 * */
class AnimationCallbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_callback)
    }

    fun start(view: View) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        Log.d("AnimationLog", "init, animation = $animation")
        animation.duration = DEFAULT_DURATION
        animation.repeatCount = 3
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                Log.d(
                    "AnimationLog",
                    "onAnimationStart, thread = ${Thread.currentThread().name}, animation = $animation"
                )
            }

            override fun onAnimationEnd(animation: Animation?) {
                Log.d(
                    "AnimationLog",
                    "onAnimationEnd, thread = ${Thread.currentThread().name}, animation = $animation"
                )
            }

            override fun onAnimationRepeat(animation: Animation?) {
                Log.d(
                    "AnimationLog",
                    "onAnimationRepeat, thread = ${Thread.currentThread().name}, animation = $animation"
                )
            }
        })
        view.startAnimation(animation)
    }
}