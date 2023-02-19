import java.io.File;

/**
 * @BelongsProject: springmvc_demo1
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-25 17:06
 * @Description:
 */
public class demo {
    public static void main(String[] args) {
        System.out.println (System.getProperty ( "user.dir" ));
        String path2=System.getProperty ( "user.dir" )+"\\src\\main\\webapp\\upload";
        System.out.println (path2);
        File file=new File ( path2 );
        if (!file.exists ()){
            file.mkdirs ();
        }
    }
}
