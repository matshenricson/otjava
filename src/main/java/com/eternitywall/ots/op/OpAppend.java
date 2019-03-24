package com.eternitywall.ots.op;

import com.eternitywall.ots.StreamDeserializationContext;
import com.eternitywall.ots.Utils;

import java.util.Arrays;

/**
 * Append a suffix to a message.
 *
 * @see OpBinary
 */
public class OpAppend extends OpBinary {

    public static final byte _TAG = (byte) 0xf0;

    byte[] arg;

    @Override
    public byte _TAG() {
        return OpAppend._TAG;
    }

    @Override
    public String _TAG_NAME() {
        return "append";
    }

    public OpAppend() {
        super();
        this.arg = new byte[]{};
    }

    public OpAppend(byte[] arg) {
        super(arg);
        this.arg = arg;
    }

    @Override
    public byte[] call(byte[] msg) {
        return Utils.arraysConcat(msg, this.arg);
    }

    public static Op deserializeFromTag(StreamDeserializationContext ctx, byte tag) {
        return OpBinary.deserializeFromTag(ctx, tag);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof OpAppend)) {
            return false;
        }

        return Arrays.equals(this.arg, ((OpAppend) other).arg);
    }

    @Override
    public int hashCode() {
        return _TAG ^ Arrays.hashCode(this.arg);
    }
}
