package maps.wrapper;

import androidx.annotation.NonNull;


public class GroundOverlay {
    com.huawei.hms.maps.model.GroundOverlay huawei;
    com.google.android.gms.maps.model.GroundOverlay google;

    GroundOverlay(com.google.android.gms.maps.model.GroundOverlay google,
                  com.huawei.hms.maps.model.GroundOverlay huawei) {
        this.huawei = huawei;
        this.google = google;
    }

    public void setTag(Object tag) {
        if (google != null) google.setTag(tag);
        if (huawei != null) huawei.setTag(tag);
    }

    public Object getTag() {
        Object result = null;
        if (google != null) result = google.getTag();
        if (huawei != null) result = huawei.getTag();
        return result;
    }

    public void setTransparency(float value) {
        if (google != null) google.setTransparency(value);
        if (huawei != null) huawei.setTransparency(value);
    }

    public void setBearing(float value) {
        if (google != null) google.setBearing(value);
        if (huawei != null) huawei.setBearing(value);
    }

    public final void setPosition(LatLng value) {
        if (google != null) google.setPosition(value.google);
        if (huawei != null) huawei.setPosition(value.huawei);
    }

    public final void setDimensions(float value) {
        if (google != null) google.setDimensions(value);
        if (huawei != null) huawei.setDimensions(value);
    }

    public final void setDimensions(float value1, float value2) {
        if (google != null) google.setDimensions(value1, value2);
        if (huawei != null) huawei.setDimensions(value1, value2);
    }

    public final void setPositionFromBounds(LatLngBounds value) {
        if (google != null) google.setPositionFromBounds(value.google);
        if (huawei != null) huawei.setPositionFromBounds(value.huawei);
    }

    public float getTransparency() {
        float res = -1;
        if (google != null) res = google.getTransparency();
        if (huawei != null) res = huawei.getTransparency();
        return res;
    }

    public void setImage(@NonNull BitmapDescriptor value) {
        if (google != null) google.setImage(value.google);
        if (huawei != null) huawei.setImage(value.huawei);
    }

    public final void setClickable(boolean value) {
        if (google != null) google.setClickable(value);
        if (huawei != null) huawei.setClickable(value);
    }

    public final void setZIndex(float zIndex) {
        if (google != null) google.setZIndex(zIndex);
        if (huawei != null) huawei.setZIndex(zIndex);
    }

    public final float getZIndex() {
        if (google != null) return google.getZIndex();
        if (huawei != null) return huawei.getZIndex();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS GroundOverlay.");
    }

    public final void remove() {
        if (google != null) google.remove();
        if (huawei != null) huawei.remove();
    }

    public final void setVisible(boolean visible) {
        if (google != null) google.setVisible(visible);
        if (huawei != null) huawei.setVisible(visible);
    }

    public final boolean isVisible() {
        if (google != null) return google.isVisible();
        if (huawei != null) return huawei.isVisible();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS GroundOverlay.");
    }
}