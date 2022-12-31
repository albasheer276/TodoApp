package it.basheer.todoapp.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import it.basheer.todoapp.utils.APP_LANG_KEY
import it.basheer.todoapp.utils.AppSharedPref
import it.basheer.todoapp.utils.ConfigurationChanger

abstract class BaseActivity<V : ViewBinding>(val bindingFactory: (LayoutInflater) -> V) : AppCompatActivity() {

    lateinit var binding: V

    override fun attachBaseContext(newBase: Context?) {
        val lang = AppSharedPref(newBase!!).getStringData(APP_LANG_KEY)
        super.attachBaseContext(ConfigurationChanger.overrideLocale(newBase, lang ?: "en"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    abstract fun initial()
}