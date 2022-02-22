import com.aye10032.tctodolist.util.ProfileUtil;

/**
 * @program: TCTodoList
 * @className: testdecode
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/21 下午 11:25
 */
public class testdecode {

    public static void main(String[] args) {
        String url = ProfileUtil.base642Url(ProfileUtil.getProfile(ProfileUtil.getUUID("Aye10032")));
//        System.out.println(ProfileUtil.downloadFromUrl(url, "Aye10032"));
        ProfileUtil.getAvatar(url, "Aye10032");
    }

}
