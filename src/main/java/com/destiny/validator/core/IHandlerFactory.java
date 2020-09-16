package com.destiny.validator.core;

import com.destiny.validator.handler.HandlerAdapter;
import com.destiny.validator.handler.IHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IHandlerFactory implements ApplicationContextAware, InitializingBean{

    // key:注解类 value：处理类的beanName
    private Map<Class<? extends Annotation>, IHandler> handlerMap = new ConcurrentHashMap<>(16);

    private Map<String, IHandler> handlerBeanMap = new ConcurrentHashMap<>(16);

    private List<HandlerAdapter> handlerAdapterList = new ArrayList<>();

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public IHandler getHandler(Class<? extends Annotation> clazz) {
        IHandler handler = null;
        if (handlerMap.containsKey(clazz)){
            handler = handlerMap.get(clazz);
        }else{
            String className = clazz.getSimpleName();
            String name = className.substring(0,1).toLowerCase() +
                    className.substring(1)+ "Handler";
            if (handlerBeanMap.containsKey(name)){
                handler = handlerBeanMap.get(name);
                handlerMap.put(clazz, handler);
            }
        }
        return handler;
    }

    public void setHandlerMap(Class<? extends Annotation> clazz, IHandler handler) {
        handlerMap.put(clazz, handler);
    }

    private void init(){
        handlerBeanMap = ctx.getBeansOfType(IHandler.class);
        Iterator<Map.Entry<String, IHandler>> iterator = handlerBeanMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, IHandler> entry = iterator.next();
            if (HandlerAdapter.class.isAssignableFrom(entry.getValue().getClass())){
                HandlerAdapter handlerAdapter = (HandlerAdapter) entry.getValue();
                Class<? extends Annotation> customAnnotation = handlerAdapter.getCustomAnnotation();
                handlerMap.put(customAnnotation,handlerAdapter);
                iterator.remove();
            }
        }
        for (Map.Entry entry: handlerBeanMap.entrySet()){

        }
        System.out.println(handlerMap);
    }
}
