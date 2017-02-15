
rxjava + retrofit + okHttp 进行 get post download 操作

1.在Application中进行初始化 --->为了让网络模块更加独立,也就是解耦合
     RxRetrofitApp.init(this);
     
2.创建一个BaseApi 的子类 该类是"请求数据统一封装类"

3.创建自己的javabean

4.就可以使用了




-----------------------------------------------------------
在gradle中配置

app下
1.  apply plugin: 'org.greenrobot.greendao'
2.  /***** retrofit + rxJava 网络请求****/
    compile 'org.greenrobot:greendao:3.2.0'
    /*rx-android-java*/
    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
    compile 'com.trello:rxlifecycle:1.0'
    compile 'com.trello:rxlifecycle-components:1.0'
    /*rotrofit*/
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
    compile 'com.squareup.okhttp3:logging-interceptor:3.4.1'//日志输出
    /******************************/
    
 project下
  1.  classpath 'org.greenrobot:greendao-gradle-plugin:+'
  2. 有必要就加上  mavenCentral() 
