package ink.liangxin.animatordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ink.liangxin.animatordemo.PageUtils.Companion.gotoActivity

/**
 * 主界面
 * */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * 启动帧动画布局
     * */
    fun frameAnimation(view: View) {
        gotoActivity(FrameAnimationActivity::class.java)
    }

    /**
     * 启动补间动画布局
     * */
    fun tweenAnimation(view: View) {
        gotoActivity(TweenAnimationActivity::class.java)
    }

}