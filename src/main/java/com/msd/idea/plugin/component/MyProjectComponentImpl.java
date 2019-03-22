package com.msd.idea.plugin.component;

import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.msd.idea.plugin.LanguageIcons;

import java.io.*;
import java.util.*;


public class MyProjectComponentImpl implements MyProjectComponent {

    public static List<LookupElementBuilder> list = new ArrayList<>();
    public static Map<String, String> map = new HashMap<>();
    public static Set<String> onStandard = new TreeSet<>();


    private Project project;

    public MyProjectComponentImpl(Project project){
        this.project = project;
    }


    @Override
    public void projectOpened() {
//        ProjectRootManager manager = ProjectRootManager.getInstance(project);
//        VirtualFile[] vFiles = ProjectRootManager.getInstance(project).getContentRoots();
//
//        for (VirtualFile vFile : vFiles) {
//            System.out.println(vFile.getName());
//        }


        readUserFile();
    }

    @Override
    public void initComponent() {

    }


    private void readUserFile(){
        //1.读取项目目录下的配置文件
        String projectPath = project.getBasePath();
        File file = new File(projectPath, ".msd.languages");
        if(!file.exists()){
            //System.out.println(".msd.languages 文件不存在");
        }

        //2.读取user home 配置文件

        //3.读取res目录下的资源文件

        try {
            //InputStream isr = virtualFile.getInputStream();
            InputStream isr = MyProjectComponentImpl.class.getResourceAsStream("/languages.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(isr, "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null){
                String result = line.trim();
                list.add(LookupElementBuilder.create(result).withIcon(LanguageIcons.FILE).withTypeText("标准词语"));
                map.put(result, line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static List<LookupElementBuilder> getList(){
        return list;
    }

    public static boolean isExist(String value){
        return map.get(value) != null;
    }

    public static void addNonstandard(String value){
        onStandard.add(value);
    }


    public static String getNonstandard(){
        StringBuffer sb = new StringBuffer();
        for (String s : onStandard) {
            sb.append(s);
            sb.append("\n");
        }

        return sb.toString();
    }
}
