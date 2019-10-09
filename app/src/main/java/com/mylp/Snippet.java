package com.mylp;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

public class Snippet {
	public int getSignature(String packageName) {        
	        PackageManager pm = this.getPackageManager();  
	        PackageInfo pi = null;  
	        int sig = 0;  
	        try {  
	            pi = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);  
	            Signature[] s = pi.signatures;  
	            sig = s[0].hashCode();    
	        } catch (Exception e1) {  
	            sig = 0;  
	            e1.printStackTrace();  
	        }  
	        return sig;  
	    }

	private PackageManager getPackageManager() {
		// TODO Auto-generated method stub
		return null;
	}  
	
}

