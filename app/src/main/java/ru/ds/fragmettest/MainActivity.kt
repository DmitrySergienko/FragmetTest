package ru.ds.fragmettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import ru.ds.fragmettest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var bind: ActivityMainBinding
    //создаем инстанцию viewModel, чтобы можно было пользоваться этим класом в Main Activity
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        openFrag(BlankFragment.newInstance(),R.id.place_holder)
        openFrag(BlankFragment2.newInstance(),R.id.place_holder2)

        //для отслеживания изменения в фрагменет создаем Observer, где Owner это активити на котором отображаются изменеия
        dataModel.messageForActivity.observe(this,{
            bind.tvViewMainActivity.text = it
        })
        dataModel.messageForActivity.observe(this,{
            bind.tvViewMainActivity.text = it
        })

    }

    private fun openFrag(f: Fragment,idHolder: Int){
        supportFragmentManager
                .beginTransaction()
                .replace(idHolder,f)
                .commit()
    }
}