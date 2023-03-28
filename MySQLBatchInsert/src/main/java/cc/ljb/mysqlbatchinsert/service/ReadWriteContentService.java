package cc.ljb.mysqlbatchinsert.service;


import cc.ljb.mysqlbatchinsert.entity.ReadWriteContentEntity;
import cc.ljb.mysqlbatchinsert.mapper.ReadWriteContentMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ReadWriteContentService {
    private static final int INSERT_NUM = 1000000;

    private static final int im_size = 1000;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private ReadWriteContentMapper readWriteContentMapper;

    public int writeContent(int id) {
        ReadWriteContentEntity content = new ReadWriteContentEntity();
        content.setAuthor("ssz");
        content.setName("ljb");
        content.setTitle("Write-Content");
        return readWriteContentMapper.writeContent(content);
    }

    public int write2Content() {
        ReadWriteContentEntity content = new ReadWriteContentEntity();
        content.setAuthor("ssz");
        content.setName("ljb");
        content.setTitle("Write-Content");
        return readWriteContentMapper.writeContent(content);
    }

    public String writeSingle() {
        System.out.println("writeSingle()");
        List<ReadWriteContentEntity> entityList = createData();

        long start = System.currentTimeMillis();
        entityList.forEach(entity -> readWriteContentMapper.writeContent(entity));
        System.out.println("writeSingle() duration : " + (System.currentTimeMillis() - start));
        return "success";

    }


    public String writeForeach() {
        System.out.println("writeForeach()");
        List<ReadWriteContentEntity> entityList = createData();

        long start = System.currentTimeMillis();
        List<ReadWriteContentEntity> list1000 = new ArrayList<>();
        int i = 1;
        if (!entityList.isEmpty()) {
            int size = entityList.size();
            for (ReadWriteContentEntity content : entityList) {
                list1000.add(content);
                if ((i % im_size == 0) || i == size) {
                    readWriteContentMapper.batchInsert(list1000);
                    list1000.clear();
                }
                i++;
            }
        }
        System.out.println("writeForeach() duration : " + (System.currentTimeMillis() - start));
        return "success";

    }

    private List<ReadWriteContentEntity> createData() {
        List<ReadWriteContentEntity> entityList = new ArrayList<>();
        ReadWriteContentEntity content;
        for (int i = 0; i < INSERT_NUM; i++) {
            content = new ReadWriteContentEntity();
            content.setAuthor("ssz");
            content.setName("ljb");
            content.setTitle("Write-Content");
            content.setAge("18");
            content.setAddress("未知");
            content.setClassId("1");
            entityList.add(content);
        }
        return entityList;
    }

    public String writeBatchMybatis() {
        System.out.println("writeBatchMybatis()");
        List<ReadWriteContentEntity> entityList = createData();

        long start = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            ReadWriteContentMapper mapper = sqlSession.getMapper(ReadWriteContentMapper.class);
            List<ReadWriteContentEntity> list1000 = new ArrayList<>();
            int i = 1;
            if (!entityList.isEmpty()) {
                int size = entityList.size();
                for (ReadWriteContentEntity content : entityList) {
                    list1000.add(content);
                    if ((i % im_size == 0) || i == size) {
                        list1000.forEach(mapper::writeContent);
                        sqlSession.commit();
                        list1000.clear();
                    }
                    i++;
                }
            }
        } finally {
            sqlSession.close();
        }
        System.out.println("writeBatchMybatis() duration : " + (System.currentTimeMillis() - start));
        return "success";
    }

}
