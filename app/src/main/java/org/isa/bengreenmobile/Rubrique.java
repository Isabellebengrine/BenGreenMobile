package org.isa.bengreenmobile;

import com.google.gson.annotations.SerializedName;

public class Rubrique {

    @SerializedName("id")
    private int id;

    @SerializedName("parent_id")
    private int parentId;

    @SerializedName("rubrique_name")
    private String rubriqueName;

    @SerializedName("rubrique_picture")
    private String rubriquePicture;

    public Rubrique(int id, int parentId, String rubriqueName, String rubriquePicture) {
        this.id = id;
        this.parentId = parentId;
        this.rubriqueName = rubriqueName;
        this.rubriquePicture = rubriquePicture;
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public String getRubriqueName() {
        return rubriqueName;
    }

    public String getRubriquePicture() {
        return rubriquePicture;
    }

}