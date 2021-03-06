package org.apache.xml.dtm.ref;

import org.apache.xml.dtm.DTMAxisIterator;
import org.apache.xml.utils.WrappedRuntimeException;

public abstract class DTMAxisIteratorBase implements DTMAxisIterator {
    protected boolean _includeSelf = false;
    protected boolean _isRestartable = true;
    protected int _last = -1;
    protected int _markedNode;
    protected int _position = 0;
    protected int _startNode = -1;

    public int getStartNode() {
        return this._startNode;
    }

    public DTMAxisIterator reset() {
        boolean temp = this._isRestartable;
        this._isRestartable = true;
        setStartNode(this._startNode);
        this._isRestartable = temp;
        return this;
    }

    public DTMAxisIterator includeSelf() {
        this._includeSelf = true;
        return this;
    }

    public int getLast() {
        if (this._last == -1) {
            int temp = this._position;
            setMark();
            reset();
            do {
                this._last++;
            } while (next() != -1);
            gotoMark();
            this._position = temp;
        }
        return this._last;
    }

    public int getPosition() {
        if (this._position == 0) {
            return 1;
        }
        return this._position;
    }

    public boolean isReverse() {
        return false;
    }

    public DTMAxisIterator cloneIterator() {
        try {
            DTMAxisIteratorBase clone = (DTMAxisIteratorBase) super.clone();
            clone._isRestartable = false;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new WrappedRuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final int returnNode(int node) {
        this._position++;
        return node;
    }

    /* access modifiers changed from: protected */
    public final DTMAxisIterator resetPosition() {
        this._position = 0;
        return this;
    }

    public boolean isDocOrdered() {
        return true;
    }

    public int getAxis() {
        return -1;
    }

    public void setRestartable(boolean isRestartable) {
        this._isRestartable = isRestartable;
    }

    public int getNodeByPosition(int position) {
        int pos;
        int node;
        if (position > 0) {
            if (isReverse()) {
                pos = (getLast() - position) + 1;
            } else {
                pos = position;
            }
            do {
                int next = next();
                node = next;
                if (next != -1) {
                }
            } while (pos != getPosition());
            return node;
        }
        return -1;
    }
}
