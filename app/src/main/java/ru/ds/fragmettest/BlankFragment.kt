package ru.ds.fragmettest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import ru.ds.fragmettest.databinding.Fragment1Binding



class BlankFragment : Fragment() {

//для инициализации LiveData в фрагменете пишем по аналогии с Main Activity (создаем саму LiveData это и есть dataModel
    private val dataModel: DataModel by activityViewModels()
    lateinit var bind: Fragment1Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = Fragment1Binding.inflate(inflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        dataModel.messageForFrag1.observe(activity as LifecycleOwner){
            bind.tvMessageFrag1.text = it
        }

        bind.bSendToFrag2.setOnClickListener {
            dataModel.messageForFrag2.value = "Hello from Frg 1"
        }
        bind.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from Frag 1"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment()

    }
}