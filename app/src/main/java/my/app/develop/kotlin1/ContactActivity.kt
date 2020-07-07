package my.app.develop.kotlin1

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_contact.view.*

class ContactActivity : AppCompatActivity() {

    var tabsAdapter : TabsAdapter = TabsAdapter(supportFragmentManager,1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        intUi()

    }

    fun intUi(){
        bottom_nav.add(MeowBottomNavigation.Model(0,R.drawable.icon_chat))
        bottom_nav.add(MeowBottomNavigation.Model(1,R.drawable.nearby))

        viewPager_home.offscreenPageLimit.and(1)
        viewPager_home.adapter = tabsAdapter
        viewPager_home.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
            override fun onPageSelected(i: Int) {
                when (i) {
                    0 -> bottom_nav.show(0, true)
                    1 -> bottom_nav.show(1, true)
//                    2 -> meowBottomNavigation.show(2, true)
//                    3 -> meowBottomNavigation.show(3, true)
                }
            }

            override fun onPageScrollStateChanged(i: Int) {}
        })


        bottom_nav.setOnClickMenuListener(MeowBottomNavigation.ClickListener {
            // your codes
        })

        bottom_nav.setOnShowListener(MeowBottomNavigation.ShowListener { item ->
            when (item.id) {
                0 -> viewPager_home.setCurrentItem(0, true)
                1 -> viewPager_home.setCurrentItem(1, true)
//                2 -> viewPager.setCurrentItem(2, true)
//                3 -> viewPager.setCurrentItem(3, true)
            }
        })

        bottom_nav.setOnReselectListener(MeowBottomNavigation.ReselectListener {
            // your codes
        })

        bottom_nav.show(0, true)

    }

    fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
        val win = activity.window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}

