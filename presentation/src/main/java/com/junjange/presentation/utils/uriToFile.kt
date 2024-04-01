package com.junjange.presentation.utils

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import java.io.File

@SuppressLint("Range", "SuspiciousIndentation")
fun uriToFile(
    context: Context,
    uri: Uri,
): File? {
    @SuppressLint("Range")
    val cursor: Cursor? = context.contentResolver.query(uri, null, null, null, null)
    cursor?.moveToNext()
    val path: String? = cursor?.getString(cursor.getColumnIndex("_data"))
    cursor?.close()

    return File(path)
}
