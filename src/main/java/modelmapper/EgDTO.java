package modelmapper;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chuck
 * @since 9/30/16
 */
@Data
@NoArgsConstructor
public class EgDTO implements Serializable {

  private static final long serialVersionUID = 2021682061681218950L;

  private int id;
  private String name;
  private int status;
  private EgInnerDTO inner;
  private Date createdAt;

  @Data
  @NoArgsConstructor
  public class EgInnerDTO implements Serializable {

    private static final long serialVersionUID = -131553701828238315L;

    int id;
    String name;
    double price;
  }
}
