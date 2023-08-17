package com.laupdev.licenseplateua.presentation.search_history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.laupdev.licenseplateua.R
import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo

@Composable
fun LicensePlatesSearchHistoryItem(
    item: LicensePlateMainInfo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .weight(1.5f)) {
                AsyncImage(
                    model = item.carPhotoUrl,
                    placeholder = painterResource(R.drawable.no_image_placeholder),
                    contentDescription = item.carVendor + "" + item.carModel,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {
                    //Todo: Apply text styles
                    Text(
                        text = item.carVendor,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = item.carModel,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    item.carModelYear?.let {
                        Text(
                            text = it.toString(),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
                Text(
                    text = item.plateNumber,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Preview
@Composable
fun LicensePlatesSearchHistoryItemPreview() {
    LicensePlatesSearchHistoryItem(
        item = LicensePlateMainInfo(
            plateNumber = "XX0000XX",
            carVendor = "Mercedes",
            carModel = "SLS",
            carModelYear = 2022,
            carPhotoUrl = "https://baza-gai.com.ua/catalog-images/mercedes-benz/sls-amg/2010%20%E2%80%93%202014/image.jpg",
            isCarStolen = false
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    )
}