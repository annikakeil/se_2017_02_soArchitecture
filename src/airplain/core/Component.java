package airplain.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class Component {
    //Wheel wheel = Wheel.getInstance();
    // Port p = wheel.port;
    // p.setBrake();

    private String fileSeparator = System.getProperty("file.separator");
    private String userDirectory = System.getProperty("user.dir");
    private String jarFileName = "Wheel.jar"; // TODO Component name auswerten

    private Class clazz;

    public Component(String componentName) {
        loadJar(componentName);
    }

    public void loadJar(String componentName) {
        try {
            URL[] urls = {new File(getPathToJar()).toURI().toURL()}; // URL Generieren
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Component.class.getClassLoader()); // JAR File mit Classload laden
            clazz = Class.forName(componentName, true, urlClassLoader); // Klasse laden
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private Object getInstance() {
        try {
            return clazz.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object getPort() {
        try {
            return clazz.getDeclaredField("port").get(getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean setBrake() {
        try {
            Object port = getPort();
            Method method = port.getClass().getMethod("setBrake");
            return (Boolean) method.invoke(port);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean releaseBreak() {
        try {
            Object port = getPort();
            Method method = port.getClass().getMethod("releaseBreak");
            return (Boolean) method.invoke(port);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getVersion() {
        Object instance = getInstance();
        try {
            Method getVersion = getVersion = instance.getClass().getMethod("getVersion");
            return (String) getVersion.invoke(instance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String getPathToJar() {
        String componentNumber = "01";
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(userDirectory + fileSeparator + "component.props");
            properties.load(fileInputStream);
            fileInputStream.close();
            componentNumber = properties.getProperty("componentType");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userDirectory + fileSeparator + "exchange_component_" + componentNumber + fileSeparator + jarFileName;
    }
}
