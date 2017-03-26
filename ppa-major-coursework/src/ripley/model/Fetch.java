package ripley.model;

import api.ripley.Ripley;

public class Fetch {

	String privateKey = "10tLI3GWut+yVD6ql2OMtA==";
	String publicKey = "tBgm4pVo/g/VqL46EnH7ew==";
	
	Ripley ripley = new Ripley(privateKey, publicKey);
	
	public Fetch() {
		initialise();
	}
	
	public void initialise() {
		Double version = ripley.getVersion();
		String acknowledgement = ripley.getAcknowledgementString();
	}
}
