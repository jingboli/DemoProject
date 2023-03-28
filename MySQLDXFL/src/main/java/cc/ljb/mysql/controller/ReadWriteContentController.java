package cc.ljb.mysql.controller;


import cc.ljb.mysql.entity.ReadWriteContentEntity;
import cc.ljb.mysql.service.ReadWriteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReadWriteContentController {
    @Autowired
    ReadWriteContentService readWriteContentService;

    @GetMapping("/query")
    public ReadWriteContentEntity getContent(@RequestParam int id) {
        return readWriteContentService.getContent(id);
    }

    @GetMapping("/write")
    public int writeContent() {
        return readWriteContentService.writeContent();
    }

    @GetMapping("/write2")
    public int writeContent2() {
        return readWriteContentService.write2Content();
    }
}
