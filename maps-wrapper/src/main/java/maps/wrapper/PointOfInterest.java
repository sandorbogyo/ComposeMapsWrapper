package maps.wrapper;

public class PointOfInterest {
    com.huawei.hms.maps.model.PointOfInterest hInterest;
    com.google.android.gms.maps.model.PointOfInterest gInterest;

    public PointOfInterest(com.google.android.gms.maps.model.PointOfInterest gInterest, com.huawei.hms.maps.model.PointOfInterest hInterest) {
        this.gInterest = gInterest;
        this.hInterest = hInterest;
    }
}