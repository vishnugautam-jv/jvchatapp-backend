package com.jvgroup.jvchatapp.projection;

import java.util.List;

public interface GroupProjection {

    int getGroupId();
    String getGroupName();
    String getGroupSuperAdmin();
    String getGroupAdmin();
    String getGroupImage();
    boolean getIsPrivateChat();
    List<String> getGroupMembers();
}
