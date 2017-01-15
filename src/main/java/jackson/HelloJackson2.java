package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

/**
 * @author chuck
 * @since 9/30/16
 */
public class HelloJackson2 {

  public static void testConvert() {
    Eg eg = new Eg();
    eg.setId(123);
    eg.setName("23r2");
    eg.setCreatedAt(new Date());
    eg.setStatus(Eg.EgStatus.IN_USE);
    Eg.EgInner inner = new Eg.EgInner();
    inner.setId(432);
    inner.setName("239r900");
    inner.setPrice(203);
    eg.setInner(inner);

    ObjectMapper objectMapper = new ObjectMapper();
    EgDto egDto = objectMapper.convertValue(eg, EgDto.class);

    System.out.println(eg);
    System.out.println(egDto);
  }
  public static void main(String[] args) {
    testConvert();
  }
}
