package app;

import com.google.common.hash.Hashing;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static spark.Spark.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static spark.debug.DebugScreen.*;

public class Application { //port 4567 default
    private Logger log = LoggerFactory.getLogger(Application.class); //log.debug("..."); 
                                                                    //log.info("Some object: {}", object);
                                                                    //log.error("Error during some job!!", e);
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> urls = new ConcurrentHashMap<String, String>();
        
        enableDebugScreen();
        port(8087);
        
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Application.class, "/templates/"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
        
        staticFileLocation("/static");
        staticFiles.expireTime(600L);
       
//        get("/hello/:name", (request, response) -> {  // пример как достать :name через request.params(":name");
//        return "Hello: " + request.params(":name");
//        });
//        customize 404 TODO :)
//        
        get("/", (request, response) -> {  //simple without html
        Map<String, Object> model = new HashMap<>();
        model.put("name", "Freemarker");
        return freeMarkerEngine.render(new ModelAndView(model, "main.ftl"));
        });
        

//        get("/shortener", (request, response) -> {
//            String shortURL = "http://localhost/" +
//                    Hashing.murmur3_32().hashString(request.queryParams("url"), StandardCharsets.UTF_8).toString();
//            Map<String, Object> model = new HashMap<>();
//            if(!urls.containsKey(shortURL)) {
//                model.put("url", shortURL);
//                urls.put(shortURL, request.queryParams("url"));
//                return freeMarkerEngine.render(new ModelAndView(model, "shortener.ftl"));
//            }
//            model.put("url", shortURL);
//            return freeMarkerEngine.render(new ModelAndView(model, "shortener.ftl"));
//        });
        //get("/:url", (request, response) -> {
        //    if(urls.containsKey(request.url()))
        //        response.redirect(urls.get(request.url()));
        //    response.redirect("/");
        //    return null;
        //});
    }
}