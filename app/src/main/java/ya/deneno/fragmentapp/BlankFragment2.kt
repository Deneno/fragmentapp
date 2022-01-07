package ya.deneno.fragmentapp

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import ya.deneno.fragmentapp.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
    lateinit var bcFragment2: FragmentBlank2Binding
    private val dataModel: DataModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment2.observe(activity as LifecycleOwner) {
            bcFragment2.etFrag2.setText(it)
        }
        bcFragment2.bSend2ToFrag1.setOnClickListener{
            dataModel.messageForFragment1.value = bcFragment2.etFrag2.text.toString()
        }
        bcFragment2.bSend2ToActivity.setOnClickListener{
            dataModel.messageForActivity.value = bcFragment2.etFrag2.text.toString()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bcFragment2 = FragmentBlank2Binding.inflate(inflater)
        return bcFragment2.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}