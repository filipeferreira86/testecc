package telas;

import com.jagacy.util.JagacyException;

import Session.Session;
import fields.EntryField;
import fields.LabelField;
 
public class MenuPrin {
	
	Session session;
	LabelField lblMenu;
	EntryField iptPgm = new EntryField(19, 8);
	
	
	public boolean resEsp(Session s, String lblm, int linha, int col) throws JagacyException {
		this.session = s;
		lblMenu = new LabelField(linha, col, lblm);
		if(!session.waitForTextLabel(lblMenu)) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public String valor(int linha, int coli, int tam) throws JagacyException {
		String resultado = "";		
		if(!session.readPosition(linha, coli, tam).trim().equals("")) {
			resultado = session.readPosition(linha, coli, tam).trim();
		}
		
		return resultado;
	}

}
