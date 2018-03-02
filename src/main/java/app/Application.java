package app;
import app.utils.*;
import static spark.Spark.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static spark.debug.DebugScreen.*;
import app.controllers.*;
public class Application {
    private Logger log = LoggerFactory.getLogger(Application.class); //log.debug("..."); 
                                                                    //log.info("Some object: {}", object);
                                                                    //log.error("Error during some job!!", e);
    public static void main(String[] args) {
        port(4567);
        staticFileLocation("/static");
        staticFiles.expireTime(600L);
        enableDebugScreen();
        // Set up before-filters (called before each get/post)
        before("*",                  Filters.addTrailingSlashes);
        //before("*",                  Filters.handleLocaleChange);
        get(Path.Web.INDEX,                IndexController.serveIndexPage);
        get("*",                     ViewUtil.notFound);
        //Set up after-filters (called after each get/post)
        //after("*",                   Filters.addGzipHeader);

//        get("/hello/:name", (request, response) -> {  // пример как достать :name через request.params(":name");
//        return "Hello: " + request.params(":name");
//        });
    }
}