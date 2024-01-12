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

    private const val ENG = "eng.traineddata"
    private const val KOR = "kor.traineddata"
    private const val KOR_VERT = "kor_vert.traineddata"
    private const val ARA = "ara.traineddata"


    @Provides
    @Singleton
    fun provideTess(@ApplicationContext context: Context): TessBaseAPI {
        val tess = TessBaseAPI()

        val dataPath = File(context.filesDir, "tesseract")
        val subdir = File(dataPath, "tessdata")

        checkDir(dataPath, subdir)
        checkTrainedData(context, subdir, ARA)

        tess.init(dataPath.absolutePath, "ara")
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
