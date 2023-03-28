package cc.ljb.mysqlbatchinsert.controller;



import cc.ljb.mysqlbatchinsert.service.ReadWriteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReadWriteContentController {
    @Autowired
    ReadWriteContentService readWriteContentService;

    @GetMapping("/insert/single")
    public String insertSingle() {
        return readWriteContentService.writeSingle();
    }

    @GetMapping("/insert/sql/foreach")
    public String insertBatch() {
        return readWriteContentService.writeForeach();
    }

    @GetMapping("/insert/batch")
    public String insertBatchMybaits() {
        return readWriteContentService.writeBatchMybatis();
    }
}
