
import java.awt.Desktop;
import java.net.URL;

import javax.swing.JOptionPane;

import com.dropbox.client2.*;
import com.dropbox.client2.session.*;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession.WebAuthInfo;

public class DropboxAuth {
    private static final String APP_KEY = "3i68ponran99de8";         
    private static final String APP_SECRET = "d0uuxr4cpbb5mho";        
    private static final AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
    private static DropboxAPI<WebAuthSession> mDBApi;
 
    public static void main(String[] args) throws Exception {
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE);
        WebAuthInfo authInfo = session.getAuthInfo();
 
        RequestTokenPair pair = authInfo.requestTokenPair;
        String url = authInfo.url;
        System.out.println(url);
        
        Desktop.getDesktop().browse(new URL(url).toURI());
        
        JOptionPane.showMessageDialog(null, "Press ok to continue once you have authenticated.");
        session.retrieveWebAccessToken(pair);
 
       
        AccessTokenPair tokens = session.getAccessTokenPair();
        System.out.println("Use this token pair in future so you don't have to re-authenticate each time:");
        System.out.println("Key token: " + tokens.key); 	
        System.out.println("Secret token: " + tokens.secret);	
        Actualizador
 

       
        mDBApi = new DropboxAPI<WebAuthSession>(session);
        DropboxAPI.Account account = mDBApi.accountInfo();
        System.out.println("User Name: " + account.displayName);
    }
}