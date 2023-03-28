package cc.ljb.mysqlbatchinsert.mapper;


import cc.ljb.mysqlbatchinsert.entity.ReadWriteContentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReadWriteContentMapper {

    int writeContent(@Param("entity") ReadWriteContentEntity content);

    int batchInsert(List<ReadWriteContentEntity> entityList);

}
