#### 项目说明
    公司开发的软件都标配多语言版本，多语言变词条是在后台数据库维护了一张语言表，将中文及多国语言进行自定义配置
    为了帮助开发人员在写代码时使用标准词条，并自动提示词条而开发本插件。
    目前插件中的中文词条是写在java包中的一个txt文件中，后续会改为调用web接口，并收集没有维护的标准词语做上传收集.


#### 使用环境
    IntelliJ IDEA 171及以上，如果要在android studio中使用则需要将 META-INF/plugin.xml中 
    屏蔽 <depends>JavaScript</depends> 再重新打包.
    目前仅支持 java、jsp、javascript、html、xml文件中输入字符串的地方弹出提示.
    如果不能自动提示，可以使用快捷键触发 Completion

#### 演示示例
<img src='https://github.com/XieZhiFa/intelliJ-plugin-StandardWords/blob/master/gif/java.gif?raw=true' alt='示例'/>

#### 技术支持
    QQ 2227421573
    QQ群 192585477



