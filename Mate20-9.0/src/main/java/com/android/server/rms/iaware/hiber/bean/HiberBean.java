package com.android.server.rms.iaware.hiber.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.rms.iaware.AwareLog;
import java.util.Arrays;

public class HiberBean implements Parcelable {
    private static final String TAG = "AppHiber_Mgr_Bean";
    public int func_Id;
    public int operate_type;
    public int[] pidArray;
    public String pkgName;

    public HiberBean(int func_Id2, String pkgName2, int[] pidArray2, int operate_type2) {
        this.func_Id = func_Id2;
        this.pkgName = pkgName2;
        if (pidArray2 != null) {
            this.pidArray = Arrays.copyOf(pidArray2, pidArray2.length);
        }
        this.operate_type = operate_type2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (dest == null) {
            AwareLog.w(TAG, "null == dest");
            return;
        }
        dest.writeInt(this.func_Id);
        if (flags == 1) {
            dest.writeString(this.pkgName);
            dest.writeIntArray(this.pidArray);
        }
        dest.writeInt(this.operate_type);
    }
}
