package local.sample.template;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerWriter {
    private final Configuration freemarkerConfig;

    public FreeMarkerWriter(final Configuration freemarkerConfig) {
        this.freemarkerConfig = freemarkerConfig;
    }

    public void run() {

        Student s1 = new Student();
        s1.setId("id1");
        s1.setName("name1");

        Student s2 = new Student();
        s2.setId("id2");
        s2.setName("name2");

        Student s3 = new Student();
        s3.setId("id3");
        s3.setName("name3");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Map<String, Object> data = new HashMap<>();
        data.put( "students", students );

        Writer writer = null;
        Template template;
        try {
            template = freemarkerConfig.getTemplate("report.ftl");
            writer = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("report.html")));
            template.process(data, writer);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
           try {
               if (writer != null) {
                   writer.flush();
                   writer.close();
               }
           } catch (Exception ignore) {}
        }
    }
}
