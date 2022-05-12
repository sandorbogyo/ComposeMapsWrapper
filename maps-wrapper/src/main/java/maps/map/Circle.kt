// Copyright 2021 Google LLC
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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import maps.wrapper.Circle
import maps.wrapper.CircleOptions
import maps.wrapper.LatLng
import maps.wrapper.PatternItem

internal class CircleNode(
    val circle: Circle,
    var onCircleClick: (Circle) -> Unit
) : MapNode {
    override fun onRemoved() {
        circle.remove()
    }
}

/**
 * A composable for a circle on the map.
 *
 * @param center the [LatLng] to use for the center of this circle
 * @param clickable boolean indicating if the circle is clickable or not
 * @param fillColor the fill color of the circle
 * @param radius the radius of the circle in meters.
 * @param strokeColor the stroke color of the circle
 * @param strokePattern a sequence of [PatternItem] to be repeated along the circle's outline (null
 * represents a solid line)
 * @param tag optional tag to be associated with the circle
 * @param strokeWidth the width of the circle's outline in screen pixels
 * @param visible the visibility of the circle
 * @param zIndex the z-index of the circle
 * @param onClick a lambda invoked when the circle is clicked
 */
@Composable
fun Circle(
    center: LatLng,
    clickable: Boolean = false,
    fillColor: Color = Color.Transparent,
    radius: Double = 0.0,
    strokeColor: Color = Color.Black,
    strokePattern: List<PatternItem>? = null,
    strokeWidth: Float = 10f,
    tag: Any? = null,
    visible: Boolean = true,
    zIndex: Float = 0f,
    onClick: (Circle) -> Unit = {},
) {
    val mapApplier = currentComposer.applier as? MapApplier
    ComposeNode<CircleNode, MapApplier>(
        factory = {
            var circle = mapApplier?.map?.addCircle(
                CircleOptions()
                    .center(center)
                    .clickable(clickable)
                    .fillColor(fillColor.toArgb())
                    .radius(radius)
                    .strokeColor(strokeColor.toArgb())
                    .strokePattern(strokePattern)
                    .strokeWidth(strokeWidth)
                    .visible(visible)
                    .zIndex(zIndex)
            ) ?: error("Error adding circle")
            circle.setTag(tag)
            CircleNode(circle, onClick)
        },
        update = {
            update(onClick) { this.onCircleClick = it }

            set(center) { this.circle.setCenter(it) }
            set(clickable) { this.circle.isClickable = it }
            set(fillColor) { this.circle.fillColor = it.toArgb() }
            set(radius) { this.circle.radius = it }
            set(strokeColor) { this.circle.strokeColor = it.toArgb() }
            set(strokePattern) { this.circle.strokePattern = it }
            set(strokeWidth) { this.circle.strokeWidth = it }
            set(tag) { this.circle.setTag(it) }
            set(visible) { this.circle.isVisible = it }
            set(zIndex) { this.circle.zIndex = it }
        }
    )
}