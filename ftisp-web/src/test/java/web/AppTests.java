package web;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.IOException;
import java.net.ServerSocket;

public class AppTests {
    public static String context = "/ftisp";

    public static String webAppPath = "ftisp-web/src/main/webapp";

    public static String defaultsDescriptor = "ftisp-web/src/test/resources/webdefault.xml";

    public static int port = 8001;

    public static void main(String[] args) {

        try {
            while (testPort(port)) {
                port++;
            }
            //if (testPort(port)) {
            //    throw new BindException("The port:: [" + port + "]  " + "is already in Use...");
            //}

            Server server = new Server(port);
            WebAppContext webContext = new WebAppContext(webAppPath, context);

            webContext.setDefaultsDescriptor(defaultsDescriptor);

            webContext.setClassLoader(Thread.currentThread().getContextClassLoader());

            ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
            servletContextHandler.setContextPath("/upload");
            servletContextHandler.addServlet(new ServletHolder(new LoadUploadFileServlet()),"/*");

            HandlerList handlers = new HandlerList();
            handlers.setHandlers(new Handler[] { servletContextHandler, webContext });
            server.setHandler(handlers);

            server.setStopAtShutdown(true);

            server.start();
            while (true) {
                char c = (char) System.in.read();
                if (c == '\n') {
                    reloadContext(server);
                }
            }

        } catch (Exception e) {
            System.err.print(e.toString());
        }
    }

    public static void reloadContext(Server server) throws Exception {
        HandlerList handlers = (HandlerList) server.getHandler();
        System.out.println("[INFO] Application reloading");

        for (Handler handler : handlers.getHandlers()) {
            if(handler instanceof WebAppContext){
                handler.stop();

                //handler.setClassLoader(Thread.currentThread().getContextClassLoader());
                handler.start();
            }
        }

        System.out.println("[INFO] Application reloaded");
    }

    private static boolean testPort(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            ss.close();
            return false;
        } catch (IOException e) {
            return true;
        }
    }

}
