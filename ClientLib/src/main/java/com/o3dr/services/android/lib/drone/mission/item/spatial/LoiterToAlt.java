package com.o3dr.services.android.lib.drone.mission.item.spatial;

import android.os.Parcel;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

/**
 * Created by Mathew on 3/29/2016.
 */
public class LoiterToAlt  extends BaseSpatialItem implements android.os.Parcelable  {

    private double radius = 0.0;
    private int heading = 1;

    public LoiterToAlt() {
        super(MissionItemType.LOITER_TO_ALT);
    }

    public LoiterToAlt(LoiterToAlt copy){
        super(copy);
        this.radius = copy.radius;
        this.heading = copy.heading;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return "LoiterToAlt{" +
                "heading=" + heading +
                ", radius=" + radius +
                ", " + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoiterToAlt)) return false;
        if (!super.equals(o)) return false;

        LoiterToAlt loitertoalt = (LoiterToAlt) o;

        if (Double.compare(loitertoalt.radius, radius) != 0) return false;
        return heading == loitertoalt.heading;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + heading;
        return result;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeDouble(this.radius);
        dest.writeInt(this.heading);
    }

    private LoiterToAlt(Parcel in) {
        super(in);
        this.radius = in.readDouble();
        this.heading = in.readInt();
    }

    @Override
    public MissionItem clone() {
        return new LoiterToAlt(this);
    }

    public static final Creator<LoiterToAlt> CREATOR = new Creator<LoiterToAlt>() {
        public LoiterToAlt createFromParcel(Parcel source) {
            return new LoiterToAlt(source);
        }

        public LoiterToAlt[] newArray(int size) {
            return new LoiterToAlt[size];
        }
    };
}

