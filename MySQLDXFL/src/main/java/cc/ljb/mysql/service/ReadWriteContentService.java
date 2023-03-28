package cc.ljb.mysql.service;


import cc.ljb.mysql.entity.ReadWriteContentEntity;
import cc.ljb.mysql.mapper.ReadWriteContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadWriteContentService {
    @Autowired
    private ReadWriteContentMapper readWriteContentMapper;

    public ReadWriteContentEntity getContent(int id) {
        return readWriteContentMapper.getContent(id);
    }

    public int writeContent() {
        ReadWriteContentEntity content = new ReadWriteContentEntity();
        content.setAuthor("ssz");
        content.setName("ljb");
        content.setTitle("Write-Content");

        return readWriteContentMapper.writeContent(content);
    }

    public int write2Content() {
        getContent(1);
        ReadWriteContentEntity content = new ReadWriteContentEntity();
        content.setAuthor("ssz");
        content.setName("ljb");
        content.setTitle("Write-Content");

        return readWriteContentMapper.writeContent(content);
    }

}
