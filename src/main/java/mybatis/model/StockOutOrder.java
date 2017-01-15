package mybatis.model;

import java.io.Serializable;
import lombok.Data;

/**
 * @author chuck
 * @since 15/01/2017
 */
@Data
public class StockOutOrder implements Serializable {

  private static final long serialVersionUID = 8112249731080395278L;

  private int id;
  private String bundleId;
}
