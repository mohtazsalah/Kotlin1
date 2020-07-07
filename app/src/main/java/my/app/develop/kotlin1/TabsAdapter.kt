package my.app.develop.kotlin1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabsAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    var chatFragment : Fragment = ChatFragment()
    var contactFragment : Fragment = ContactFragment()

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return chatFragment
            1 -> return contactFragment
        }
        return null!!
    }

    override fun getCount(): Int {
        return 2
    }
}
