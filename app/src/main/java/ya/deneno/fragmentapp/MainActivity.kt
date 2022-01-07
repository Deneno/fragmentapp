package ya.deneno.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.constraintlayout.helper.widget.MotionPlaceholder
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import ya.deneno.fragmentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bc: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bc.root)
        openFrag(BlankFragment.newInstance(), R.id.placeholder)
        openFrag(BlankFragment2.newInstance(), R.id.placeholder2)
        dataModel.messageForActivity.observe(this, {
            bc.textView.text = it
        })
    }

    private fun openFrag(fragment: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, fragment)
            .commit()
    }
}