@file:Suppress("LocalVariableName", "PackageName")

package com.dev_app.buyforme


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.room.Room
import com.dev_app.buyforme.database.AppDb
import com.dev_app.buyforme.models.Utils
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.payment_custom_layout.*

class SettingsFragment : Fragment() {

    private lateinit var rootView: View
    private lateinit var appDb: AppDb
    private var utils: Utils = Utils()
    lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_settings, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {
        appDb = Room
            .databaseBuilder(rootView.context, AppDb::class.java, "User")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        item1.setOnClickListener {
            startActivity(Intent(activity, EditProfileActivity::class.java))

        }

        val user_name = utils.getUser(appDb).fname + " " + utils.getUser(appDb).lname
        name.text = user_name

        item2.setOnClickListener {
            Toast.makeText(rootView.context, "Coming Soon!!", Toast.LENGTH_LONG).show()
        }

        item3.setOnClickListener {
            val intent = Intent(rootView.context, EditProfileActivity::class.java)
            intent.putExtra("flag", "logout")
            rootView.context.startActivity(intent)
        }
    }
}