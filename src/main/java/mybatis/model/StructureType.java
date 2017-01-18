package mybatis.model;

/**
 * @author chuck
 * @since 18/01/2017
 */
public enum StructureType {
  INVALID(-1, "无效类型"),
  ROOT(1, "父出库单"),
  SUB(2, "子出库单");

  public final int value;
  public final String desc;

  StructureType(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public static StructureType of(int value) {
    StructureType[] var1 = values();
    int var2 = var1.length;

    for(int var3 = 0; var3 < var2; ++var3) {
      StructureType type = var1[var3];
      if(type.value == value) {
        return type;
      }
    }

    return INVALID;
  }
}
