package kapitel12.kontaktliste;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class VReader extends FilterReader {

	protected VReader(Reader in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		return super.read()-1;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		
		int result = super.read(cbuf, off, len); 
		for( int i = 0;i<result;i++){
			cbuf[i+off] = (char)((int)(cbuf[i+off])-1);
		}
		return result;
	}
	
	

}
