import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;
import com.spire.barcode.BarcodeScanner;
import com.spire.barcode.QRCodeECL;
import com.sun.javafx.print.Units;

public class Barcode {

    public static void main(String[] args) throws Exception {

        //创建BarcodeSettings实例
        BarcodeSettings settings = new BarcodeSettings();
        //设置条形码类型
        settings.setType(BarCodeType.Code_128);
        //设置条形码数据
        settings.setData("17130110001");
        //设置条形码显示数据
        settings.setData2D("17130110001");
        //在底部显示数据
        settings.setShowTextOnBottom(true);

        //创建BarCodeGenerator实例
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //根据settings生成图像数据，保存至BufferedImage实例
        BufferedImage bufferedImage = barCodeGenerator.generateImage();
        //保存为PNG图片
        ImageIO.write(bufferedImage, "png", new File("CODE128.png"));
        System.out.println("Complete!");

        String[] datas = BarcodeScanner.scan("CODE128.png", BarCodeType.Code_128);
        System.out.print(datas[0]);

    }
}
