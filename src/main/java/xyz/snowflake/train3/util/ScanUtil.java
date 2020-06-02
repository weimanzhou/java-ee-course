package xyz.snowflake.train3.util;

import xyz.snowflake.train3.annotation.Dao;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

/**
 * @author snowflake
 * @create-date 2020-04-19 15:24
 */
public class ScanUtil {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Class clazz = Class.forName("xyz.snowflake.train3.dao.StudentDao");

        Annotation[] annotations = clazz.getAnnotations();
        clazz.getAnnotation(Dao.class);

        AnnotatedType[] annotationTypes =  clazz.getAnnotatedInterfaces();
        for (AnnotatedType annotatedType : annotationTypes) {
            System.out.println(annotatedType);
        }
        System.out.println();
        System.out.println(clazz.getAnnotatedSuperclass());
        System.out.println("===");
        System.out.println(annotations.length);
        if (annotations.length > 0) {
            System.out.println(annotations);
        }

//        Path path = Paths.get("classpath:xyz.snowflake.train3");
//        System.out.println(path.getFileName());

        // 获取类加载的根路径
//        String path = ScanUtil.class.getResource("/").getPath();
//
//        File file = new File(path);
//        Method[] methods = file.getClass().getMethods();
//        for (Method method : methods) {
//            if (method.getParameterCount() == 0) {
//                Object obj = method.invoke(file);
//                System.out.println(method.getName() + ":" + obj);
//            }
//        }


//        List<String> paths = new ArrayList<>();
//        scan(path, paths);
//        paths.stream()
//                .peek(e -> {
//                    try {
//                        Class clazz = Class.forName(e.substring("E:\\GITHUB\\java-ee-zp\\target\\classes\\".length(), e.indexOf("."))
//                                .replaceAll("^[\\/]$", "."));
//                        Annotation[] annotations = clazz.getAnnotations();
//                        for (Annotation annotation : annotations) {
//                            String typeName = annotation.annotationType().getTypeName();
//                            System.out.println(typeName);
//                        }
//                    } catch (ClassNotFoundException e1) {
//                        e1.printStackTrace();
//                    }
//                }).collect(Collectors.toList());
    }

    public static void scan(String path, List<String> paths) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File tmpFile : Objects.requireNonNull(files)) {
            if (tmpFile.isDirectory()) {
                if (Objects.requireNonNull(tmpFile.listFiles()).length > 0) {
                    scan(tmpFile.getAbsolutePath(), paths);
                }
            } else if (tmpFile.isFile() && tmpFile.getAbsolutePath().endsWith("class") ){
                paths.add(tmpFile.getAbsolutePath());
            }
        }
    }

}
