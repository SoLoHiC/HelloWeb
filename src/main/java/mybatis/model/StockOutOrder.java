package mybatis.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
//  private Warehouse whId;
//  private StockOutOrderType orderType;
//  private StructureType structureType;
  private long operatorId;
//  private StockOutOrderStatus status;
//  private SrcOrderType srcOrderType;
  private String srcOrderId;
  private int skuId;
  private int quantity;
  private String outerItemName;  // 由运营填写的商品名, 和商品库商品不一定对应
  private String receiverName;
  private String receiverTel;
  private String receiverIdCard;
  private String province;
  private String city;
  private String district;
  private String road;
  private Date gmtPush;
  private String logisticsName;
  private String logisticsTicket;
  private Date gmtSend;
  private Date gmtCreate;
  private Date gmtUpdate;

  private List<StockOutOrder> subOrders = Collections.emptyList();
}
