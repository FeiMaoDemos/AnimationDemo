package ink.liangxin.animatordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.TextView

/** 第一个动画的持续时间 */
private const val DURATION_1 = 1000L

/** 第二个动画的持续时间 */
private const val DURATION_2 = 3000L

/** 其他动画持续时长 */
private const val DURATION_OTHER = 1000L

/**
 * 演示帧动画的基本属性作用
 * */
class BaseFrameAnimationActivity : AppCompatActivity() {

    /**
     * duration属性对比任务
     * */
    private val durationTasks = mutableListOf<Runnable>()

    /**
     * fill属性对比任务
     * */
    private val fillTasks = mutableListOf<Runnable>()

    /**
     * 重复动画任务
     * */
    private val repeatTask = mutableListOf<Runnable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_frame_animation)

        initDurationAnimation()
        initFillAnimation()
        initRepeatAnimation()
    }

    /**
     * 初始化位移动画示例
     * duration越小，动画执行越快
     * */
    private fun initDurationAnimation() {
        // 初始化View1
        val view1 = findViewById<View>(R.id.duration1)
        val tv1 = findViewById<TextView>(R.id.duration1_title)
        val translateAnimation1 = TranslateAnimation(0f, 500f, 0f, 0f)
        translateAnimation1.duration = DURATION_1
        tv1.text = "duration: $DURATION_1"
        durationTasks.add {
            view1.startAnimation(translateAnimation1)
        }

        // 初始化View2
        val view2 = findViewById<View>(R.id.duration2)
        val tv2 = findViewById<TextView>(R.id.duration2_title)
        val translateAnimation2 = TranslateAnimation(0f, 500f, 0f, 0f)
        translateAnimation2.duration = DURATION_2
        tv2.text = "duration: $DURATION_2"
        durationTasks.add {
            view2.startAnimation(translateAnimation2)
        }
    }

    /**
     * 初始化填充模式动画示例
     * */
    private fun initFillAnimation() {

        val view1 = findViewById<View>(R.id.no_fill)
        val translateAnimation1 = TranslateAnimation(200f, 500f, 0f, 0f)
        translateAnimation1.isFillEnabled = true
        translateAnimation1.fillBefore = false
        translateAnimation1.fillAfter = false
        translateAnimation1.duration = DURATION_OTHER
        fillTasks.add {
            view1.startAnimation(translateAnimation1)
        }

        val view2 = findViewById<View>(R.id.fillAfter)
        val translateAnimation2 = TranslateAnimation(200f, 500f, 0f, 0f)
        translateAnimation2.isFillEnabled = true
        translateAnimation2.fillBefore = false
        translateAnimation2.fillAfter = true
        translateAnimation2.duration = DURATION_OTHER
        fillTasks.add {
            view2.startAnimation(translateAnimation2)
        }

        val view3 = findViewById<View>(R.id.fillBefore)
        val translateAnimation3 = TranslateAnimation(200f, 500f, 0f, 0f)
        translateAnimation2.isFillEnabled = true
        translateAnimation3.fillBefore = true
        translateAnimation3.fillAfter = false
        translateAnimation3.duration = DURATION_OTHER
        fillTasks.add {
            view3.startAnimation(translateAnimation3)
        }

    }

    /**
     * 初始化重复模式相关属性的动画
     * repeatCount 表示重复次数
     * repeatMode 表示重复模式
     * */
    private fun initRepeatAnimation() {
        val view1 = findViewById<View>(R.id.no_repeat)
        val translateAnimation1 = TranslateAnimation(200f, 500f, 0f, 0f)
        translateAnimation1.duration = DURATION_OTHER
        // 只播放1次（重复播放次数为0）
        translateAnimation1.repeatCount = 0
        repeatTask.add {
            view1.startAnimation(translateAnimation1)
        }

        val view2 = findViewById<View>(R.id.repeat_5)
        val translateAnimation2 = TranslateAnimation(200f, 500f, 0f, 0f)
        translateAnimation2.duration = DURATION_OTHER
        // 重复播放5次后停止（重复播放次数为4）
        translateAnimation2.repeatCount = 4
        repeatTask.add {
            view2.startAnimation(translateAnimation2)
        }

        val view3 = findViewById<View>(R.id.normal_repeat)
        val translateAnimation3 = TranslateAnimation(200f, 500f, 0f, 0f)
        translateAnimation3.duration = DURATION_OTHER
        // 无限循环播放
        translateAnimation3.repeatCount = Animation.INFINITE
        // 每次动画都从头开始播放
        translateAnimation3.repeatMode = Animation.RESTART
        repeatTask.add {
            view3.startAnimation(translateAnimation3)
        }

        val view4 = findViewById<View>(R.id.revert_repeat)
        val translateAnimation4 = TranslateAnimation(200f, 500f, 0f, 0f)
        translateAnimation4.duration = DURATION_OTHER
        translateAnimation4.repeatCount = Animation.INFINITE
        // 单数次动画从头播放，双数次动画从上次动画的结尾处倒着播放
        translateAnimation4.repeatMode = Animation.REVERSE
        repeatTask.add {
            view4.startAnimation(translateAnimation4)
        }
    }

    /**
     * 启动duration动画对比
     * */
    fun startDurationAnimation(view: View) {
        durationTasks.forEach(Runnable::run)
    }

    fun startFillAnimation(view: View) {
        fillTasks.forEach(Runnable::run)
    }

    fun startRepeatAnimation(view: View) {
        repeatTask.forEach(Runnable::run)
    }
}