package maps.wrapper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
    com.google.android.gms.maps.model.Polygon google;
    com.huawei.hms.maps.model.Polygon huawei;

    Polygon(com.google.android.gms.maps.model.Polygon google,
            com.huawei.hms.maps.model.Polygon huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public final void setStrokeWidth(float value) {
        if (google != null) google.setStrokeWidth(value);
        if (huawei != null) huawei.setStrokeWidth(value);
    }

    public final void remove() {
        if (google != null) google.remove();
        if (huawei != null) huawei.remove();
    }


    public final float getStrokeWidth() {
        float result = -1.0F;
        if (google != null) return google.getStrokeWidth();
        if (huawei != null) return huawei.getStrokeWidth();
        return result;
    }

    public final void setStrokeColor(int value) {
        if (google != null) google.setStrokeColor(value);
        if (huawei != null) huawei.setStrokeColor(value);
    }

    public final int getStrokeColor() {
        int result = 0;
        if (google != null) return google.getStrokeColor();
        if (huawei != null) return huawei.getStrokeColor();
        return result;
    }

    public final void setStrokeJointType(int value) {
        if (google != null) google.setStrokeJointType(value);
        if (huawei != null) huawei.setStrokeJointType(value);
    }

    public final void setStrokePattern(List<PatternItem> values) {
        if (values != null) {
            if (google != null) {
                List<com.google.android.gms.maps.model.PatternItem> gValues = new ArrayList<>();
                for (PatternItem item : values) {
                    gValues.add(item.gPattern);
                }
                google.setStrokePattern(gValues);
            }
            if (huawei != null) {
                List<com.huawei.hms.maps.model.PatternItem> hValues = new ArrayList<>();
                for (PatternItem item : values) {
                    hValues.add(item.hPattern);
                }
                huawei.setStrokePattern(hValues);
            }
        }

    }

    public final int getStrokeJointType() {
        int result = 0;
        if (google != null) return google.getStrokeJointType();
        if (huawei != null) return huawei.getStrokeJointType();
        return result;
    }

    public final void setFillColor(int value) {
        if (google != null) google.setFillColor(value);
        if (huawei != null) huawei.setFillColor(value);
    }

    public final int getFillColor() {
        int result = 0;
        if (google != null) return google.getFillColor();
        if (huawei != null) return huawei.getFillColor();
        return result;
    }

    public final void setTag(@Nullable Object value) {
        if (google != null) google.setTag(value);
        if (huawei != null) huawei.setTag(value);
    }

    public final void setPoints(List<LatLng> value) {
        List<com.huawei.hms.maps.model.LatLng> hList = new ArrayList<>();
        List<com.google.android.gms.maps.model.LatLng> gList = new ArrayList<>();
        for (LatLng item : value) {
            hList.add(new com.huawei.hms.maps.model.LatLng(item.latitude, item.longitude));
            gList.add(new com.google.android.gms.maps.model.LatLng(item.latitude, item.longitude));
        }
        huawei.setPoints(hList);
        google.setPoints(gList);
    }

    public void setHoles(List<List<LatLng>> value) {
        List<List<com.huawei.hms.maps.model.LatLng>> hList = new ArrayList<>();
        List<List<com.google.android.gms.maps.model.LatLng>> gList = new ArrayList<>();
        for (List<LatLng> item : value) {
            List<com.huawei.hms.maps.model.LatLng> hListInner = new ArrayList<>();
            List<com.google.android.gms.maps.model.LatLng> gListInner = new ArrayList<>();
            for (LatLng itemInner : item) {
                hListInner.add(new com.huawei.hms.maps.model.LatLng(itemInner.latitude, itemInner.longitude));
                gListInner.add(new com.google.android.gms.maps.model.LatLng(itemInner.latitude, itemInner.longitude));
            }
            hList.add(hListInner);
            gList.add(gListInner);
        }
        huawei.setHoles(hList);
        google.setHoles(gList);
    }

    @Nullable
    public final Object getTag() {
        if (google != null) return google.getTag();
        if (huawei != null) return huawei.getTag();
        return null;
    }

    public final void setClickable(boolean value) {
        if (google != null) google.setClickable(value);
        if (huawei != null) huawei.setClickable(value);
    }

    public final void setVisible(boolean value) {
        if (google != null) google.setVisible(value);
        if (huawei != null) huawei.setVisible(value);
    }

    public final void setGeodesic(boolean value) {
        if (google != null) google.setGeodesic(value);
        if (huawei != null) huawei.setGeodesic(value);
    }


    public final void setZIndex(float value) {
        if (google != null) google.setZIndex(value);
        if (huawei != null) huawei.setZIndex(value);
    }

    public final float getZIndex() {
        if (google != null) return google.getZIndex();
        if (huawei != null) return huawei.getZIndex();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS Polygon.");
    }
}
