package my.app.develop.kotlin1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_fragment.*

class ContactFragment : Fragment() {

    internal var view: View? = null
    internal var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (view == null) {
            view = inflater.inflate(R.layout.contact_fragment, container, false)

        }
        return view
    }

    fun intUi(v:View){
        recyclerView = v.findViewById(R.id.recycler_contact)
        var manger : RecyclerView.LayoutManager
        recyclerView.layoutManager
    }

}
