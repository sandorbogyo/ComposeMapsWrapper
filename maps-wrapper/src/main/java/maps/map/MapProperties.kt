// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package maps.map;

import maps.wrapper.LatLngBounds
import maps.wrapper.MapStyleOptions
import java.util.*

internal val DefaultMapProperties = MapProperties()

/**
 * Data class for properties that can be modified on the map.
 *
 * Note: This is intentionally a class and not a data class for binary
 * compatibility on future changes.
 * See: https://jakewharton.com/public-api-challenges-in-kotlin/
 */
class MapProperties(
    val isBuildingEnabled: Boolean = false,
    val isIndoorEnabled: Boolean = false,
    val isMyLocationEnabled: Boolean = false,
    val isTrafficEnabled: Boolean = false,
    val latLngBoundsForCameraTarget: LatLngBounds? = null,
    val mapStyleOptions: MapStyleOptions? = null,
    val mapType: MapType = MapType.NORMAL,
    val maxZoomPreference: Float = 21.0f,
    val minZoomPreference: Float = 3.0f,
) {
    override fun toString(): String = "MapProperties(" +
            "isBuildingEnabled=$isBuildingEnabled, isIndoorEnabled=$isIndoorEnabled, " +
            "isMyLocationEnabled=$isMyLocationEnabled, isTrafficEnabled=$isTrafficEnabled, " +
            "latLngBoundsForCameraTarget=$latLngBoundsForCameraTarget, mapStyleOptions=$mapStyleOptions, " +
            "mapType=$mapType, maxZoomPreference=$maxZoomPreference, " +
            "minZoomPreference=$minZoomPreference)"

    override fun equals(other: Any?): Boolean = other is MapProperties &&
            isBuildingEnabled == other.isBuildingEnabled &&
            isIndoorEnabled == other.isIndoorEnabled &&
            isMyLocationEnabled == other.isMyLocationEnabled &&
            isTrafficEnabled == other.isTrafficEnabled &&
            latLngBoundsForCameraTarget == other.latLngBoundsForCameraTarget &&
            mapStyleOptions == other.mapStyleOptions &&
            mapType == other.mapType &&
            maxZoomPreference == other.maxZoomPreference &&
            minZoomPreference == other.minZoomPreference

    override fun hashCode(): Int = Objects.hash(
        isBuildingEnabled,
        isIndoorEnabled,
        isMyLocationEnabled,
        isTrafficEnabled,
        latLngBoundsForCameraTarget,
        mapStyleOptions,
        mapType,
        maxZoomPreference,
        minZoomPreference
    )

    fun copy(
        isBuildingEnabled: Boolean = this.isBuildingEnabled,
        isIndoorEnabled: Boolean = this.isIndoorEnabled,
        isMyLocationEnabled: Boolean = this.isMyLocationEnabled,
        isTrafficEnabled: Boolean = this.isTrafficEnabled,
        latLngBoundsForCameraTarget: LatLngBounds? = this.latLngBoundsForCameraTarget,
        mapStyleOptions: MapStyleOptions? = this.mapStyleOptions,
        mapType: MapType = this.mapType,
        maxZoomPreference: Float = this.maxZoomPreference,
        minZoomPreference: Float = this.minZoomPreference,
    ) = MapProperties(
        isBuildingEnabled = isBuildingEnabled,
        isIndoorEnabled = isIndoorEnabled,
        isMyLocationEnabled = isMyLocationEnabled,
        isTrafficEnabled = isTrafficEnabled,
        latLngBoundsForCameraTarget = latLngBoundsForCameraTarget,
        mapStyleOptions = mapStyleOptions,
        mapType = mapType,
        maxZoomPreference = maxZoomPreference,
        minZoomPreference = minZoomPreference,
    )
}

