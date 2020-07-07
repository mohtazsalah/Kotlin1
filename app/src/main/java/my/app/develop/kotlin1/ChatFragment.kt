package my.app.develop.kotlin1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class ChatFragment : Fragment() {

    internal var view: View? = null
//    internal var list: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (view == null) {
            view = inflater.inflate(R.layout.chat_fragment, container, false)

        }
        return view
    }
}
