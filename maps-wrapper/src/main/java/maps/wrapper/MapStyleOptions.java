package maps.wrapper;

import android.content.Context;

public class MapStyleOptions {
    com.google.android.gms.maps.model.MapStyleOptions google;
    com.huawei.hms.maps.model.MapStyleOptions huawei;

    MapStyleOptions(com.google.android.gms.maps.model.MapStyleOptions google,
                    com.huawei.hms.maps.model.MapStyleOptions huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public static MapStyleOptions loadRawResourceStyle(Context clientContext, int resourceId) {
        com.google.android.gms.maps.model.MapStyleOptions google = null;
        com.huawei.hms.maps.model.MapStyleOptions huawei = null;
        try {
            google = com.google.android.gms.maps.model.MapStyleOptions.loadRawResourceStyle(clientContext, resourceId);
        } catch (Exception e) {
        }

        try {
            huawei = com.huawei.hms.maps.model.MapStyleOptions.loadRawResourceStyle(clientContext, resourceId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new MapStyleOptions(google, huawei);
    }

}
