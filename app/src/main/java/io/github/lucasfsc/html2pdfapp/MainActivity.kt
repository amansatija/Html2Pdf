package io.github.lucasfsc.html2pdfapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.github.lucasfsc.html2pdf.Html2Pdf
import io.github.lucasfsc.html2pdfapp.R
import java.io.File
import java.net.URI

class MainActivity : AppCompatActivity(), Html2Pdf.OnCompleteConversion {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Tag",""+externalCacheDir+File.separator+"temp.pdf")
        try {//Impl example
            val converter = Html2Pdf.Companion.Builder()
                .context(this)
                .html("<p> Your awesome HTML string here! </p>")
                .file(File(""+externalCacheDir+File.separator+"temp.pdf"))
                .build()

            //can be called with a callback to warn the user
            converter.convertToPdf(this)

            //or without a callback
            converter.convertToPdf()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onSuccess() {
        //do your thing
    }

    override fun onFailed(error: Exception?) {
        //do your thing
        error?.printStackTrace()
    }

}
