package mybatis.persist;

import mybatis.model.StockOutOrder;

/**
 * @author chuck
 * @since 15/01/2017
 */
public interface StockOutOrderMapper {

  StockOutOrder findById(int id);
}
