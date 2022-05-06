package ink.liangxin.animatordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation

/**
 * 演示自定义补间动画的使用
 * */
class ThirdPartyTweenAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_party_tween_animation)
    }

    fun start(view: View) {
        val animation = Rotate3dAnimation(
            0f, 360f, 0.5f, 0.5f, 0.2f, true
        )
        animation.repeatCount = Animation.INFINITE
        animation.duration = 1000L

        view.startAnimation(animation)
    }
}