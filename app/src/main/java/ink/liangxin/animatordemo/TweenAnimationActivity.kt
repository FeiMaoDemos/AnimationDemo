package ink.liangxin.animatordemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ink.liangxin.animatordemo.PageUtils.Companion.gotoActivity


/**
 * 用于演示补间动画的类
 * */
class TweenAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweened_animation)
    }

    /**
     * 启动补间动画基本属性的演示页面
     * */
    fun base(view: View) {
        gotoActivity(BaseFrameAnimationActivity::class.java)
    }

    /**
     * 启动系统默认的补间动画使用方法的演示页面
     * */
    fun baseTweenAnimation(view: View) {
        gotoActivity(NormalTweenAnimationActivity::class.java)
    }

    /**
     * 启动第三方补间动画的演示页面
     * */
    fun thirdPartyTweenAnimation(view: View) {
        gotoActivity(ThirdPartyTweenAnimationActivity::class.java)
    }

    /**
     * 启动补间动画回调的演示页面
     * */
    fun animationCallback(view: View) {
        gotoActivity(AnimationCallbackActivity::class.java)
    }
}