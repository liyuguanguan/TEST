package web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Je on 2016/11/17.
 */
public class LoadUploadFileServlet extends HttpServlet {

    private String uploadPath;
    private String configFile = "config.properties";
    private String remoteHost = "http://tms.gie360.com/upload/";

    @Override
    public void init() throws ServletException {
        Resource resource = new ClassPathResource(configFile);
        Properties props = null;
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
            this.uploadPath = props.getProperty("upload.path");
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();


        OutputStream os = response.getOutputStream();
        File file = new File(uploadPath,pathInfo);

        if(file.exists()) {
            FileInputStream fips = new FileInputStream(file);
            byte[] btImg = readStream(fips);
            os.write(btImg);
            os.flush();
        }else{
            String url = pathInfo;
            URL uri = new URL(remoteHost+url);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            if(connection.getResponseCode()==HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                byte[] btImg = readStream(in);
                os.write(btImg);
                os.flush();
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

    /**
     * 读取管道中的流数据
     */
    public byte[] readStream(InputStream inStream) {
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        int data = -1;
        try {
            while((data = inStream.read()) != -1){
                bops.write(data);
            }
            return bops.toByteArray();
        }catch(Exception e){
            return null;
        }
    }
}