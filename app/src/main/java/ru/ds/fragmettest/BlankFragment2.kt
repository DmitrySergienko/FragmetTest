package ru.ds.fragmettest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import ru.ds.fragmettest.databinding.Fragment2Binding


class BlankFragment2 : Fragment() {
    lateinit var bind: Fragment2Binding
    val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = Fragment2Binding.inflate(inflater)
        return bind.root
    }

    //для отслеживания изменения в фрагменет создаем Observer, где Owner это активити на котором отображаются изменеия
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag2.observe(activity as LifecycleOwner,{
            bind.tvMessageFrag2.text = it
        })

        bind.bSendToFrag1.setOnClickListener {
            dataModel.messageForFrag1.value = "Hello Frag 1 from Frag2"
        }

        bind.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello Activity form Frag2"
        }


    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}