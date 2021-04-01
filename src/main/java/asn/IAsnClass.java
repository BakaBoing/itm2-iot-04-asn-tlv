package asn;

import com.github.alturkovic.asn.annotation.AsnPolymorphic;
import com.github.alturkovic.asn.annotation.AsnTag;
import com.github.alturkovic.asn.tag.Type;

import java.io.Serializable;

//@AsnPolymorphic(value = @AsnTag(0), type = WeatherData.class)
//@AsnPolymorphic(value = @AsnTag(1), type = ReqCmd.class)
public interface IAsnClass extends Serializable {
}
