package com.cn.generator.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: baas_project
 * @description:
 * @author: lmm
 * @create: 2020-06-03 17:54
 **/
@Component
@Slf4j
public class PropertyInitUtil {
    private static Properties props;
    static {
        loadProps();
    }
    synchronized static private void loadProps() {
        props = new Properties();
        InputStream in = null;
        try {

            in = PropertyInitUtil.class.getClassLoader().
                    getResourceAsStream("application.yml");
            props.load(in);
        } catch (FileNotFoundException e) {
            log.error("properties not found!");
        } catch (IOException e) {
            log.error("IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("properties close Exception!");
            }
        }

    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

}
