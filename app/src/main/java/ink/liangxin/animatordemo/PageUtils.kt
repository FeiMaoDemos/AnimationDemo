package ink.liangxin.animatordemo

import android.app.Activity
import android.content.Intent

/**
 * 用来定义页面跳转的工具方法
 */
class PageUtils {
    companion object {

        /**
         * 根据给定Activity类型来启动Activity
         * */
        public fun Activity.gotoActivity(activityClass: Class<*>) {
            startActivity(Intent(this, activityClass))
        }
    }
}