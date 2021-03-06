package android_maps_conflict_avoidance.com.google.android.gtalkservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.maps.MapView.LayoutParams;
import com.google.android.maps.OverlayItem;

public final class ConnectionError implements Parcelable {
    public static final Creator<ConnectionError> CREATOR = null;
    private int mError;

    static {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android_maps_conflict_avoidance.com.google.android.gtalkservice.ConnectionError.<clinit>():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: jadx.core.utils.exceptions.DecodeException:  in method: android_maps_conflict_avoidance.com.google.android.gtalkservice.ConnectionError.<clinit>():void
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:46)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:98)
	... 5 more
Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1197)
	at com.android.dx.io.OpcodeInfo.getFormat(OpcodeInfo.java:1212)
	at com.android.dx.io.instructions.DecodedInstruction.decode(DecodedInstruction.java:72)
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:43)
	... 6 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android_maps_conflict_avoidance.com.google.android.gtalkservice.ConnectionError.<clinit>():void");
    }

    public ConnectionError(Parcel source) {
        this.mError = source.readInt();
    }

    public final String toString() {
        return toString(this.mError);
    }

    public static final String toString(int state) {
        switch (state) {
            case OverlayItem.ITEM_STATE_PRESSED_MASK /*1*/:
                return "NO NETWORK";
            case OverlayItem.ITEM_STATE_SELECTED_MASK /*2*/:
                return "CONNECTION FAILED";
            case LayoutParams.LEFT /*3*/:
                return "UNKNOWN HOST";
            case OverlayItem.ITEM_STATE_FOCUSED_MASK /*4*/:
                return "AUTH FAILED";
            case LayoutParams.RIGHT /*5*/:
                return "AUTH EXPIRED";
            case 6:
                return "HEARTBEAT TIMEOUT";
            case 7:
                return "SERVER FAILED";
            case 8:
                return "SERVER REJECT - RATE LIMIT";
            case 10:
                return "UNKNOWN";
            default:
                return "NO ERROR";
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mError);
    }

    public int describeContents() {
        return 0;
    }
}
