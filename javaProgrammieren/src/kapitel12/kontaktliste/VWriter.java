package kapitel12.kontaktliste;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class VWriter extends FilterWriter {

	protected VWriter(Writer out) {
		super(out);
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for(int i = 0;i<len;i++){
			write(cbuf[off+i]);
		}
	}

	@Override
	public void write(int c) throws IOException {		
		super.write(c+1);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		for(int i = 0;i < len;i++){
			write(str.charAt(i+off));
		}
	}

	@Override
	public void write(char[] cbuf) throws IOException {
		write(cbuf,0,cbuf.length);
	}

	@Override
	public void write(String str) throws IOException {
		write(str,0,str.length());
	}
	
	

}
