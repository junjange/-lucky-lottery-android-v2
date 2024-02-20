package com.junjange.core_feature.di

import android.content.Context
import com.googlecode.tesseract.android.TessBaseAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object OcrModule {

    private const val DIGITS = "digits.traineddata"
    private const val DIGITS1 = "digits1.traineddata"
    private const val DIGITS_COMMA = "digits_comma.traineddata"
    private const val DIGITS_LAYER = "digits_layer.traineddata"

    @Provides
    @Singleton
    fun provideTess(@ApplicationContext context: Context): TessBaseAPI {
        val tess = TessBaseAPI()

        val dataPath = File(context.filesDir, "tesseract")
        val subdir = File(dataPath, "tessdata")

        checkDir(dataPath, subdir)
        checkTrainedData(context, subdir, DIGITS, DIGITS1, DIGITS_COMMA, DIGITS_LAYER)

        tess.init(dataPath.absolutePath, "digits+digits1+digits_comma+digits_layer")
        //TODO: tess.setVariable(TessBaseAPI.VAR_CHAR_WHITELIST, "");
        tess.setVariable(TessBaseAPI.VAR_CHAR_BLACKLIST, "!@#$%^&*()_+=-[]}{;:'\"\\|~`,./<>?");
        return tess
    }

    private fun checkDir(vararg dirs: File) {
        for (dir in dirs) with(dir) { if (!exists()) mkdir() }
    }

    private fun checkTrainedData(context: Context, dir: File, vararg languages: String) {
        for (language in languages) {
            with(File(dir, language)) {
                if (!exists()) copyFrom(context.assets.open(language))
            }
        }
    }

    private fun File.copyFrom(inputStream: InputStream) {
        val outputStream: OutputStream = FileOutputStream(this)

        val buffer = ByteArray(1024)
        while (true) {
            val byteCount = inputStream.read(buffer)
            if (byteCount < 0) break
            outputStream.write(buffer, 0, byteCount)
        }

        outputStream.flush()
        outputStream.close()

        inputStream.close()
    }
}
