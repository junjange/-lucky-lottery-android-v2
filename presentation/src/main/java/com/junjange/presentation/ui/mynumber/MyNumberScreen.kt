package com.junjange.presentation.ui.mynumber

import android.graphics.Color
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.canhub.cropper.CropImageView
import com.junjange.domain.model.PensionLotteryNumbers
import com.junjange.presentation.R
import com.junjange.presentation.component.Lotto645Content
import com.junjange.presentation.component.Lotto720Content
import com.junjange.presentation.component.LottoContentTitle
import com.junjange.presentation.component.LottoType
import com.junjange.presentation.ui.mynumber.MyNumberEffect.NavigateToGallery
import com.junjange.presentation.ui.theme.LottoTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyNumberScreen(viewModel: MyNumberViewModel = hiltViewModel()) {

    val context = LocalContext.current

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val imageCropLauncher = rememberLauncherForActivityResult(CropImageContract()) { result ->
        if (result.isSuccessful) {
            result.uriContent?.let {
                viewModel.getTextOfImage(result.getUriFilePath(context, false)!!)
            }
        }
    }

    val imageCropperOptions = CropImageOptions(
        cropShape = CropImageView.CropShape.RECTANGLE,
        fixAspectRatio = false,
        aspectRatioX = 1,
        aspectRatioY = 1,
        toolbarColor = Color.WHITE,
        toolbarBackButtonColor = Color.BLACK,
        toolbarTintColor = Color.BLACK,
        allowFlipping = false,
        allowRotation = false,
        cropMenuCropButtonTitle = context.getString(R.string.done),
        imageSourceIncludeCamera = false
    )

    val imagePickerLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
            val cropOptions = CropImageContractOptions(uri, imageCropperOptions)
            imageCropLauncher.launch(cropOptions)
        }

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is NavigateToGallery -> imagePickerLauncher.launch("image/*")
            }
        }
    }

    val tabs = listOf(R.string.lotto_645_title, R.string.lotto_720_title)
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(stringResource(id = title)) },
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.scrollToPage(index) } }
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> MyLotteryContent(
                    lottoType = LottoType.LOTTO645,
                    uiState = uiState,
                    viewModel = viewModel
                )

                1 -> MyPensionLotteryContent(
                    uiState = uiState,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun MyPensionLotteryContent(
    uiState: MyNumberState,
    viewModel: MyNumberViewModel
) {
    val pensionLotteryGetContent = uiState.pensionLotteryGetContent.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(pensionLotteryGetContent.itemCount) {
                Spacer(modifier = Modifier.height(20.dp))
                Card(
                    modifier = Modifier.padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = LottoTheme.colors.gray200),
                    shape = RoundedCornerShape(size = 8.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        pensionLotteryGetContent[it]?.let { pensionLotteryGetContent ->
                            LottoContentTitle(
                                title = stringResource(R.string.lotto_720_title),
                                round = pensionLotteryGetContent.round,
                                winningDate = pensionLotteryGetContent.winningDate
                            )
                            pensionLotteryGetContent.winningLotteryNumbers?.let { winningLotteryNumbers ->
                                pensionLotteryGetContent.winningPensionLotteryBonusNumbers?.let { winningPensionLotteryBonusNumbers ->
                                    Lotto720Content(
                                        winningLotteryNumbers = winningLotteryNumbers,
                                        winningPensionLotteryBonusNumbers = winningPensionLotteryBonusNumbers
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                            MyPensionLotteryNumber(
                                pensionLotteryNumbers = pensionLotteryGetContent.pensionLotteryNumbers,
                                checkWinningBonus = pensionLotteryGetContent.checkWinningBonus
                            )
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 15.dp, end = 15.dp),
            containerColor = LottoTheme.colors.lottoGreen,
            onClick = { viewModel.onPickedImage() },
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
                tint = LottoTheme.colors.white
            )
        }
    }
}

@Composable
fun MyLotteryContent(
    lottoType: LottoType,
    uiState: MyNumberState,
    viewModel: MyNumberViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(uiState.tempList) {

                val title = if (lottoType == LottoType.LOTTO645) {
                    stringResource(R.string.lotto_645_title)
                } else {
                    stringResource(R.string.lotto_720_title)
                }

                Spacer(modifier = Modifier.height(20.dp))
                Card(
                    modifier = Modifier.padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = LottoTheme.colors.gray200),
                    shape = RoundedCornerShape(size = 8.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LottoContentTitle(title = title, 1, "2024-02-12")
                        if (lottoType == LottoType.LOTTO645) Lotto645Content()
                        else Lotto720Content()
                        Spacer(modifier = Modifier.height(8.dp))
                        MyNumberContentItem(lottoType = lottoType, tempList = it)
                    }
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 15.dp, end = 15.dp),
            containerColor = LottoTheme.colors.lottoGreen,
            onClick = { viewModel.onPickedImage() },
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
                tint = LottoTheme.colors.white
            )
        }
    }
}

@Composable
fun MyNumberContentItem(lottoType: LottoType, tempList: List<List<String>>) {
    tempList.forEach { tempListItem ->
        Row(Modifier.fillMaxWidth()) {
            TableCell(rank = "미발표", weight = 2f)
//            TableCell(lottoType = lottoType, lottoNumber = tempListItem, weight = 8f)
        }
    }
}

@Composable
fun MyPensionLotteryNumber(
    pensionLotteryNumbers: List<PensionLotteryNumbers>,
    checkWinningBonus: Boolean
) {
    pensionLotteryNumbers.forEach { pensionLotteryNumber ->
        Row(Modifier.fillMaxWidth()) {
            TableCell(
                rank = pensionLotteryNumber.rank,
                weight = 2f
            )
            TableCell(
                lottoNumbers = pensionLotteryNumber,
                checkWinningBonus = checkWinningBonus,
                weight = 8f
            )
        }
    }
}

@Composable
fun RowScope.TableCell(rank: String?, weight: Float) {
    val title = when (rank) {
        "FIRST" -> "1등"
        "SECOND" -> "2등"
        "THIRD" -> "3등"
        "FOUR" -> "4등"
        "FIVE" -> "5등"
        "SIX" -> "6등"
        "SEVEN" -> "7등"
        else -> "미발표"
    }

    Text(
        modifier = Modifier
            .border(width = 1.dp, color = LottoTheme.colors.gray400)
            .fillMaxHeight()
            .weight(weight)
            .padding(8.8.dp),
        text = title,
        style = LottoTheme.typography.body3,
        textAlign = TextAlign.Center
    )
}

@Composable
fun RowScope.TableCell(
    lottoNumbers: PensionLotteryNumbers,
    checkWinningBonus: Boolean,
    weight: Float
) {
    Row(
        modifier = Modifier
            .border(width = 1.dp, color = LottoTheme.colors.gray400)
            .weight(weight)
            .padding(4.5.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        val lottoTitle = listOf(
            lottoNumbers.pensionGroup,
            lottoNumbers.pensionFirstNum,
            lottoNumbers.pensionSecondNum,
            lottoNumbers.pensionThirdNum,
            lottoNumbers.pensionFourthNum,
            lottoNumbers.pensionFifthNum,
            lottoNumbers.pensionSixthNum
        ).map { it.toString() }

        lottoTitle.forEachIndexed { index, title ->
            if (index == 1) {
                Surface(
                    modifier = Modifier.size(30.dp),
                    color = LottoTheme.colors.gray200,
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = stringResource(id = R.string.group_title),
                            textAlign = TextAlign.Center,
                            style = LottoTheme.typography.body3.copy(fontWeight = FontWeight.Bold),
                        )
                    }
                }
            }

            if (checkWinningBonus) {
                MyLottoBall(
                    isSuccess = true,
                    lottoTitle = title,
                )
            } else {
                MyLottoBall(
                    isSuccess = if (lottoNumbers.correctNumbers == null) false else lottoNumbers.correctNumbers!![index],
                    lottoTitle = title,
                    index = index
                )
            }
        }
    }
}

@Composable
fun MyLottoBall(isSuccess: Boolean, lottoType: LottoType, lottoTitle: String) {
    val borderColor = if (isSuccess && lottoType == LottoType.LOTTO720) BorderStroke(
        width = 4.dp,
        color = LottoTheme.colors.lottoGreen
    ) else null
    val backgroundColor = if (isSuccess) {
        if (lottoType == LottoType.LOTTO720) LottoTheme.colors.white else LottoTheme.colors.lottoGreen
    } else {
        LottoTheme.colors.gray200
    }
    val textColor = if (isSuccess) {
        if (lottoType == LottoType.LOTTO720) LottoTheme.colors.black else LottoTheme.colors.white
    } else {
        LottoTheme.colors.black
    }

    Surface(
        modifier = Modifier.size(30.dp),
        border = borderColor,
        shape = CircleShape,
        color = backgroundColor,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = lottoTitle,
                textAlign = TextAlign.Center,
                style = LottoTheme.typography.body3.copy(
                    fontWeight = FontWeight.Bold,
                    color = textColor
                ),
            )
        }
    }
}


@Composable
fun MyLottoBall(
    isSuccess: Boolean,
    lottoTitle: String,
    index: Int? = null
) {

    val lotteryColors = listOf(
        LottoTheme.colors.gray600,
        LottoTheme.colors.lottoError,
        LottoTheme.colors.lottoOrange,
        LottoTheme.colors.lottoYellow,
        LottoTheme.colors.lottoBlue,
        LottoTheme.colors.lottoPurple,
        LottoTheme.colors.lottoBlack,
    )

    val borderColor = if (isSuccess) BorderStroke(
        width = 4.dp,
        color = if (index == null) LottoTheme.colors.gray200 else lotteryColors[index]
    ) else null
    val backgroundColor = if (isSuccess) LottoTheme.colors.white else LottoTheme.colors.gray200
    val textColor = if (isSuccess) LottoTheme.colors.black else LottoTheme.colors.black

    Surface(
        modifier = Modifier.size(30.dp),
        border = borderColor,
        shape = CircleShape,
        color = backgroundColor,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = lottoTitle,
                textAlign = TextAlign.Center,
                style = LottoTheme.typography.body3.copy(
                    fontWeight = FontWeight.Bold,
                    color = textColor
                ),
            )
        }
    }

    if (index != 0 && isSuccess) Spacer(modifier = Modifier.width(4.dp))
}