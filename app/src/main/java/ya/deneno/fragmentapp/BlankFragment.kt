package ya.deneno.fragmentapp

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import ya.deneno.fragmentapp.databinding.FragmentBlank2Binding
import ya.deneno.fragmentapp.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    lateinit var bcFragment: FragmentBlankBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bcFragment = FragmentBlankBinding.inflate(inflater)
        return bcFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment1.observe(activity as LifecycleOwner) {
            bcFragment.etFrag1.setText(it)
        }
        bcFragment.bSend1ToFrag2.setOnClickListener{
            dataModel.messageForFragment2.value = bcFragment.etFrag1.text.toString()
        }
        bcFragment.bSend1ToActivity.setOnClickListener{
            dataModel.messageForActivity.value = bcFragment.etFrag1.text.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =BlankFragment()
    }
}