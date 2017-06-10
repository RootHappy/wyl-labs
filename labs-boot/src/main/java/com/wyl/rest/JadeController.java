package com.wyl.rest;

import com.wyl.model.Book;
import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.template.JadeTemplate;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created bygyunlong on 17/5/26.
 */
@RequestMapping(value = "/jade")
@RestController
public class JadeController {

    @RequestMapping(value = "/index1")
    public ModelAndView index1() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70f, true));
        books.add(new Book("Life, the Universe and Everything", 560f, false));
        books.add(new Book("The Restaurant at the End of the Universe", 5.40f, true));

        ModelAndView mv = new ModelAndView("index.jade");
        mv.addObject("books", books);
        mv.addObject("pageName", "My Bookshelf");

        return mv;
    }

    @RequestMapping(value = "/index2")
    public String index2() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70f, true));
        books.add(new Book("Life, the Universe and Everything", 560f, false));
        books.add(new Book("The Restaurant at the End of the Universe", 5.40f, true));
        Map<String, Object> model = new HashedMap();
        model.put("books", books);
        model.put("pageName", "My Bookshelf");
        String html = "test";
        try {
            JadeTemplate template = Jade4J.getTemplate("/Users/wangyunlong/self/repo/wyl-labs/labs-boot/src/main/resources/templates/index.jade");
            html = Jade4J.render(template, model);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }

}
