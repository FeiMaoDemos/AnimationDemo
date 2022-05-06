package ink.liangxin.animatordemo

import android.os.Bundle
import android.view.View
import android.view.animation.*
import android.view.animation.AnimationSet
import androidx.appcompat.app.AppCompatActivity


/**
 * 所有动画的默认时长
 * */
private const val DEFAULT_DURATION = 1000L

/**
 * 演示Android提供的默认补间动画效果
 * */
class NormalTweenAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_tween_animation)
    }

    fun alphaXmlDemo(view: View) {
        val alphaXmlAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha)
        alphaXmlAnimation.duration = DEFAULT_DURATION
        view.startAnimation(alphaXmlAnimation)
    }

    fun alphaCodeDemo(view: View) {
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)
        alphaAnimation.duration = DEFAULT_DURATION
        view.startAnimation(alphaAnimation)
    }

    fun scaleXmlDemo(view: View) {
        val scaleXmlAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)
        scaleXmlAnimation.duration = DEFAULT_DURATION
        view.startAnimation(scaleXmlAnimation)
    }

    fun scaleCodeDemo(view: View) {
        val scaleAnimation = ScaleAnimation(
            1.5f, 0.2f,
            1.5f, 0.2f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        scaleAnimation.duration = DEFAULT_DURATION
        view.startAnimation(scaleAnimation)
    }

    fun translateXmlDemo(view: View) {
        val translateXmlAnimation = AnimationUtils.loadAnimation(this, R.anim.translate)
        translateXmlAnimation.duration = DEFAULT_DURATION
        view.startAnimation(translateXmlAnimation)
    }

    fun translateCodeDemo(view: View) {
        val translateAnimation = TranslateAnimation(
            AnimationSet.ABSOLUTE,
            0f,
            AnimationSet.ABSOLUTE,
            -500f,
            AnimationSet.ABSOLUTE,
            0f,
            AnimationSet.ABSOLUTE,
            0f
        )
        translateAnimation.duration = DEFAULT_DURATION
        view.startAnimation(translateAnimation)
    }

    fun rotateXmlDemo(view: View) {
        val rotateXmlAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        rotateXmlAnimation.duration = DEFAULT_DURATION
        view.startAnimation(rotateXmlAnimation)
    }

    fun rotateCodeDemo(view: View) {
        val rotateAnimation = RotateAnimation(
            0f, -360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.duration = DEFAULT_DURATION
        view.startAnimation(rotateAnimation)
    }

    fun setXmlDemo(view: View) {
        val setXmlAnimation = AnimationUtils.loadAnimation(this, R.anim.set)
        setXmlAnimation.duration = DEFAULT_DURATION
        view.startAnimation(setXmlAnimation)
    }

    fun setCodeDemo(view: View) {
        // AnimationSet 的构造方法中的参数，表示所有子动画是否共享差值器
        val animationSet = AnimationSet(true)

        // 定义两个子动画
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)
        alphaAnimation.duration = DEFAULT_DURATION

        val translateAnimation = TranslateAnimation(
            AnimationSet.ABSOLUTE,
            0f,
            AnimationSet.ABSOLUTE,
            -100f,
            AnimationSet.ABSOLUTE,
            0f,
            AnimationSet.ABSOLUTE,
            0f
        )
        // 设置动画持续时间，单位毫秒
        translateAnimation.duration = DEFAULT_DURATION
        translateAnimation.fillBefore = true
        // 设置动画延迟时间，用来控制动画依次执行（延迟1000毫秒等待上一个动画执行完毕）
        translateAnimation.startOffset = DEFAULT_DURATION

        // 将动画添加到集合中
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(translateAnimation)

        // 将动画持续时间设置为所有动画的最大值。
        animationSet.computeDurationHint()

        // 以下设置是所有动画通用的
        animationSet.fillBefore = false // 动画结束时停留在第一帧
        animationSet.fillAfter = false // 动画结束时停留在最后一帧
        animationSet.repeatMode = Animation.REVERSE // 设置重复播放时，是重新播放还是循环播放
        animationSet.repeatCount = 10 // 设置重复次数

        animationSet.startTime = System.currentTimeMillis() + 1000 // 设置开始时间

        view.startAnimation(animationSet)
    }
}