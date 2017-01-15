package modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.Date;

/**
 * @author chuck
 * @since 9/30/16
 */
public class HelloModelMapper {

  public static void testBasicModelMapper() {
    Eg eg = new Eg();
    eg.setId(123);
    eg.setName("23r2");
    eg.setCreatedAt(new Date());
    eg.setStatus(Eg.EgStatus.IN_USE);
    Eg.EgInner inner = new Eg.EgInner();
    inner.setId(432);
    inner.setName("239r900");
    inner.setPrice(203);

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.addMappings(new PropertyMap<Eg, EgDTO>() {
      @Override
      protected void configure() {
        map().setStatus(source.getStatus().value);
      }
    });

    EgDTO egDTO = modelMapper.map(eg, EgDTO.class);
    System.out.println(eg);
    System.out.println(egDTO);
  }

  public static void main(String[] args) {
    testBasicModelMapper();
  }
}
