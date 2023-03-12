package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.Operation
import com.squareup.moshi.Json

data class OperationDto(
    @Json(name = "address") val address: String?,
    @Json(name = "color") val carColor: ColorDto?,
    @Json(name = "department") val department: String?,
    @Json(name = "is_last") val isLast: Boolean?,
    @Json(name = "is_registered_to_company") val isRegisteredToCompany: Boolean?,
    @Json(name = "kind") val type: TypeDto?,
    @Json(name = "koatuu") val koatuu: Long?,
    @Json(name = "model") val carModel: String?,
    @Json(name = "model_year") val carModelYear: Int?,
    @Json(name = "operation") val operationNote: OperationNoteDto?,
    @Json(name = "operation_group") val operationGroup: OperationGroupDto?,
    @Json(name = "registered_at") val registeredAt: String?,
    @Json(name = "vendor") val carVendor: String?,
    @Json(name = "vendor_slug") val carVendorSlug: String?,
) {
    fun toOperation(): Operation =
        Operation(
            address = address ?: "",
            carColor = carColor?.toColor(),
            department = department ?: "",
            isLast = isLast,
            isRegisteredToCompany = isRegisteredToCompany,
            type = type?.toType(),
            koatuu = koatuu ?: -1L,
            carModel = carModel ?: "",
            carModelYear = carModelYear ?: -1,
            operationNote = operationNote?.toOperationNote(),
            operationGroup = operationGroup?.toOperationGroup(),
            registeredAt = registeredAt ?: "",
            carVendor = carVendor ?: "",
            carVendorSlug = carVendorSlug ?: ""
        )
}