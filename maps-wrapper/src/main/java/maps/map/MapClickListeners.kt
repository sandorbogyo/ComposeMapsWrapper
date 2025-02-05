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

import android.location.Location
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import maps.wrapper.IndoorBuilding
import maps.wrapper.LatLng
import maps.wrapper.PointOfInterest

/**
 * Default implementation of [IndoorStateChangeListener] with no-op
 * implementations.
 */
object DefaultIndoorStateChangeListener : IndoorStateChangeListener

/**
 * Interface definition for building indoor level state changes.
 */
interface IndoorStateChangeListener {
    /**
     * Callback invoked when an indoor building comes to focus.
     */
    fun onIndoorBuildingFocused() {}

    /**
     * Callback invoked when a level for a building is activated.
     * @param building the activated building
     */
    fun onIndoorLevelActivated(building: IndoorBuilding) {}
}

/**
 * Holder class for top-level click listeners.
 */
internal class MapClickListeners {
    var indoorStateChangeListener: IndoorStateChangeListener by mutableStateOf(
        DefaultIndoorStateChangeListener
    )
    var onMapClick: (LatLng) -> Unit by mutableStateOf({})
    var onMapLongClick: (LatLng) -> Unit by mutableStateOf({})
    var onMapLoaded: () -> Unit by mutableStateOf({})
    var onMyLocationButtonClick: () -> Boolean by mutableStateOf({ false })
    var onMyLocationClick: (Location) -> Unit by mutableStateOf({})
    var onPOIClick: (PointOfInterest) -> Unit by mutableStateOf({})
}
