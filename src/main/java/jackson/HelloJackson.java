package jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author chuck
 * @since 5/26/16
 */
public class HelloJackson {

  public static void main(String[] args) {
    NapiDTO dto = new NapiDTO();
    dto.setId(123);
    dto.setName("a name");
    dto.setSettlePrice(123);
    dto.setGmtCreate(new Date());
    dto.setGmtUpdate(new Date());
    Extend ext = new Extend();
    ext.setDesc("a description");
    List<String> pics = new ArrayList<>();
    pics.add("http://img4.duitang.com");
    pics.add("http://img5.duitang.com");
    ext.setPic(pics);
    dto.setExtend(ext);
    dto.setStatus(Status.AVAILABLE);

    ObjectMapper mapper = new ObjectMapper();
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    ObjectWriter writer = mapper.writer();
    ObjectReader reader = mapper.reader();
    try {
      JsonNode node = reader.readTree(writer.writeValueAsString(dto));
      JsonNode pic = node.get("extend").get("pic");
      if (pic.isArray()) {
        ArrayNode pictures = (ArrayNode) pic;
        for (JsonNode picture : pictures) {
          System.out.println(picture);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    Domain domain = mapper.convertValue(dto, Domain.class);
    DO aDO = mapper.convertValue(domain, DO.class);

    aDO.toString();
//    long start = System.currentTimeMillis();
//    for (int i = 0; i < 10000; i++) {
//      try {
//        ObjectMapper mapper1 = new ObjectMapper();
//        System.out.println(mapper1.writeValueAsString(dto));
//        System.out.println(mapper.writeValueAsString(dto));
//        System.out.println(writer.writeValueAsString(dto));
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    }
//    long end = System.currentTimeMillis();
//    System.out.println("time: " + (end - start) + " ms");
  }

  @Data
  public static class Domain {

  }

  @Data
  public static class DO {

  }
  @Data
  @JsonIgnoreProperties({"settle_price"})
//  @JsonSerialize(using = SpecifiedSerializer.class)
  @JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
  public static class NapiDTO {

    private int id;
    private String name;
    @JsonIgnore
    private long settlePrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date gmtUpdate;


    @JsonGetter
    public boolean isOnSale() {
      Date now = new Date();
      return now.after(this.gmtCreate);
    }

//    @JsonUnwrapped
    private Extend extend;

    private Status status;
  }

  @Data
  public static class Extend {
    private String desc;
    private List<String> pic;
  }

  public static class SpecifiedSerializer extends JsonSerializer<NapiDTO> {
    @Override
    public void serialize(NapiDTO value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      jgen.writeStartObject();
      jgen.writeNumberField("id", value.getId());
      jgen.writeStringField("name", value.getName());
      jgen.writeEndObject();
    }
  }

  public enum Status {
    UNKNOWN(1),
    AVAILABLE(2),
    DELETED(3),
    ;

    private final int value;
    Status(int value) {
      this.value = value;
    }

    @JsonCreator
    public static Status of(int value) {
      for (Status s : Status.values()) {
        if (s.value() == value) {
          return s;
        }
      }
      return UNKNOWN;
    }

    @JsonValue
    public int value() {
      return value;
    }
  }
}
