package ru.startandroid.testing.utils

import android.content.Context
import ru.startandroid.testing.R
import java.net.URI

class UriValidator(val context: Context) {
    fun validate(uri: String): String {
        var resId = R.string.nothing
        if (isUrl(uri)) {
            resId = R.string.url
        } else if (isFile(uri)){
            resId = R.string.file
        }
        return context.getString(resId)
    }

    private fun isUrl(uri: String): Boolean = "http" == URI.create(uri).scheme

    private fun isFile(uri: String): Boolean = "file" == URI.create(uri).scheme
}