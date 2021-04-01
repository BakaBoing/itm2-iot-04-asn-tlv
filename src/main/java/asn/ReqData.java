package asn;

/*
    ReqData ::= SEQUENCE {
        version INTEGER (1 .. 16) DEFAULT 1,
        messageTimestamp DATE-TIME,
        msgNum INTEGER (1 .. 65535),
        requestedDataBeginTimestamp DATE-TIME,
        requestedDataEndTimestamp DATE-TIME
    }
 */

import com.github.alturkovic.asn.annotation.AsnPostProcessMethod;
import com.github.alturkovic.asn.annotation.AsnPrimitive;
import com.github.alturkovic.asn.annotation.AsnStructure;
import com.github.alturkovic.asn.annotation.AsnTag;

import java.time.LocalDateTime;

@AsnStructure(@AsnTag(0))
@AsnPostProcessMethod("postProcess")
public class ReqData implements IAsnClass {
    @AsnPrimitive(@AsnTag(0))
    private int _version;
    @AsnPrimitive(@AsnTag(1))
    private String _messageTimestampUTCString;
    private LocalDateTime _messageTimestampUTC;
    @AsnPrimitive(@AsnTag(2))
    private int _timezone;
    @AsnPrimitive(@AsnTag(3))
    private int _msgNum;
    @AsnPrimitive(@AsnTag(4))
    private String _requestedDataBeginTimestampUTCString;
    private LocalDateTime _requestedDataBeginTimestampUTC;
    @AsnPrimitive(@AsnTag(5))
    private String _requestedDataEndTimestampUTCString;
    private LocalDateTime _requestedDataEndTimestampUTC;

    public ReqData() {
    }

    private void postProcess() {
        setMessageTimestampUTC(LocalDateTime.parse(_messageTimestampUTCString));
        setRequestedDataBeginTimestampUTC(LocalDateTime.parse(_requestedDataBeginTimestampUTCString));
        setRequestedDataEndTimestampUTC(LocalDateTime.parse(_requestedDataEndTimestampUTCString));
    }

    public int getVersion() {
        return _version;
    }

    public void setVersion(int version) {
        _version = version;
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

    public int getMsgNum() {
        return _msgNum;
    }

    public void setMsgNum(int msgNum) {
        _msgNum = msgNum;
    }

    public LocalDateTime getRequestedDataBeginTimestampUTC() {
        return _requestedDataBeginTimestampUTC;
    }

    public void setRequestedDataBeginTimestampUTC(LocalDateTime requestedDataBeginTimestampUTC) {
        _requestedDataBeginTimestampUTC = requestedDataBeginTimestampUTC;
        _requestedDataBeginTimestampUTCString = requestedDataBeginTimestampUTC.toString();
    }

    public LocalDateTime getRequestedDataEndTimestampUTC() {
        return _requestedDataEndTimestampUTC;
    }

    public void setRequestedDataEndTimestampUTC(LocalDateTime requestedDataEndTimestampUTC) {
        _requestedDataEndTimestampUTC = requestedDataEndTimestampUTC;
        _requestedDataEndTimestampUTCString = requestedDataEndTimestampUTC.toString();
    }
}
