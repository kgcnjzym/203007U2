package com.xt.factory;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/24 10:04
 * @since V1.00
 */
public class XmlBeanFactory {
    private static Map<String,Object> objects;
    static {
        objects=new HashMap<>();
        SAXBuilder builder=new SAXBuilder();
        InputStream is=null;
        try{
            is=XmlBeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
            Document doc=builder.build(is);
            Element root=doc.getRootElement();
            List beans=root.getChildren("bean");
            //对象创建
            for(Object obj:beans){
                Element bean=(Element)obj;
                String key=bean.getAttributeValue("id");
                String value=bean.getAttributeValue("class");
                Object temp=Class.forName(value).newInstance();
                objects.put(key,temp);
            }
            //对象装配
            for(Object obj:beans){
                Element bean=(Element)obj;
                Object src=objects.get(bean.getAttributeValue("id"));
                List props=bean.getChildren("property");
                if(props==null || props.size()==0){
                    continue;
                }
                for(Object p:props){
                    Element prop=(Element)p;
                    String name=prop.getAttributeValue("name");
                    String ref=prop.getAttributeValue("ref");
                    Object target=objects.get(ref);
                    Class<?> clz=src.getClass();
                    Method []mths=clz.getMethods();
                    String mthName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    for(int i=0;i<mths.length;i++){
                        if(mths[i].getName().equals(mthName)){
                             mths[i].invoke(src,target);
                             break;
                        }
                    }
                }

            }
            System.out.println("ok");

        }catch (Exception ex){
            ex.printStackTrace();

        }
        finally {
            try{
                is.close();
            }catch (Exception ex){}
        }
    }

    public static <T> T getObject(Class<T> cls){
        for(Object obj:objects.values()){
            if(obj.getClass()==cls){
                return (T)obj;
            }
        }
        return null;
    }

    public static Object getObject(String name){
        return objects.get(name);
    }
}
