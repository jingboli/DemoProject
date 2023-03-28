package cc.ljb.mysql.mapper;

import cc.ljb.mysql.entity.ReadWriteContentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReadWriteContentMapper {
    ReadWriteContentEntity getContent(@Param("id") int id);

    int writeContent(@Param("entity") ReadWriteContentEntity content);

}
