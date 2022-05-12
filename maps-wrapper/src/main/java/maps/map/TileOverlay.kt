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
import maps.wrapper.TileOverlay
import maps.wrapper.TileOverlayOptions
import maps.wrapper.TileProvider

private class TileOverlayNode(
    var tileOverlay: TileOverlay,
    var onTileOverlayClick: (TileOverlay) -> Unit
) : MapNode {
    override fun onRemoved() {
        tileOverlay.remove()
    }
}

/**
 * A composable for a tile overlay on the map.
 *
 * @param tileProvider the tile provider to use for this tile overlay
 * @param fadeIn boolean indicating whether the tiles should fade in
 * @param transparency the transparency of the tile overlay
 * @param visible the visibility of the tile overlay
 * @param zIndex the z-index of the tile overlay
 * @param onClick a lambda invoked when the tile overlay is clicked
 */
@Composable
fun TileOverlay(
    tileProvider: TileProvider,
    fadeIn: Boolean = true,
    transparency: Float = 0f,
    visible: Boolean = true,
    zIndex: Float = 0f,
    onClick: (TileOverlay) -> Unit = {},
) {
    val mapApplier = currentComposer.applier as MapApplier?
    ComposeNode<TileOverlayNode, MapApplier>(
        factory = {
            val tileOverlay = mapApplier?.map?.addTileOverlay(
                TileOverlayOptions()
                    .tileProvider(tileProvider)
                    .fadeIn(fadeIn)
                    .transparency(transparency)
                    .visible(visible)
                    .zIndex(zIndex)
            ) ?: error("Error adding tile overlay")
            TileOverlayNode(tileOverlay, onClick)
        },
        update = {
            update(onClick) { this.onTileOverlayClick = it }

            set(tileProvider) {
                this.tileOverlay.remove()
                this.tileOverlay = mapApplier?.map?.addTileOverlay(
                    TileOverlayOptions()
                        .tileProvider(tileProvider)
                        .fadeIn(fadeIn)
                        .transparency(transparency)
                        .visible(visible)
                        .zIndex(zIndex)
                ) ?: error("Error adding tile overlay")
            }
            set(fadeIn) { this.tileOverlay.setFadeIn(it) }
            set(transparency) { this.tileOverlay.setTransparency(it) }
            set(visible) { this.tileOverlay.setVisible(it) }
            set(zIndex) { this.tileOverlay.zIndex = it }
        }
    )
}