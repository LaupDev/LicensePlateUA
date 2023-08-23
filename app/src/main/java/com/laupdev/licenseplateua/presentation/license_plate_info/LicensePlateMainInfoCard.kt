package com.laupdev.licenseplateua.presentation.license_plate_info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.laupdev.licenseplateua.R
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.presentation.ui.theme.BlackMetal

@Composable
fun LicensePlateMainInfoCard(
    item: LicensePlateInfo,
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
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = item.carPhotoUrl,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.7f)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(16.dp)),
                placeholder = painterResource(R.drawable.no_image_placeholder),
                contentDescription = item.carVendor + "" + item.carModel,
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = item.plateNumber,
                fontFamily = FontFamily.SansSerif,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
            HorizontalDivider(
                modifier = Modifier.padding(top = 6.dp, bottom = 10.dp),
                thickness = 2.dp,
                color = BlackMetal
            )
            LicensePlateMainInfoItem(
                title = stringResource(id = R.string.vendor),
                value = item.carVendor,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 12.dp, end = 12.dp, bottom = 10.dp),
            )
            LicensePlateMainInfoItem(
                title = stringResource(id = R.string.model),
                value = item.carModel,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 12.dp, end = 12.dp, bottom = 10.dp),
            )
            LicensePlateMainInfoItem(
                title = stringResource(id = R.string.year),
                value = item.carModelYear?.toString() ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 12.dp, end = 12.dp, bottom = 10.dp)
            )
        }
    }
}

@Composable
fun LicensePlateMainInfoItem(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = title,
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Text(
            text = value,
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }
}

@Preview
@Composable
fun LicensePlateMainInfoCardPreview() {
    LicensePlateMainInfoCard(
        item = LicensePlateInfo(
            plateNumber = "XX0000XX",
            vin = "1231231312",
            carVendor = "Mercedes",
            carModel = "SLS",
            carModelYear = 2022,
            carPhotoUrl = "https://baza-gai.com.ua/catalog-images/mercedes-benz/sls-amg/2010%20%E2%80%93%202014/image.jpg",
            operations = null,
            region = null,
            isCarStolen = false,
            comments = null
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}