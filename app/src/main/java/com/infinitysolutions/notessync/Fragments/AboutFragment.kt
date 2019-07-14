package com.infinitysolutions.notessync.Fragments


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_about.view.*
import kotlinx.android.synthetic.main.fragment_settings.view.toolbar


class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(com.infinitysolutions.notessync.R.layout.fragment_about, container, false)
        setupView(rootView)
        return rootView
    }

    private fun setupView(rootView: View){
        val toolbar = rootView.toolbar
        toolbar.title = "About"
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        rootView.rate_button.setOnClickListener {
            openLink("")
        }

        rootView.report_bugs_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val to = arrayOf("infinitysolutionsv1.1@gmail.com")
            intent.type = "vnd.android.cursor.dir/email"
            intent.putExtra(Intent.EXTRA_EMAIL, to)
            intent.putExtra(Intent.EXTRA_SUBJECT, "[Notes Sync][v1.0]")
            intent.putExtra(Intent.EXTRA_TEXT, "Your problems, suggestions, requests...")
            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        rootView.translate_button.setOnClickListener {
            openLink("")
        }

        rootView.more_apps_button.setOnClickListener {
            openLink("")
        }

        rootView.changelog_button.setOnClickListener {

        }
    }

    private fun openLink(link: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        if (browserIntent.resolveActivity(activity!!.packageManager) != null)
            startActivity(browserIntent)
        else
            Toast.makeText(activity, "Incorrect link", Toast.LENGTH_SHORT).show()
    }
}
