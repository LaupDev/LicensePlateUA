package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class OperationDto(
    @field:Json(name = "address") val address: String?,
    @field:Json(name = "color") val carColor: ColorDto?,
    @field:Json(name = "department") val department: String?,
    @field:Json(name = "is_last") val isLast: Boolean?,
    @field:Json(name = "is_registered_to_company") val isRegisteredToCompany: Boolean?,
    @field:Json(name = "kind") val type: TypeDto?,
    @field:Json(name = "koatuu") val koatuu: Long?,
    @field:Json(name = "model") val carModel: String?,
    @field:Json(name = "model_year") val carModelYear: Int?,
    @field:Json(name = "operation") val operationNote: OperationNoteDto?,
    @field:Json(name = "operation_group") val operationGroup: OperationGroupDto?,
    @field:Json(name = "registered_at") val registeredAt: String?,
    @field:Json(name = "vendor") val carVendor: String?,
    @field:Json(name = "vendor_slug") val carVendorSlug: String?,
)