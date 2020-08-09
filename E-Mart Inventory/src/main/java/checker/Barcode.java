package checker;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class Barcode {
	public void generateEAN13BarcodeImage(String id) {
		try{
		
		Code128Bean code128 = new Code128Bean();
		code128.setHeight(15f);
		code128.setModuleWidth(0.3);
		code128.setQuietZone(10);
		code128.doQuietZone(true);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		code128.generateBarcode(canvas, id);
		canvas.finish();
		//write to png file
		FileOutputStream fos = new FileOutputStream("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/temp.png");
		fos.write(baos.toByteArray());
		fos.flush();
		fos.close();

}
		catch(Exception ex){
           System.out.println("Exception------------------------>  "+ex);
		}}
		}
