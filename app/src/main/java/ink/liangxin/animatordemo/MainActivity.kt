package ink.liangxin.animatordemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

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
     * 根据给定Activity类型来启动Activity
     * */
    private fun gotoActivity(activityClass: Class<*>) {
        startActivity(Intent(this, activityClass))
    }
}