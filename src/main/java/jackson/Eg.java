package jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
public class Eg implements Serializable {

  private static final long serialVersionUID = 6567132173883472490L;

  private int id;
  private String name;
  private EgStatus status;
  private EgInner inner;
  private Date createdAt;

  public enum EgStatus {
    NOT_IN_USE(0, "not in use"),
    IN_USE(1, "in use"),
    INVALID(-1, "invalid"),
    ;

    public final int value;
    public final String desc;

    EgStatus(int value, String desc) {
      this.value = value;
      this.desc = desc;
    }

    @JsonCreator
    public static EgStatus of(int value) {
      for (EgStatus status : EgStatus.values()) {
        if (status.value == value) {
          return status;
        }
      }
      return INVALID;
    }

    @JsonValue
    public int value() {
      return value;
    }

    public String desc() {
      return desc;
    }
  }

  @Data
  @NoArgsConstructor
  public static class EgInner implements Serializable {

    private static final long serialVersionUID = -131553701828238315L;

    int id;
    String name;
    double price;
  }
}
