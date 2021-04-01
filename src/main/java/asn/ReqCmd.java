package asn;

import com.github.alturkovic.asn.annotation.AsnStructure;
import com.github.alturkovic.asn.annotation.AsnTag;
import com.github.alturkovic.asn.tag.Type;

/*
    ReqCmd ::= SEQUENCE {
        version INTEGER (1 .. 16) DEFAULT 1,
        messageTimestamp DATE-TIME,
        msgNum INTEGER (1 .. 65535),
        commandNumber INTEGER (1 .. 16)
    }
 */

@AsnStructure(@AsnTag(value = 16, type = Type.UNIVERSAL))
public class ReqCmd implements IAsnClass{
}
