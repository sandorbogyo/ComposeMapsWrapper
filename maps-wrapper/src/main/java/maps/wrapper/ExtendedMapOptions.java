package maps.wrapper;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMapOptions;
import com.huawei.hms.maps.HuaweiMapOptions;

public class ExtendedMapOptions {
    com.google.android.gms.maps.GoogleMapOptions google;
    com.huawei.hms.maps.HuaweiMapOptions huawei;


    public ExtendedMapOptions() {
        google = new com.google.android.gms.maps.GoogleMapOptions();
        huawei = new com.huawei.hms.maps.HuaweiMapOptions();
    }


    public final ExtendedMapOptions createFromAttributes(@Nullable Context context, @Nullable AttributeSet attrs) {
        if (google != null) google = GoogleMapOptions.createFromAttributes(context, attrs);
        if (huawei != null) huawei = HuaweiMapOptions.createFromAttributes(context, attrs);
        return this;
    }


}
