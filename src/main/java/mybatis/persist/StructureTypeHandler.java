package mybatis.persist;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mybatis.model.StructureType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author chuck
 * @since 18/01/2017
 */
public class StructureTypeHandler implements TypeHandler<StructureType> {

  @Override
  public void setParameter(PreparedStatement ps, int i, StructureType parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setInt(i, parameter.value);
  }

  @Override
  public StructureType getResult(ResultSet rs, String columnName) throws SQLException {
    return StructureType.of(rs.getInt(columnName));
  }

  @Override
  public StructureType getResult(ResultSet rs, int columnIndex) throws SQLException {
    return StructureType.of(rs.getInt(columnIndex));
  }

  @Override
  public StructureType getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return StructureType.of(cs.getInt(columnIndex));
  }
}
