package burp;

import java.awt.Component;
import java.io.PrintWriter;

public class BurpExtender implements IBurpExtender{
    private IBurpExtenderCallbacks callbacks;
    private IExtensionHelpers helpers;
    private PrintWriter stdout;
    private PrintWriter stderr;
	private String extensionName = "HTTPHeadModifer";
	private String version ="1.1";

    
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)
    {
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        this.stdout = new PrintWriter(callbacks.getStdout(),true);
        this.stderr = new PrintWriter(callbacks.getStderr(),true);
        
        callbacks.setExtensionName(String.format("%s v%s", extensionName,version));
        callbacks.registerContextMenuFactory(new Menu(callbacks));
        stdout.println(getBanner());
    }
    
	public String getBanner(){
		String bannerInfo = 
				    "[+]\n"
				  + "[+] #####################################\n"
				  + "[+]    " + extensionName + " v" + version +"\n"
				  + "[+]    anthor: huoxingren\n"
				  + "[+]    email:  huoxingren@out.com\n"
				  + "[+] ####################################";
		return bannerInfo;
	}
}
