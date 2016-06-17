package org.droidplanner.services.android.core.mission.waypoints;

import com.MAVLink.common.msg_mission_item;
import com.MAVLink.enums.MAV_CMD;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;

import org.droidplanner.services.android.core.mission.Mission;
import org.droidplanner.services.android.core.mission.MissionItemImpl;
import org.droidplanner.services.android.core.mission.MissionItemType;

import java.util.List;

public class LoiterToAltImpl extends SpatialCoordItem {

    private double radius = 10.0;
    private int heading = 1;

    public LoiterToAltImpl(MissionItemImpl item) {
        super(item);
    }

    public LoiterToAltImpl(Mission mission, LatLongAlt coord) {
        super(mission, coord);
    }

    public LoiterToAltImpl(msg_mission_item msg, Mission mission) {
        super(mission, null);
        unpackMAVMessage(msg);
    }

    public void setHeading(int heading) {
        this.heading = Math.abs(heading);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getHeading() {
        return heading;
    }

    public double getRadius() {
        return radius;
    }


    //

    @Override
    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> list = super.packMissionItem();
        msg_mission_item mavMsg = list.get(0);
        mavMsg.command = MAV_CMD.MAV_CMD_NAV_LOITER_TO_ALT;
        mavMsg.param1 = (float)heading;
        mavMsg.param2 = (float) radius;
        return list;

    }

    @Override
    public void unpackMAVMessage(msg_mission_item mavMsg) {
        super.unpackMAVMessage(mavMsg);
        setHeading((int) mavMsg.param1);
        setRadius(mavMsg.param2);
    }

    @Override
    public MissionItemType getType() { return MissionItemType.LOITER_TO_ALT;}

}
