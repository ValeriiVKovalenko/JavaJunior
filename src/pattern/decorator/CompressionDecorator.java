package pattern.decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator {
    private int comLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getComLevel() {
        return comLevel;
    }

    public void setComLevel(int comLevel) {
        this.comLevel = comLevel;
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {
        byte[] bytes = stringData.getBytes();

        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(comLevel));
            dos.write(bytes);
            dos.close();
            bout.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }

    private String decompress(String stringData) {
        byte[] bytes = Base64.getDecoder().decode(stringData);

        try {
            InputStream in = new ByteArrayInputStream(bytes);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int currentInt;

            while ((currentInt = iin.read()) != -1) {
                bout.write(currentInt);
            }
            in.close();
            iin.close();
            bout.close();
            return bout.toString();
        } catch (IOException ex) {
            return null;
        }
    }
}
