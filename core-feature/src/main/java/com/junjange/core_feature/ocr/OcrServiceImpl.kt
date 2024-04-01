package com.junjange.core_feature.ocr

import android.graphics.Bitmap
import com.googlecode.tesseract.android.TessBaseAPI
import com.junjange.presentation.feature.ocr.OcrService
import java.io.File
import javax.inject.Inject

internal class OcrServiceImpl
    @Inject
    constructor(
        private val tess: TessBaseAPI,
    ) : OcrService {
        override fun getTextOfImage(imagePath: File): String =
            with(tess) {
                setImage(imagePath)
                utF8Text
            }

        override fun getTextOfImage(image: Bitmap): String =
            with(tess) {
                setImage(image)
                utF8Text
            }

        override fun close() {
            tess.recycle()
        }
    }
