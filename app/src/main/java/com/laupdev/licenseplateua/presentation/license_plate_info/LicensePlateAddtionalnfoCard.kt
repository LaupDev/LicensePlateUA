package com.laupdev.licenseplateua.presentation.license_plate_info

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laupdev.licenseplateua.R
import com.laupdev.licenseplateua.domain.model.Color
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.model.Operation
import com.laupdev.licenseplateua.domain.model.OperationGroup
import com.laupdev.licenseplateua.domain.model.OperationNote
import com.laupdev.licenseplateua.domain.model.Region
import com.laupdev.licenseplateua.domain.model.Type

@Composable
fun LicensePlateAdditionalInfoCard(
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
            item.region?.nameUa?.let {
                LicensePlateAdditionalInfoItem(
                    title = R.string.region,
                    value = it,
                    icon = R.drawable.ic_globe,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 12.dp)
                )
            }
            Text(
                text = stringResource(id = R.string.last_record),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif
            )
            item.operations?.find { it.isLast == true }?.let { lastOperation ->
                LicensePlateAdditionalInfoItem(
                    title = R.string.date_of_registration,
                    value = lastOperation.registeredAt,
                    icon = R.drawable.ic_calendar,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 12.dp, end = 16.dp)
                )
                LicensePlateAdditionalInfoItem(
                    title = R.string.address,
                    value = lastOperation.address,
                    icon = R.drawable.ic_address_pin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                )
                LicensePlateAdditionalInfoItem(
                    title = R.string.made_in_department,
                    value = lastOperation.department,
                    icon = R.drawable.ic_building,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                )
                lastOperation.operationNote?.noteUa?.let {note ->
                    LicensePlateAdditionalInfoItem(
                        title = R.string.record,
                        value = note,
                        icon = R.drawable.ic_record,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun LicensePlateAdditionalInfoItem(
    @StringRes title: Int,
    value: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(36.dp)
        )
        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(
                text = stringResource(id = title),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = value,
                modifier = Modifier.padding(top = 1.dp),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Preview
@Composable
fun LicensePlateAdditionalInfoCardPreview() {
    val operation = Operation(
        address = "Мукачево",
        carColor = Color(
            nameUa = "Червоний",
            nameRu = "Красный",
            nameSlug = "Red"
        ),
        department = "2111 ДУУС",
        isLast = true,
        isRegisteredToCompany = false,
        type = Type(
            nameUa = "Легковий",
            nameRu = "Легковой",
            slug = "car"
        ),
        koatuu = 8036400000,
        carModel = "M760LI",
        carModelYear = 2016,
        carVendor = "BMW",
        carVendorSlug = "bmw",
        operationNote = OperationNote(
            noteUa = "Первинна реєстрація нового тз придбаного в торгівельній організації, який ввезено з-за кордону",
            noteRu = "Первичная регистрация нового ТС, автосалон, ввезено из-за границы"
        ),
        operationGroup = OperationGroup(
            nameUa = "Первинна реєстрація",
            nameRu = "Первичная регистрация"
        ),
        registeredAt = "03.04.2021"
    )
    LicensePlateAdditionalInfoCard(
        item = LicensePlateInfo(
            plateNumber = "XX0000XX",
            vin = "1231231312",
            carVendor = "Mercedes",
            carModel = "SLS",
            carModelYear = 2022,
            carPhotoUrl = "https://baza-gai.com.ua/catalog-images/mercedes-benz/sls-amg/2010%20%E2%80%93%202014/image.jpg",
            operations = listOf(operation),
            region = Region(
                nameUa = "м. Київ",
                nameRu = "г. Киев",
                slug = "kyiv",
                oldCode = "AA",
                newCode = "KA"
            ),
            isCarStolen = false,
            comments = null
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}