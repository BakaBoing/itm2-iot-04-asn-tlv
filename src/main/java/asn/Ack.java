package asn;

import com.github.alturkovic.asn.annotation.AsnPostProcessMethod;
import com.github.alturkovic.asn.annotation.AsnPrimitive;
import com.github.alturkovic.asn.annotation.AsnStructure;
import com.github.alturkovic.asn.annotation.AsnTag;
import com.github.alturkovic.asn.tag.Type;

import java.time.LocalDateTime;

/*
    Ack ::= SEQUENCE {
        version INTEGER (1 .. 16) DEFAULT 1,
        messageTimestamp DATE-TIME,
        msgNum INTEGER (1 .. 65535),
        state AckState
    }
 */
@AsnStructure(@AsnTag(0))
@AsnPostProcessMethod("postProcess")
public class Ack implements IAsnClass {
    @AsnPrimitive(@AsnTag(0))
    private final int _version = 1;
    @AsnPrimitive(@AsnTag(1))
    private String _messageTimestampUTCString;
    private LocalDateTime _messageTimestampUTC;
    @AsnPrimitive(@AsnTag(2))
    private int _timezone;
    @AsnPrimitive(@AsnTag(3))
    private int _msgNum;
    @AsnPrimitive(@AsnTag(4))
    private int _ackState;
    private AckState _state;

    public Ack() {
    }

    private void postProcess() {
        setMessageTimestampUTC(LocalDateTime.parse(_messageTimestampUTCString));
        setState(AckState.values()[_ackState]);
    }

    public int getVersion() {
        return _version;
    }

    public LocalDateTime getMessageTimestampUTC() {
        return _messageTimestampUTC;
    }

    public void setMessageTimestampUTC(LocalDateTime messageTimestampUTC) {
        _messageTimestampUTC = messageTimestampUTC;
        _messageTimestampUTCString = messageTimestampUTC.toString();
    }

    public int getTimezone() {
        return _timezone;
    }

    public void setTimezone(int timezone) {
        _timezone = timezone;
    }

    public AckState getState() {
        return _state;
    }

    public void setState(AckState state) {
        _state = state;
        _ackState = state.ordinal();
    }

    public int getMsgNum() {
        return _msgNum;
    }

    public void setMsgNum(int msgNum) {
        _msgNum = msgNum;
    }

    @Override
    public String toString() {
        return "Ack{" +
                "_version=" + _version +
                ", _messageTimestampUTCString='" + _messageTimestampUTCString + '\'' +
                ", _messageTimestampUTC=" + _messageTimestampUTC +
                ", _timezone=" + _timezone +
                ", _msgNum=" + _msgNum +
                ", _ackState=" + _ackState +
                ", _state=" + _state +
                '}';
    }
}
