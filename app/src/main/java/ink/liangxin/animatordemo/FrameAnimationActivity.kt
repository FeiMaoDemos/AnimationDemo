package ink.liangxin.animatordemo

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

/**
 * 帧动画演示页面
 * */
class FrameAnimationActivity : AppCompatActivity() {

    /**
     * 当前界面中所有帧动画的合集
     * */
    private val animators = mutableListOf<AnimationDrawable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animation)

        val frame1View = findViewById<View>(R.id.frame1)

        animators.add(
            // 通过这种方法，可以获取通过资源方式配置的动画文件对象
            frame1View.background as AnimationDrawable
        )

        initFrameAnimation()
    }

    /**
     * 逐帧动画使用的所有素材
     * */
    private val animationImageIds = listOf(
        R.drawable.a01,
        R.drawable.a02,
        R.drawable.a03,
        R.drawable.a04,
        R.drawable.a05,
        R.drawable.a06,
        R.drawable.a07,
        R.drawable.a08,
        R.drawable.a09,
        R.drawable.a10,
        R.drawable.a11,
        R.drawable.a12,
        R.drawable.a13,
        R.drawable.a14,
        R.drawable.a15,
        R.drawable.a16,
    )

    /**
     * 用代码构建AnimationDrawable，来实现逐帧动画
     * */
    private fun initFrameAnimation() {
        // 构建AnimationDrawable对象
        val animationDrawable = AnimationDrawable()
        animationImageIds.mapNotNull {
            // 将资源id转为Drawable对象
            ResourcesCompat.getDrawable(application.resources, it, null)
        }.forEach {
            // 通过调用addFrame方法，将每一帧的Drawable设置到animationDrawable对象中，第二个参数是该帧的持续时长
            animationDrawable.addFrame(it, 120)
        }

        // 设置是否循环播放
        animationDrawable.isOneShot = false

        animators.add(animationDrawable)

        // 将AnimationDrawable对象设置为View的背景
        findViewById<View>(R.id.code).background = animationDrawable
    }

    /**
     * 启动动画
     * */
    fun start(view: View) {
        animators.forEach {
            it.start()  // 执行AnimationDrawable对象的start()方法启动动画
        }
    }

    /**
     * 停止动画
     * */
    fun stop(view: View) {
        animators.forEach {
            it.stop()  // 执行AnimationDrawable对象的stop()方法停止动画
        }
    }
}