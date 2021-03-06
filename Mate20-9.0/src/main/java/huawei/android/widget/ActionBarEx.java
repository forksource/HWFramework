package huawei.android.widget;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;

public class ActionBarEx {

    public interface OnStageChangedListener {
        void onEnterNextStage();

        void onExitNextStage();
    }

    public static void setStartIcon(ActionBar actionBar, HwToolbar toolbar, boolean icon1Visible, Drawable icon1, View.OnClickListener listener1) {
        toolbar.setStartIcon(icon1Visible, icon1, listener1);
        setIconLayout(actionBar, toolbar);
    }

    public static void setEndIcon(ActionBar actionBar, HwToolbar toolbar, boolean icon2Visible, Drawable icon2, View.OnClickListener listener2) {
        toolbar.setEndIcon(icon2Visible, icon2, listener2);
        setIconLayout(actionBar, toolbar);
    }

    public static void setSpiltViewBlurEnable(HwToolbar toolbar, boolean enable) {
        if (toolbar.getSplieView() != null) {
            toolbar.getSplieView().setBlurEnable(enable);
        }
    }

    public static boolean isSpiltViewBlurEnable(HwToolbar toolbar) {
        if (toolbar.getSplieView() != null) {
            return toolbar.getSplieView().isBlurEnable();
        }
        return false;
    }

    public static void setBlurEnable(HwToolbar toolbar, boolean enable) {
        toolbar.setBlurEnable(enable);
    }

    public static boolean isBlurEnable(HwToolbar toolbar) {
        return toolbar.isBlurEnable();
    }

    public static void setBlurColor(HwToolbar toolbar, int blurColor) {
        toolbar.setBlurColor(blurColor);
    }

    public static void setSplitViewBlurColor(HwToolbar toolbar, int blurColor) {
        if (toolbar.getSplieView() != null) {
            toolbar.getSplieView().setBlurColor(blurColor);
        }
    }

    public static void setStartContentDescription(HwToolbar toolbar, CharSequence contentDescription) {
        toolbar.setStartContentDescription(contentDescription);
    }

    public static void setEndContentDescription(HwToolbar toolbar, CharSequence contentDescription) {
        toolbar.setEndContentDescription(contentDescription);
    }

    public static void setCustomTitle(ActionBar actionBar, HwToolbar toolbar, View view) {
        toolbar.setCustomTitle(view);
        setIconLayout(actionBar, toolbar);
    }

    public static void setSplitViewLocation(ActionBar actionBar, HwToolbar toolbar, int start, int end) {
        toolbar.setSplitViewLocation(start, end);
    }

    public static void setSplitToolbarForce(HwToolbar toolbar, boolean forceSplit) {
        toolbar.setSplitToolbarForce(forceSplit);
    }

    public static void setDynamicSplitToolbar(HwToolbar toolbar, boolean split) {
        toolbar.setDynamicSplitMenu(split);
    }

    public static void setSplitBackgroundDrawable(HwToolbar toolbar, Drawable d) {
        toolbar.setSplitBackgroundDrawable(d);
    }

    public static void setDisplySpinnerMode(HwToolbar toolbar, ActionBar actionBar, int contentId, AdapterView.OnItemSelectedListener listener) {
        toolbar.setDisplaySpinner(contentId, listener);
        actionBar.setDisplayShowTitleEnabled(false);
        setIconLayout(actionBar, toolbar);
    }

    public static SpinnerAdapter getSpinnerAdapter(HwToolbar toolbar) {
        return toolbar.getSpinnerAdapter();
    }

    public static int getDropdownSelectedPosition(HwToolbar toolbar) {
        return toolbar.getDropdownSelectedPosition();
    }

    public static int getDropdownItemCount(HwToolbar toolbar) {
        return toolbar.getDropdownItemCount();
    }

    public static void setTabScrollingOffsets(ActionBar actionBar, int index, float offset) {
    }

    public static void setTabViewId(ActionBar.Tab tab, int id) {
    }

    public static int getTabViewId(ActionBar.Tab tab) {
        return 0;
    }

    public static void setCustomDragView(ActionBar actionBar, View view) {
    }

    public static void setCustomDragView(ActionBar actionBar, View view, View secondView) {
    }

    public static void startStageAnimation(ActionBar actionBar, int stage, boolean isScrollDown) {
    }

    public static void setCanDragFromContent(ActionBar actionBar, boolean canDragFromContent) {
    }

    public static void setStillView(ActionBar actionBar, View view, boolean isStill) {
    }

    public static int getDragAnimationStage(ActionBar actionBar) {
        return 0;
    }

    public static void setStageChangedCallBack(ActionBar actionBar, OnStageChangedListener callback) {
    }

    public static void setStartStageChangedCallBack(ActionBar actionBar, OnStageChangedListener callback) {
    }

    public static void resetDragAnimation(ActionBar actionBar) {
    }

    public static void setLazyMode(ActionBar actionBar, boolean isLazyMode) {
    }

    public static void setActionBarDraggable(ActionBar actionBar, boolean isDraggable) {
    }

    private static void setIconLayout(ActionBar actionBar, HwToolbar toolbar) {
        actionBar.setDisplayShowCustomEnabled(true);
        if (toolbar.getIconLayout() != null) {
            actionBar.setCustomView(toolbar.getIconLayout(), new ActionBar.LayoutParams(-1, -2));
        }
    }
}
